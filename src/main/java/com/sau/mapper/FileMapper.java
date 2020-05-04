package com.sau.mapper;

import com.sau.entity.FileBinding;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    FileBinding findFileBindingById(Integer id);
    FileBinding findFileBindingByName(String name);
    Integer findIdByName(String name);
    Integer insertFileBinding(FileBinding fileBinding);
}
