package cn.controller.feigns;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@EnableCircuitBreaker
@FeignClient(value = "eurekaClient1", fallback = SchedualServiceImpl.class)
public interface SchedualService {

    @GetMapping(value = "hi")
    String home(@RequestParam(name = "name", defaultValue = "server节点")String name);
}
