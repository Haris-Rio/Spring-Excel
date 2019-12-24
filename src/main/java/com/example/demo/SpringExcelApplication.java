package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringExcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExcelApplication.class, args);
		
	}
		
		@RequestMapping(value = "/excel", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE )
		public ResponseEntity<String> extractExcelMethod(@RequestParam("str") String str) throws FileNotFoundException {
			
			TechNetRequestData technetRequestData = new TechNetRequestData();
			List<TechNetData> techNetList = new ArrayList<TechNetData>();
			Map<String, List<String>> ffcTechMap = new HashMap<>();
			try {
			Scanner sc = new Scanner(new File(str));
			while (sc.hasNext()) {
				String a = sc.next();
				String[] arr = a.split(",");
				
				if(CollectionUtils.isEmpty(ffcTechMap.get(arr[0]))) {
					List<String> techIdList = new ArrayList<>();
					techIdList.add(arr[1]);
					ffcTechMap.put(arr[0], techIdList);
				}
				else
				{
					ffcTechMap.get(arr[0]).add(arr[1]);
				}
				
			}
			
			//List<TechNetData>  tech = new ArrayList<TechNetData>();
			for(Map.Entry<String, List<String>> m : ffcTechMap.entrySet()){
				String key = m.getKey();
				List<String> values = m.getValue();
				TechNetData ffcData = new TechNetData();
				ffcData.setFulfilmentCenter(key);
				ffcData.setTechId(values);
				
				techNetList.add(ffcData);
			}
			
			 System.out.println(techNetList);
			 technetRequestData.setTechNetDataList(techNetList);
			 sc.close();
			 return new ResponseEntity<String>(techNetList.toString(), HttpStatus.OK);
			
		} 
			catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		}

	}


