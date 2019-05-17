package com.github.fdc.generator;

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
    "com.github.fdc.generator.dao.**"
})
public class AdminUIApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminUIApplication.class, args);
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
