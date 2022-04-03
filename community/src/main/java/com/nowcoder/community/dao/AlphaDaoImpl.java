package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alpha_h")
public class AlphaDaoImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
