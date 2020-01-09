package com.rl.ecps.service.impl;

import com.rl.ecps.dao.EbAreaDao;
import com.rl.ecps.model.EbArea;
import com.rl.ecps.service.EbAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbAreaServiceImpl implements EbAreaService {

    @Autowired
    private EbAreaDao areaDao;


    @Override
    public List<EbArea> selectAreaByParentId(Long parentId) {

        return areaDao.selectAreaByParentId(parentId);
    }
}
