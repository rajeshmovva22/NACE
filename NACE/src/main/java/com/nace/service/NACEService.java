package com.nace.service;

import java.util.List;

import com.nace.entity.NACEDetails;


public interface NACEService {

    public List<NACEDetails> saveNACEDetails() throws Exception;

    public NACEDetails getNACEDetailsByOrderId(Long id)  throws Exception;

}
