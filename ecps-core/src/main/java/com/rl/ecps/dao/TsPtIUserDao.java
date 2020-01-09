package com.rl.ecps.dao;

import com.rl.ecps.model.TsPtlUser;

import java.util.List;
import java.util.Map;


public interface TsPtIUserDao {

    public TsPtlUser selectLogin(Map<String,Object> map);


}
