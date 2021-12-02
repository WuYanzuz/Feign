package edu.jxut.server;

import edu.jxut.dao.GoodsMapper;
import edu.jxut.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServer {
    @Autowired
    private GoodsMapper goodsMapper;

    public Goods selectOne(String id){
       return goodsMapper.selectGood(id);
    }


}
