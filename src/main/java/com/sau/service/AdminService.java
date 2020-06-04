package com.sau.service;

import com.sau.entity.Admin;

public interface AdminService {

    Admin getAdmin(String account);
    boolean addAdmin(Admin admin);
}
