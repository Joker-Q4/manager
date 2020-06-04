package com.sau.mapper;

import com.sau.entity.SysSetting;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface SysSettingMapper {

    @Select("SELECT value FROM system_setting where key like CONCAT('%', #{key}, '%')")
    String findValueByKey(@Param("key") String key);

    @MapKey("key")
    @Select("SELECT * FROM system_setting")
    Map<String, SysSetting> findAll();
}
