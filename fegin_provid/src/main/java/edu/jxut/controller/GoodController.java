package edu.jxut.controller;

import edu.jxut.domain.Goods;
import edu.jxut.server.GoodsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private GoodsServer goodsServer;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getGoods/{id}")
    public Goods getGoods(@PathVariable("id") String id){
        Goods goods = goodsServer.selectOne(id);
        goods.setTitle(goods.getTitle()+":"+port);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return goods;
    }


}
