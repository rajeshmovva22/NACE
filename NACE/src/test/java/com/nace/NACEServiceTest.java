package com.nace;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.nace.entity.NACEDetails;
import com.nace.repository.NACEDetailsRepository;
import com.nace.service.NACEService;
import com.nace.service.impl.NACEServiceImpl;

@ExtendWith(MockitoExtension.class)
public class NACEServiceTest {

	@InjectMocks
    NACEService naceService = new NACEServiceImpl();
	
	@Mock
    NACEDetailsRepository naceDetailsRepository;
	
	NACEDetails naceDetails = new NACEDetails(1L, "3", "1.1", "1", "1", "Growing of non-perennial crops", "Growing of non-perennial crops", null, null, "111");
    
	
	@Test
    public void getNaceDetailsById() throws Exception {
        
        Mockito.when(naceDetailsRepository.findById(1L)).thenReturn(Optional.ofNullable(naceDetails));
        
        NACEDetails details = naceService.getNACEDetailsByOrderId(1L);
        
        assertNotNull(details);
    }
	
	
	@Test
    public void saveNaceDetails() throws Exception {
		ReflectionTestUtils.setField(naceService, "filePath", "C:\\Users\\rajes\\Downloads\\NACE_REV2_20220719_200749.csv");
		List<NACEDetails> list = new ArrayList<NACEDetails>();
		Mockito.when(naceDetailsRepository.saveAllAndFlush(Mockito.anyList())).thenReturn(list);
		List<NACEDetails> list1 = naceService.saveNACEDetails();
        assertEquals(list1.size(), list.size());
    }
	
}
