package com.sau.mapper;

import com.sau.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper {

    List<SysMenu> findAllByStatusOrderBySort(Boolean status);
}
