package com.sau.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.MenuVo;
import com.sau.entity.SysMenu;
import com.sau.mapper.SysMenuMapper;
import com.sau.service.SysMenuService;
import com.sau.service.SysSettingService;
import com.sau.utils.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    SysMenuMapper sysMenuMapper;

    @Resource
    SysSettingService sysSettingService;

    @Override
    public Map<String, Object> menu() {
        Map<String, Object> map = new HashMap<>(16);
        List<SysMenu> menuList = sysMenuMapper.findAllByStatusOrderBySort(true);
        List<MenuVo> menuInfo = new ArrayList<>();
        for (SysMenu e : menuList) {
            MenuVo menuVO = new MenuVo();
            menuVO.setId(e.getId());
            menuVO.setPid(e.getPid());
            menuVO.setHref(e.getHref());
            menuVO.setTitle(e.getTitle());
            menuVO.setIcon(e.getIcon());
            menuVO.setTarget(e.getTarget());
            menuInfo.add(menuVO);
        }
        Map<String, String> temp = sysSettingService.getAll();
        /*map.put("homeInfo", JSONObject.parseObject("{'title': '"+sysSettingService.getValueByKey("home_title")+"', 'href': '"+sysSettingService.getValueByKey("home_href")+"'}"));
        map.put("logoInfo", JSONObject.parseObject("{'title': '"+sysSettingService.getValueByKey("logo_title")+"', 'image': '"+sysSettingService.getValueByKey("logo_href")+"'}"));
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0L));*/
        map.put("homeInfo", JSONObject.parseObject("{'title': '"+temp.get("home_title")+"', 'href': '"+temp.get("home_href")+"'}"));
        map.put("logoInfo", JSONObject.parseObject("{'title': '"+temp.get("logo_title")+"', 'image': '"+temp.get("logo_href")+"'}"));
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0L));
        return map;
    }
}
