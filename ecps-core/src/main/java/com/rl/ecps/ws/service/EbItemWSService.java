package com.rl.ecps.ws.service;


import javax.jws.WebService;

@WebService
public interface EbItemWSService {
    public String publiclishService(Long itemId,String password) throws Exception;




}
