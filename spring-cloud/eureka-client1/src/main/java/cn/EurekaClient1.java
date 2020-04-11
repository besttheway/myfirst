package cn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Configuration
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
public class EurekaClient1 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1.class, args);
    }


    @Value("${server.port}")
    String port;

    @RequestMapping(value = "hi")
    public  String home(@RequestParam(name = "name",defaultValue = "client节点")String name){
        return "终于调用成功了: " + name;
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "getHi")
    public  String getHome(@RequestParam(value = "name", defaultValue = "forezp")String name){
        return restTemplate.getForObject("http://eureka-client1/hi?name="+name,String.class);
    }
}
