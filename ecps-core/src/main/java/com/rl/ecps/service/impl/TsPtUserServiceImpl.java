package com.rl.ecps.service.impl;

import com.rl.ecps.dao.TsPtIUserDao;
import com.rl.ecps.model.TsPtlUser;
import com.rl.ecps.service.TsPtlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TsPtUserServiceImpl implements TsPtlUserService {
    @Autowired
    private TsPtIUserDao userDao;

    @Override
    public TsPtlUser selectLogin(Map<String, Object> map) {

        return userDao.selectLogin(map);
    }
}
