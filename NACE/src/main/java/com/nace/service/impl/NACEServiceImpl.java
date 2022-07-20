package com.nace.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nace.entity.NACEDetails;
import com.nace.repository.NACEDetailsRepository;
import com.nace.service.NACEService;
import com.nace.util.CSVHelper;

@Service("NACEService")
public class NACEServiceImpl implements NACEService{

	@Autowired
	private NACEDetailsRepository naceDetailsRepository;
	
	@Value("${nace.file.path}")
	private String filePath;
	
	@Override
	public List<NACEDetails> saveNACEDetails() throws Exception {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		List<NACEDetails> list =  CSVHelper.csvToNACEDetails(inputStream);
		List<NACEDetails> list1 = naceDetailsRepository.saveAllAndFlush(list);
		return list1;
		
	}

	@Override
	public NACEDetails getNACEDetailsByOrderId(Long id) throws Exception {
		Optional<NACEDetails> optional = naceDetailsRepository.findById(id);
		if(optional.isPresent()) {
    		return optional.get();
    	}
	throw new NoResultException("No record found"); 
	}

}
