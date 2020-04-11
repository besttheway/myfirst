package cn.controller;

import cn.controller.feigns.SchedualService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloController {
    @Autowired
    SchedualService schedualService;

    @GetMapping(value = "/hello")
    public String sayHi(@RequestParam(name = "name")String name) {
        return schedualService.home(name);
    }
}
