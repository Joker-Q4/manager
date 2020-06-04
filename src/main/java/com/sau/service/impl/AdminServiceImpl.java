package com.sau.service.impl;

import com.sau.entity.Admin;
import com.sau.mapper.AdminMapper;
import com.sau.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public Admin getAdmin(String account) {
        return adminMapper.queryAdminByAccount(account);
    }

    @Override
    public boolean addAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin) > 0;
    }
}
