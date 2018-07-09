package com.hzy.dao;

import com.hzy.pojo.User;

public interface UserMapper {
    
    int deleteByPrimaryKey(Integer id);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    //查找用户通过名字
    User selectUserByName(Integer snumber);

    //查找用户通过id
    User selectByPrimaryKey(Integer id);
    
    void updateUserPassword(User user);
    
    
}