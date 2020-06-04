package com.sau.controller;

import com.sau.entity.SysSetting;
import com.sau.service.SysMenuService;
import com.sau.service.SysSettingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class SysController {

    @Resource
    SysMenuService sysMenuService;

    @Resource
    SysSettingService sysSettingService;

    @GetMapping("/menu")
    public Map<String, Object> menu() {
        return sysMenuService.menu();
    }

    @GetMapping("/menu1")
    public Map<String, String> menu1() {
        return sysSettingService.getAll();
    }
}
