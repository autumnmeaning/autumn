package com.qfedu.service.impl;

import com.qfedu.dao.IRoleDao;
import com.qfedu.pojo.Role;
import com.qfedu.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleDao roleDao;

    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }
}
