package com.rl.ecps.service;

import com.rl.ecps.model.EbArea;

import java.util.List;

public interface EbAreaService {
    public List<EbArea> selectAreaByParentId(Long parentId);


}
