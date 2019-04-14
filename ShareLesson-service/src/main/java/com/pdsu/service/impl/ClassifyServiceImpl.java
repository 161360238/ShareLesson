package com.pdsu.service.impl;

import com.pdsu.mapper.ClassifyMapper;
import com.pdsu.mypojo.Result;
import com.pdsu.mypojo.ThreeResult;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.ClassifyExample;
import com.pdsu.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/18
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

    /**
     * 根据父id，查询子分类
     *
     * @param pid
     * @return
     */
    @Override
    public List<Classify> selectClassifyByPid(String pid) {
        List<Classify> classifies = new ArrayList<>();
        ClassifyExample classifyExample = new ClassifyExample();
        classifyExample.createCriteria().andPidEqualTo(pid);
        classifies = classifyMapper.selectByExample(classifyExample);
        if (classifies.size() > 0) {
            return classifies;
        }
        return null;
    }

    @Override
    public List<ThreeResult> loadData() {

        List<Classify> threeList = classifyMapper.selectByExample(null);

        List<ThreeResult> root = new ArrayList<ThreeResult>();
        Map<String,ThreeResult> map = new HashMap<String,ThreeResult>();
        for(Classify classify:threeList){
            map.put(classify.getClassifyId(),convertClass(classify,false));
        }
        for(Classify classify:threeList){
            Classify child = classify;//假设为子节点
            if("0".equals(child.getPid())){
                ClassifyExample example = new ClassifyExample();
                ClassifyExample.Criteria criteria = example.createCriteria();
                criteria.andPidEqualTo(child.getClassifyId());
                List<Classify> list = classifyMapper.selectByExample(example);
                if(list.size() == 0){
                    root.add(convertClass(child,false));
                }
            }else{
                ThreeResult father = map.get(child.getPid());
                father.getChildren().add(convertClass(child,false));
                if(!root.contains(father)){
                    root.add(father);
                }
            }
        }
        return root;
    }

    @Override
    public void update(Classify classify) {
        classifyMapper.updateByPrimaryKey(classify);
    }

    @Override
    public void add(Classify classify) {
        classify.setClassifyStatus(1);
        classify.setClassifyId(UUID.randomUUID().toString());
        if(classify.getPid().equals("0")){
            classify.setIsParent(1);
        }else{
            classify.setIsParent(0);
        }
        classifyMapper.insert(classify);
    }

    @Override
    public Result delete(String id) {

        Classify classify = classifyMapper.selectByPrimaryKey(id);

        ClassifyExample example = new ClassifyExample();
        ClassifyExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(classify.getClassifyId());
        List<Classify> Plist = classifyMapper.selectByExample(example);
        if(Plist.size() != 0){
            return new Result(false,"删除失败！");
        }
        classifyMapper.deleteByPrimaryKey(id);
        return new Result(true,"删除成功！");
    }


    /**
     * 转换类
     * @param classify
     * @param spread
     * @return
     */
    public ThreeResult  convertClass(Classify classify,boolean spread){
        ThreeResult threeResult = new ThreeResult();
        threeResult.setId(classify.getClassifyId());
        threeResult.setName(classify.getClassifyName());
        threeResult.setSpread(spread);
        return threeResult;
    }





}
