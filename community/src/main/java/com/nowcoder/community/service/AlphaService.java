package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype") 多实例
public class AlphaService {

    public AlphaService(){
        System.out.println("实例化");
    }

    @PostConstruct
    //在构造之后调用
    public void init(){
        System.out.println("初始化");
    }

    @PreDestroy
    //在销毁之前调用
    public void destory(){
        System.out.println("销毁");
    }

    @Autowired
    AlphaDao alphaDao;

    public String select(){
        return alphaDao.select();
    }

    @Autowired
    UserMapper userMapper;

    public Object save1(){
        //
        //新增
        User user = new User();
        
        return "ok";
    }




}
