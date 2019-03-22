package com.pdsu.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


/**
 * @Auther: http://wangjie
 * @Date: 2019/3/22
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
public class sendSMS {
    public static void main(String[] args) {
        //连接超时及读取超时设置
        System.setProperty("sun.net.client.defaultConnectTimeout", "30000"); //连接超时：30秒
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");    //读取超时：30秒
        //新建一个StringBuffer链接
        StringBuffer buffer = new StringBuffer();
        String encode = "UTF-8";
        String username = "15938233625";  //用户名
        String password_md5 = "2BBE51E61DCFAD298A00FD6613D35181";  //密码
        String mobile = "15938233625";  //手机号
        String apikey = "a06c48cb5da748f42bc9e0249ade5ef5";  //apikey秘钥（
        String content = "您好，您的验证码是：12345【共享课堂】";  //要发送的短信内容，特别注意：签名必须设置，网页验证码应用需要加添加【图形识别码】。
        try {
            String contentUrlEncode = URLEncoder.encode(content,encode);  //对短信内容做Urlencode编码操作。注意：如            //把发送链接存入buffer中，如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
            buffer.append("http://115.28.23.78/api/send/index.php?username="+username+"&password_md5="+password_md5+"&mobile="+mobile+"&apikey="+apikey+"&content="+contentUrlEncode+"&encode="+encode);
            //System.out.println(buffer); //调试功能，输入完整的请求URL地址
            URL url = new URL(buffer.toString());   //把buffer链接存入新建的URL中
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();     //打开URL链接
            connection.setRequestMethod("POST");     //使用POST方式发送
            connection.setRequestProperty("Connection", "Keep-Alive");    //使用长链接方式
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));    //发送短信内容
            String result = reader.readLine();//获取返回值
            System.out.println(result); //输出result内容，查看返回值，成功为success，错误为error，详见该文档起始注释
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}