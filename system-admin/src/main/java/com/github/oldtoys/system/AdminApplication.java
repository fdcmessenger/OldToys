package com.github.oldtoys.system;

//import org.mybatis.spring.annotation.MapperScan;
import com.github.oldtoys.system.service.PasswordService;
import com.github.oldtoys.system.service.impl.DefaultPasswordServiceImpl;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@Controller
@MapperScan(basePackages = {
    "com.github.oldtoys.system.mapper.**"
})
@ComponentScan(basePackages = {"com.gitee.fdc", "com.github.oldtoys"})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @Bean
    public PasswordService getPasswordService() {
        return new DefaultPasswordServiceImpl();
    }

    @RequestMapping({"/index", "/", ""})
    public String index(Map<String, Object> map) {
        return "index";
    }
}
