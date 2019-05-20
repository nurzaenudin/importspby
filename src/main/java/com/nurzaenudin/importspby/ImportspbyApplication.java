package com.nurzaenudin.importspby;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nurzaenudin.importspby.entity.Spby;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ImportspbyApplication {
        private static final Logger log=LoggerFactory.getLogger(ImportspbyApplication.class);

	public static void main(String[] args){
            String alamat="http://monsakti.kemenkeu.go.id/sitp-monsakti-omspan/webservice/SpbySetjen";
            // Spby spby = restTemplate.getForObject("http://monsakti.kemenkeu.go.id/sitp-monsakti-omspan/webservice/SpbySetjen", Spby.class);
            RestTemplate restTemplate=new RestTemplate();
            HttpHeaders header= new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);
            header.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c3IiOiJXZWJzZXJ2aWNlIFVzZXIiLCJ1aWQiOiJQQk4iLCJyb2wiOiJ3ZWJzZXJ2aWNlIiwia2RzIjoiV0VCUzI1Iiwia2RiIjoiIiwia2R0IjoiMjAxOSIsImlhdCI6MTU1NzEwOTkxMiwibmJmIjoxNTU3MTA5MzEyLCJraWQiOiIxMTAxIn0.Qq-6xGjBRXjZAoya8QDIzm0yyq47I7pypXabkCoBBBI");
            HttpEntity<String> entity= new HttpEntity<String>("body",header);
            ResponseEntity<String> res = restTemplate.exchange(alamat, HttpMethod.GET,entity,String.class );
            String responseSpby= res.getBody();
            //System.out.println(responseSpby);
            ObjectMapper mapper = new ObjectMapper();
            try {
                Spby spby= mapper.readValue(responseSpby, Spby.class);
                log.info(spby.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
            
            //System.out.println("spby: "+ res);
            //log.info(spby.toString());
               
	}
        

        
       
       
                
            
        
      
        

}
