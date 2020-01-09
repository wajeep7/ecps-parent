package com.rl.ecps.dao;

import com.rl.ecps.model.EbParaValue;

import java.util.List;

public interface EbPareValueDao {

    public void savePareValue(List<EbParaValue> ParaList,Long itemId);

}
