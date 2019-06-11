package com.nurzaenudin.importspby;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nurzaenudin.importspby.DAO.SpbysaktiDao;
import com.nurzaenudin.importspby.entity.Spby;
import com.nurzaenudin.importspby.entity.Spbysakti;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ImportspbyApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ImportspbyApplication.class);

    @Autowired
    private SpbysaktiDao ssdao;
    
    @Autowired
    private ConfigurableApplicationContext context;

    public static void main(String[] args) {
        log.info("Aplikasi Mulai");
        SpringApplication.run(ImportspbyApplication.class, args);
        log.info("Aplikasi Selesai");
        
    }

    @Override
    public void run(String... args) {

        String alamatURL = "http://monsakti.kemenkeu.go.id/sitp-monsakti-omspan/webservice/SpbySetjen";
        // Spby spby = restTemplate.getForObject("http://monsakti.kemenkeu.go.id/sitp-monsakti-omspan/webservice/SpbySetjen", Spby.class);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c3IiOiJXZWJzZXJ2aWNlIFVzZXIiLCJ1aWQiOiJQQk4iLCJyb2wiOiJ3ZWJzZXJ2aWNlIiwia2RzIjoiV0VCUzI1Iiwia2RiIjoiIiwia2R0IjoiMjAxOSIsImlhdCI6MTU1NzEwOTkxMiwibmJmIjoxNTU3MTA5MzEyLCJraWQiOiIxMTAxIn0.Qq-6xGjBRXjZAoya8QDIzm0yyq47I7pypXabkCoBBBI");
        HttpEntity<String> entity = new HttpEntity<String>("body", header);
        ResponseEntity<String> res = restTemplate.exchange(alamatURL, HttpMethod.GET, entity, String.class);
        String responseSpby = res.getBody();
        //System.out.println(responseSpby);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Spby spby = mapper.readValue(responseSpby, Spby.class);
            //log.info(spby.toString());
            //System.out.println(spby.data.body.get(0));
            List a;
            a = spby.data.body;
//            int jumlahdata=a.size();
            int jumlahdata=100;
            for (int i = 0; i < jumlahdata; i++) {
//                System.out.println(a.get(i).toString());
                List b;
                b = (List) a.get(i);
//                  System.out.println(b.get(j).toString());
                String nourut = b.get(0).toString();

                String kodesatker = b.get(1).toString();

                String nospby = b.get(2).toString();

                Locale lokal = new Locale("en", "US");
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yy", lokal);
                Date tglspby = formatter2.parse(b.get(3).toString());

                String namasupplier = b.get(4).toString();

                String npwpsupplier = b.get(5).toString();

                String alamatsupplier = b.get(6).toString();

                Double nilai = Double.valueOf(b.get(7).toString().replace(",", ""));

                String akunpajak = b.get(8).toString();

                Double nilaipajak = Double.valueOf(b.get(9).toString().replace(",", ""));

                String nipppk = b.get(10).toString();

                String uraian = b.get(11).toString();

                Spbysakti ss = new Spbysakti();
                ss.setKodesatker(kodesatker);
                ss.setNomorspby(nospby);
                ss.setTglspby(tglspby);
                ss.setNamasupplier(namasupplier);
                ss.setNpwpsupplier(npwpsupplier);
                ss.setAlamatsupplier(alamatsupplier);
                ss.setNilai(nilai);
                ss.setAkunpajak(akunpajak);
                ss.setNilaipajak(nilaipajak);
                ss.setNipppk(nipppk);
                ss.setUraian(uraian);
                System.out.println(ss.toString());
                ssdao.save(ss);
            }

//           List q;
//           q = Arrays.asList(112, "672906", "00443/PB/672906/2019", "06-MAY-19", "PT Indocare Pacific", "025683442015000", "Jl Dr Saharjo No.45 Blok A No.55 GD Infinia Park Manggarai Tebet Jakarta Selatan", "4,000,000", "411124", "72,727", "197608261996021001", "sewa pengharum ruangan Pusintek periode April 2019");
//
//           List r;
//           r = Arrays.asList(111, "672906", "00443/PB/672906/2019", "06-MAY-19", "PT Indocare Pacific", "025683442015000", "Jl Dr Saharjo No.45 Blok A No.55 GD Infinia Park Manggarai Tebet Jakarta Selatan", "4,000,000", "411211", "363,636", "197608261996021001", "sewa pengharum ruangan Pusintek periode April 2019");
//
//               for (int i=0; i<r.size();i++)
//               {
//                   System.out.println(r.get(i).toString());
//               }
//           List a;
//           a = Arrays.asList(r, q);
//           for (int i = 0; i < a.size(); i++) {
//               List b;
//               b = (List) a.get(i);
//               System.out.println("++++++++++++");
//               for (int j = 0; j < b.size(); j++) {
//                   //System.out.println(b.get(j).toString());
//
//               }
//               System.out.println("********************");
//               System.out.println("urut " + b.get(0) + " === " + nourut);
//               System.out.println("kode satker " + b.get(1) + " === " + kodesatker);
//               System.out.println("no spby " + b.get(2) + " === " + nospby);
//               System.out.println("tgl spby " + b.get(3) + " === " + tglspby);
//               System.out.println("nama pt " + b.get(4) + " === " + namasupplier);
//               System.out.println("npwp pt " + b.get(5) + " === " + npwpsupplier);
//               System.out.println("alamat " + b.get(6) + " === " + alamatsupplier);
//               System.out.println("nilai " + b.get(7) + " === " + nilai);
//               System.out.println("akun pajak " + b.get(8) + " === " + akunpajak);
//               System.out.println("nilai pajak " + b.get(9) + " === " + nilaipajak);
//               System.out.println("nip ppk " + b.get(10) + " === " + nipppk);
//               System.out.println("uraian " + b.get(11) + " === " + uraian);
//               System.out.println("********************");
//           }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(ImportspbyApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.close();
    }

}
