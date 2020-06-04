package com.sau.mapper;

import com.sau.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    Admin queryAdminByAccount(String account);
    int insertAdmin(Admin admin);
}
