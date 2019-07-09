/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oldtoys.map;

import com.github.oldtoys.world.service.IGeoTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Slf4j
@Controller
@RequestMapping("/maps")
public class MapController {

    private String prefix = "map";

    @GetMapping("/world")
    public String vworld() {
        return prefix + "/world";
    }
    @GetMapping("/world-high")
    public String hworld() {
        return prefix + "/world_high";
    }
}
