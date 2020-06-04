package com.sau.service.impl;

import com.sau.entity.SysSetting;
import com.sau.mapper.SysSettingMapper;
import com.sau.service.SysSettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("sysSettingService")
public class SysSettingServiceImpl implements SysSettingService {

    @Resource
    SysSettingMapper sysSettingMapper;

    @Override
    public String getValueByKey(String key) {
        return sysSettingMapper.findValueByKey(key);
    }

    @Override
    public Map<String, String> getAll() {
        Map<String, SysSetting> temp = sysSettingMapper.findAll();
        Map<String, String> result = new HashMap<>();
        for(String s : temp.keySet()){
            result.put(s, temp.get(s).getValue());
        }
        return result;
    }

}
