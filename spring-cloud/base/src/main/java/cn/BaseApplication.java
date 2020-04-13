package cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
@EnableHystrixDashboard
public class BaseApplication {
    @RequestMapping("/")
    public String home(){
        return "forward:/hystrix";
    }

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
