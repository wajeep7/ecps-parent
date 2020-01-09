package com.rl.ecps.dao;

import com.rl.ecps.model.EbArea;

import java.util.List;

public interface EbAreaDao {
    public List<EbArea> selectAreaByParentId(Long parentId);
}
