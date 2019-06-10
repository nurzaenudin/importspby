/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.importspby.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;



/**
 *
 * @author nurzaenudin
 */

@Entity
public class Spbysakti {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false, length = 36)      
    private String id;
    
    @NotNull @NotEmpty
    private String kdsatker;
    
    @NotNull @NotEmpty
    private String nomorspby;
    
    @NotNull
    private double nilai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

     
    
    public String getKdsatker() {
        return kdsatker;
    }

    public void setKdsatker(String kdsatker) {
        this.kdsatker = kdsatker;
    }

    public String getNomorspby() {
        return nomorspby;
    }

    public void setNomorspby(String nomorspby) {
        this.nomorspby = nomorspby;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return "Spbysakti{" + "id=" + id + ", kdsatker=" + kdsatker + ", nomorspby=" + nomorspby + ", nilai=" + nilai + '}';
    }
    
    
            
}
