package com.example.demo.dao;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.item;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ShoppingDao {
    private final SqlSession sqlSession;

    @Autowired
    public ShoppingDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Result buyItem(String item,double price) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", item);
        paramMap.put("price", price);
        item temp = sqlSession.selectOne("com.example.demo.Mapper.ShoppingMapper.searchItem",paramMap);
        if (temp != null) {
            // 查询结果不为 null，执行后续操作
            return Result.success(temp);
        } else {
            // 查询结果为 null，可以添加相应的处理逻辑
            Result.error("erro");
        }
        return  null;
    }
}
