package com.sau.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.MenuVo;
import com.sau.entity.SysMenu;
import com.sau.mapper.SysMenuMapper;
import com.sau.service.SysMenuService;
import com.sau.util.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

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
        map.put("homeInfo", JSONObject.parseObject("{'title': '首页', 'href': 'page/welcome-1.html'}"));
        map.put("logoInfo", JSONObject.parseObject("{'title': 'GYY', 'image': 'images/logo.png'}"));
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0L));
        return map;
    }
}
