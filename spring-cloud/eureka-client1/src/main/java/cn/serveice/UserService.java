package cn.serveice;

import cn.domain.SysUser;
import cn.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;


    @HystrixCommand(fallbackMethod = "dlist")
    public List<SysUser> getList(){
        return userRepository.findAll();
    }

    public List<SysUser> dlist(){
        return new ArrayList<SysUser>();
    }
}
