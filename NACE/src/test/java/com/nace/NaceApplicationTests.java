package com.nace;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nace.web.NACERestController;

@SpringBootTest
class NaceApplicationTests {

	@Autowired
    ObjectMapper mapper;
    
	@Autowired
    NACERestController naceRestController;
    
    
    @Test
    public void testsaveretreive() throws Exception {
    	Assertions.assertThat(naceRestController.putNaceDetails().getStatusCodeValue()).isEqualTo(200);
        org.assertj.core.api.Assertions.assertThat(naceRestController.getNaceDetails(1L).getStatusCodeValue()).isEqualTo(204);
        org.assertj.core.api.Assertions.assertThat(naceRestController.getNaceDetails(398482L).getStatusCodeValue()).isEqualTo(200);
    }
    

}
