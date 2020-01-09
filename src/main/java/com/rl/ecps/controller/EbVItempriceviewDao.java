package com.rl.ecps.controller;

import com.rl.ecps.controller.EbVItempriceview;
import com.rl.ecps.controller.EbVItempriceviewExample;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.NotEmpty;

public interface EbVItempriceviewDao {
    long countByExample(EbVItempriceviewExample example);

    int deleteByExample(EbVItempriceviewExample example);

    int insert(EbVItempriceview record);

    int insertSelective(EbVItempriceview record);

    List<EbVItempriceview> selectByExample(EbVItempriceviewExample example);

    int updateByExampleSelective(@Param("record") EbVItempriceview record, @Param("example") EbVItempriceviewExample example);

    int updateByExample(@Param("record") EbVItempriceview record, @Param("example") EbVItempriceviewExample example);
}