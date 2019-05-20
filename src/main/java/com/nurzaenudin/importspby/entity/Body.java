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
public class Body {

    public Body() {
    }
    
    @JsonProperty("value")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        
        return "Body{" + "value=" + value + '}';
    }
    
    public String cetakSpby(){
        return "Cetak SPBY";
    }
    
    
    
}
