/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.importspby.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author nurzaenudin
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Spby {

    public Spby() {
    }
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("data")
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Spby{" + "status=" + status + ", data=" + data + '}';
    }

    
    
    
    
    
}
