package com.github.oldtoys;

//import org.mybatis.spring.annotation.MapperScan;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@Controller
@MapperScan(basePackages = {
    "com.github.oldtoys.dict.mapper.**",
    "com.github.oldtoys.gen.mapper.**"
})
@ComponentScan(basePackages = {"com.gitee.fdc", "com.github.oldtoys"})
public class DictApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictApplication.class, args);
    }

    @RequestMapping({"/index", "/", ""})
    public String index(Map<String, Object> map) {
        return "index";
    }
}
