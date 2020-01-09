package com.rl.ecps.service;

import com.rl.ecps.model.EbItem;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

public interface ImportSolrService {

    public void selectSorlFile() throws Exception;

}
