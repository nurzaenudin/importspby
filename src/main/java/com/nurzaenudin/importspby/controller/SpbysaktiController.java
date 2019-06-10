/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.importspby.controller;

import com.nurzaenudin.importspby.DAO.SpbysaktiDao;
import com.nurzaenudin.importspby.entity.Spbysakti;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nurzaenudin
 */
public class SpbysaktiController {
    @Autowired
    private SpbysaktiDao spbysaktidao;
    
    public void tambahSpbysakti(Spbysakti spbysakti) {
        spbysaktidao.save(spbysakti);
    }
}
