/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.importspby.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    private String kodesatker;
    
    @NotNull @NotEmpty
    private String nomorspby;
    
    @NotNull @Temporal(TemporalType.DATE)
    Date tglspby;
    
    @NotNull @NotEmpty
    private String namasupplier;
    
    @NotNull @NotEmpty @Column(length = 15)
    private String npwpsupplier;
    
    @NotNull @NotEmpty
    private String alamatsupplier;
      
    @NotNull
    private double nilai;
    
    private String akunpajak;
    
    @NotNull
    private double nilaipajak;
    
    private String nipppk;
    
    private String uraian;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKodesatker() {
        return kodesatker;
    }

    public void setKodesatker(String kodesatker) {
        this.kodesatker = kodesatker;
    }

    public String getNomorspby() {
        return nomorspby;
    }

    public void setNomorspby(String nomorspby) {
        this.nomorspby = nomorspby;
    }

    public Date getTglspby() {
        return tglspby;
    }

    public void setTglspby(Date tglspby) {
        this.tglspby = tglspby;
    }

    public String getNamasupplier() {
        return namasupplier;
    }

    public void setNamasupplier(String namasupplier) {
        this.namasupplier = namasupplier;
    }

    public String getNpwpsupplier() {
        return npwpsupplier;
    }

    public void setNpwpsupplier(String npwpsupplier) {
        this.npwpsupplier = npwpsupplier;
    }

    public String getAlamatsupplier() {
        return alamatsupplier;
    }

    public void setAlamatsupplier(String alamatsupplier) {
        this.alamatsupplier = alamatsupplier;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public String getAkunpajak() {
        return akunpajak;
    }

    public void setAkunpajak(String akunpajak) {
        this.akunpajak = akunpajak;
    }

    public double getNilaipajak() {
        return nilaipajak;
    }

    public void setNilaipajak(double nilaipajak) {
        this.nilaipajak = nilaipajak;
    }

    public String getNipppk() {
        return nipppk;
    }

    public void setNipppk(String nipppk) {
        this.nipppk = nipppk;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    @Override
    public String toString() {
        return "Spbysakti{" + "id=" + id + ", kodesatker=" + kodesatker + ", nomorspby=" + nomorspby + ", tglspby=" + tglspby + ", namasupplier=" + namasupplier + ", npwpsupplier=" + npwpsupplier + ", alamatsupplier=" + alamatsupplier + ", nilai=" + nilai + ", akunpajak=" + akunpajak + ", nilaipajak=" + nilaipajak + ", nipppk=" + nipppk + ", uraian=" + uraian + '}';
    }
    
    
    

    
    
    
    
            
}
