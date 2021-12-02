package edu.jxut.controller;

import edu.jxut.domain.Good;
import edu.jxut.fegin.GoodsFeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class GoodController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${rest.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GoodsFeginClient goodsFeginClient;

    @GetMapping("/goods/{id}")
    public Good findGoodById(@PathVariable("id") String id){
        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-PROVIDER");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        String port = String.valueOf(serviceInstance.getPort());
        URI uri = serviceInstance.getUri();
        String s = uri.toString();
        System.out.println(s);

        System.out.println(host);
        System.out.println(port);
        String lj="http://"+host+":"+port+"/goods/getGoods/id=1";

        Good good = restTemplate.getForObject(lj, Good.class);
        return good;
    }


    @GetMapping("/goods2/{id}")
    public Good findGoodById2(@PathVariable("id") String id){
        Good one = goodsFeginClient.findOne(id);
        return one;
    }
}
