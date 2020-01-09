package com.rl.ecps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rl.ecps.dao.EbfeatureDao;
import com.rl.ecps.model.EbFeature;
import com.rl.ecps.service.EbFeatureService;

@Service
public class EbFeatureServiceImpl implements EbFeatureService {
    @Autowired
    private EbfeatureDao ebfeatureDao;

    @Override
    public List<EbFeature> selectFeaturegeneral() {

        return ebfeatureDao.selectFeaturegeneral();
    }

    @Override
    public List<EbFeature> selectFeatureIsSpec() {

        return ebfeatureDao.selectFeatureIsSpec();
    }

    @Override
    public List<EbFeature> selectFeatureIsSelect() {
        return ebfeatureDao.selectFeatureIsSelect();
    }


}
