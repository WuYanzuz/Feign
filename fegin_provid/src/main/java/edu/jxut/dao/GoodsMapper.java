package edu.jxut.dao;

import edu.jxut.domain.Goods;
import org.springframework.stereotype.Component;

@Component
public class GoodsMapper {

    public Goods selectGood(String id){
        return Goods.builder().price(19.9).title("长得快").build();
    }
}
