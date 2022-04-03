package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);//插入

    int updateStatus(int id, int status);//条件id ,更新状态

    int updateHeader(int id, String headerUrl);//条件id,更新头像路径

    int updatePassword(int id, String password);//条件id,更新密码

}
