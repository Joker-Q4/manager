package com.sau.service;

import java.util.Map;

public interface SysSettingService {

    String getValueByKey(String key);
    Map<String, String> getAll();
}
