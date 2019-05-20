/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.importspby.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author nurzaenudin
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    public Data() {
    }
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("header")
    private List<List<Isiheader>> isiheader;
    
    @JsonProperty("body")
    public List<List<Body>> body;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<List<Isiheader>> getIsiheader() {
        return isiheader;
    }

    public void setIsiheader(List<List<Isiheader>> isiheader) {
        this.isiheader = isiheader;
    }

    public List<List<Body>> getBody() {
        return body;
    }

    public void setBody(List<List<Body>> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Data{" + "title=" + title + ", isiheader=" + isiheader + ", body=" + body + '}';
    }

    

    
    

    
    
    

    

    
    





    
    
    
}
