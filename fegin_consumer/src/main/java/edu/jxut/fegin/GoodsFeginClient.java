package edu.jxut.fegin;

import edu.jxut.config.FeginConfig;
import edu.jxut.domain.Good;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "EUREKA-PROVIDER",configuration = FeginConfig.class)
public interface GoodsFeginClient {

    @GetMapping("/goods/getGoods/{id}")
    public Good findOne(@PathVariable("id") String id);

}
