package com.nace.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.nace.entity.NACEDetails;

public class CSVHelper {
	  public static String TYPE = "text/csv";
	  public static boolean hasCSVFormat(MultipartFile file) {
	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }
	    return true;
	  }
	  public static List<NACEDetails> csvToNACEDetails(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
	      List<NACEDetails> list = new ArrayList<NACEDetails>();
	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      for (CSVRecord csvRecord : csvRecords) {
	        NACEDetails details = new NACEDetails(
	              Long.parseLong(csvRecord.get("Order")),
	              csvRecord.get("Level"),
	              csvRecord.get("Code"),
	              csvRecord.get("Parent"),
	              csvRecord.get("Description"),
	              csvRecord.get("This item includes"),
	              csvRecord.get("This item also includes"),
	              csvRecord.get("Rulings"),
	              csvRecord.get("This item excludes"),
	              csvRecord.get("Reference to ISIC Rev. 4")
	            );
	        list.add(details);
	      }
	      return list;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
	}
