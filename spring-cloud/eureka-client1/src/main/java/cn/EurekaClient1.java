package cn;

import cn.domain.SysUser;
import cn.repository.UserRepository;
import cn.serveice.UserService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Configuration
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableAsync
public class EurekaClient1 {


    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1.class, args);
    }


    @Value("${server.port}")
    String port;

    @RequestMapping(value = "hi")
    @HystrixCommand(fallbackMethod = "ierr")
    public  String home(@RequestParam(name = "name",defaultValue = "client节点")String name){
        return "终于调用成功了: " + name;
    }


    @RequestMapping(value = "special")
    public CompletableFuture<String> special(){
        return CompletableFuture.supplyAsync(() -> {
            return "异步返回成功";
        }).thenComposeAsync(ss -> CompletableFuture.supplyAsync(() -> {
            return ss + "是什么";
        }));
    }

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
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


    public String ierr(String name){
        return "出现了错误";
    }


    @Autowired
    UserService userService;

    private int list = 0;
    private Object lock = new Object();

    @RequestMapping(value = "list")
    @ResponseBody
    public List<SysUser> list(){
        list = list + 1;
        return userService.getList();
    }

    @RequestMapping(value = "getListNum")
    @ResponseBody
    public Integer getListNum(){
        return list;
    }

    @RequestMapping(value = "refershListNum")
    @ResponseBody
    public Integer refershListNum(){
        list = 0;
        return list;
    }

    @RequestMapping(value = "list1")
    @Async
    @ResponseBody
    public CompletableFuture<List<SysUser>> lists1(){
        return CompletableFuture.supplyAsync(() -> {
            return userService.getList();
        });

    }

}
