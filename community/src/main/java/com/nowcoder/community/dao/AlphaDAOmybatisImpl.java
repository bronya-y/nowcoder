package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary//bean的优先装配
public class AlphaDAOmybatisImpl implements AlphaDao {

    @Override
    public String select() {
        return "MYBATIS";
    }
}
