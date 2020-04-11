package cn.controller.feigns;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceImpl implements SchedualService {

    @Override
    public String home(String name) {
        return "sorry +" + name;
    }
}
