package cn.controller;


import cn.server.HelloServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloServer helloServer;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam(name = "name")String name) {
        return helloServer.hiService(name);
    }

}
