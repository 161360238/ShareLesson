package com.pdsu.service.impl;

import com.pdsu.mapper.MessageMapper;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.Message;
import com.pdsu.pojo.MessageExample;
import com.pdsu.service.LessonService;
import com.pdsu.service.MessageService;
import com.pdsu.service.RedisService;
import com.pdsu.utils.CodecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/22
 * @Description: com.pdsu.service.impl
 * 短信
 * @version: 1.0
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private RedisService redisServiceImpl;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private LessonService lessonServiceImpl;

    /**
     * 发送短信
     *
     * @param phone
     * @return
     */
    @Override
    public Map<String, Object> messge(String phone) {
        //连接超时及读取超时设置
        System.setProperty("sun.net.client.defaultConnectTimeout", "30000"); //连接超时：30秒
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");    //读取超时：30秒
        //新建一个StringBuffer链接
        StringBuffer buffer = new StringBuffer();
        String encode = "UTF-8";
        String username = "15938233625";  //用户名
        String password_md5 = "2BBE51E61DCFAD298A00FD6613D35181";  //密码
        String mobile = phone;  //手机号
        String apikey = "a06c48cb5da748f42bc9e0249ade5ef5";  //apikey秘钥
        String code = randomCode();
        String content = "您好，您的验证码是：" + code + "【共享课堂】";  //要发送的短信内容，特别注意：签名必须设置，网页验证码应用需要加添加【图形识别码】。
        try {
            String contentUrlEncode = URLEncoder.encode(content, encode);  //对短信内容做Urlencode编码操作。注意：如            //把发送链接存入buffer中，如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
            buffer.append("http://115.28.23.78/api/send/index.php?username=" + username + "&password_md5=" + password_md5 + "&mobile=" + mobile + "&apikey=" + apikey + "&content=" + contentUrlEncode + "&encode=" + encode);
            //System.out.println(buffer); //调试功能，输入完整的请求URL地址
            URL url = new URL(buffer.toString());   //把buffer链接存入新建的URL中
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();     //打开URL链接
            connection.setRequestMethod("POST");     //使用POST方式发送
            connection.setRequestProperty("Connection", "Keep-Alive");    //使用长链接方式
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));    //发送短信内容
            String result = reader.readLine();//获取返回值
            //System.out.println(result); //输出result内容，查看返回值，成功为success，错误为error，详见该文档起始注释
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", code);
            String key = "messge_code:" + phone;
            redisServiceImpl.set(key, code); //短息存入redis
            redisServiceImpl.expire(key, 60 * 60 * 24 * 30);  //设置短信有效时间
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean verification(String phone, String code) {
        String key = "messge_code:" + phone;

        boolean hasKey = redisServiceImpl.exits(key);
        if (hasKey) {
            String code_Redis = redisServiceImpl.get(key);
            if (code.equals(code_Redis)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int insertNotice(Lesson lesson, int isOk) throws Exception {
        Message message = new Message();
        message.setCreated(new Date());
        message.setFromId("0");   //0表示系统通知
        message.setlId(lesson.getlId());

        if (isOk == 0) {   //通知开课失败
            message.setmId(CodecUtil.createUUID());
            String content1 = "尊敬的老师您好，非常抱歉 您创建的课程："
                    + lesson.getlName() + ",由于到报名截止日期 报名人数不足开课最低人数：" + lesson.getMiniNum()
                    + "人，所以开课失败。";//通知老师
            message.setOwnId(lesson.gettId());  //设置老师id（目标）
            message.setContent(content1);
            int index = messageMapper.insert(message);  //插入消息
            List<String> uids = lessonServiceImpl.selectUserByLesson(lesson.getlId());
            for (String uid : uids) {
                message.setmId(CodecUtil.createUUID());
                String content2 = "亲爱的的同学你好，非常抱歉 你参加的课程："
                        + lesson.getlName() + ",由于到报名截止日期 报名人数不足开课最低人数：" + lesson.getMiniNum()
                        + "人，所以开课失败。";//通知学生
                message.setOwnId(uid);  //设置学生id（目标）
                message.setContent(content2);
                index += messageMapper.insert(message);
            }
            if (index == 1 + uids.size()) {
                return 1;  //表示通知成功
            } else {
                throw new Exception("通知失败");
            }
        } else {    //通知开课成功
            message.setmId(CodecUtil.createUUID());
            String content1 = "尊敬的老师您好，恭喜你 您创建的课程："
                    + lesson.getlName() + ",到报名截止日期 报名人数高于开课最低人数：" + lesson.getMiniNum()
                    + "人，所以开课成功。";//通知老师
            message.setOwnId(lesson.gettId());  //设置老师id（目标）
            message.setContent(content1);
            int index = messageMapper.insert(message);  //插入消息
            List<String> uids = lessonServiceImpl.selectUserByLesson(lesson.getlId());
            for (String uid : uids) {
                message.setmId(CodecUtil.createUUID());
                String content2 = "亲爱的的同学你好，恭喜你 你参加的课程："
                        + lesson.getlName() + ",由于到报名截止日期 报名人数高于开课最低人数：" + lesson.getMiniNum()
                        + "人，所以开课成功，请按时去听课哦。";//通知学生
                message.setOwnId(uid);  //设置学生id（目标）
                message.setContent(content2);
                index += messageMapper.insert(message);
            }
            if (index == 1 + uids.size()) {
                return 1;  //表示通知成功
            } else {
                throw new Exception("通知失败");
            }
        }
    }

    /**
     * 查看消息
     *
     * @param uid
     * @param condition
     * @return
     */
    @Override
    public List<Message> selectMessage(String uid, int condition) {
        MessageExample messageExample = new MessageExample();
        List<Message> messages = new ArrayList<>();
        if (condition == 0) {   //表示已读
            messageExample.createCriteria().andStatusEqualTo(0)
                    .andOwnIdEqualTo(uid);
        } else if (condition == 2) {    //表示未读
            messageExample.createCriteria().andStatusEqualTo(1)
                    .andOwnIdEqualTo(uid);
        } else {   //已读和未读全查
            messageExample.createCriteria().andOwnIdEqualTo(uid);
        }
        messageExample.setOrderByClause("created DESC");
        messages = messageMapper.selectByExample(messageExample);
        if (messages != null && messages.size() > 0) {
            return messages;
        }
        return null;
    }

    @Override
    public int setMessageRead(String mid) {
        int index=0;
        Message message;
        message=messageMapper.selectByPrimaryKey(mid);
        if(message!=null){
            message.setStatus(1);  //1表示已读
            index=messageMapper.updateByPrimaryKey(message);
        }
        return index;
    }


    /**
     * @Description:生成六位随机数
     */
    public static String randomCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }
}
