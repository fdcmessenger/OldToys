package com.github.oldtoys.gen;

//import org.mybatis.spring.annotation.MapperScan;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@Controller
@MapperScan(basePackages = {
    "com.github.oldtoys.gen.mapper.**",
    "com.github.oldtoys.demo.mapper.**"
})
public class GenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenApplication.class, args);
    }
    
    @RequestMapping({"/index", "/", ""})
    public String index(Map<String, Object> map) {
        return "index";
        
    }

    @RequestMapping("/demo/{mapping}")
    public String subOthers(@PathVariable String mapping) {
        return "demo/" + mapping;
    }
}
