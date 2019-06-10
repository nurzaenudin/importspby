package com.nurzaenudin.importspby;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nurzaenudin.importspby.DAO.SpbysaktiDao;
import com.nurzaenudin.importspby.controller.SpbysaktiController;
import com.nurzaenudin.importspby.entity.Body;
import com.nurzaenudin.importspby.entity.Spby;
import com.nurzaenudin.importspby.entity.Data;
import com.nurzaenudin.importspby.entity.Spbysakti;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ImportspbyApplication{

    private static final Logger log = LoggerFactory.getLogger(ImportspbyApplication.class);
    
   
    public static void main(String[] args) {
        String alamat = "http://monsakti.kemenkeu.go.id/sitp-monsakti-omspan/webservice/SpbySetjen";
        // Spby spby = restTemplate.getForObject("http://monsakti.kemenkeu.go.id/sitp-monsakti-omspan/webservice/SpbySetjen", Spby.class);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c3IiOiJXZWJzZXJ2aWNlIFVzZXIiLCJ1aWQiOiJQQk4iLCJyb2wiOiJ3ZWJzZXJ2aWNlIiwia2RzIjoiV0VCUzI1Iiwia2RiIjoiIiwia2R0IjoiMjAxOSIsImlhdCI6MTU1NzEwOTkxMiwibmJmIjoxNTU3MTA5MzEyLCJraWQiOiIxMTAxIn0.Qq-6xGjBRXjZAoya8QDIzm0yyq47I7pypXabkCoBBBI");
        HttpEntity<String> entity = new HttpEntity<String>("body", header);
        ResponseEntity<String> res = restTemplate.exchange(alamat, HttpMethod.GET, entity, String.class);
        String responseSpby = res.getBody();
        //System.out.println(responseSpby);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Spby spby = mapper.readValue(responseSpby, Spby.class);
            log.info(spby.toString());
            System.out.println(spby.data.body.get(0));
            List s;
            s = spby.data.body.get(0);
            for (int i = 0; i < s.size(); i++) {
                System.out.println(s.get(i).toString());
            }
            System.out.println("==============");
            System.out.println(s.get(2).toString());
            System.out.println("==============");

            List q;
            q = Arrays.asList(112, "672906", "00443/PB/672906/2019", "06-MAY-19", "PT Indocare Pacific", "025683442015000", "Jl Dr Saharjo No.45 Blok A No.55 GD Infinia Park Manggarai Tebet Jakarta Selatan", "4,000,000", "411124", "72,727", "197608261996021001", "sewa pengharum ruangan Pusintek periode April 2019");

            List r;
            r = Arrays.asList(111, "672906", "00443/PB/672906/2019", "06-MAY-19", "PT Indocare Pacific", "025683442015000", "Jl Dr Saharjo No.45 Blok A No.55 GD Infinia Park Manggarai Tebet Jakarta Selatan", "4,000,000", "411211", "363,636", "197608261996021001", "sewa pengharum ruangan Pusintek periode April 2019");

//                for (int i=0; i<r.size();i++)
//                {
//                    System.out.println(r.get(i).toString());
//                }
            List a;
            a = Arrays.asList(r, q);
            for (int i = 0; i < a.size(); i++) {
                List b;
                b = (List) a.get(i);
                System.out.println("++++++++++++");
                for (int j = 0; j < b.size(); j++) {
                    //System.out.println(b.get(j).toString());

                }
                
                System.out.println("********************");
                System.out.println("urut "+b.get(0));
                System.out.println("kode satker "+b.get(1));
                System.out.println("no spby "+b.get(2));
                System.out.println("tgl spby "+b.get(3));
                System.out.println("nama pt "+b.get(4));
                System.out.println("npwp pt "+b.get(5));
                System.out.println("alamat "+b.get(6));
                System.out.println("nilai "+b.get(7));
                System.out.println("akun pajak "+b.get(8));
                System.out.println("nilai pajak "+b.get(9));
                System.out.println("nip ppk "+b.get(10));
                System.out.println("urain "+b.get(11));
                System.out.println("********************");
                        
                Spbysakti ss = new Spbysakti();
                ss.setKdsatker(b.get(1).toString());
                ss.setNomorspby(b.get(2).toString());
                String nilai;
                nilai = b.get(7).toString().replace(",", "");
                ss.setNilai(Double.valueOf(nilai));
                System.out.println(ss.toString());
                
                
               
            
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("spby: "+ res);
        //log.info(spby.toString());
    }
    
    

}
