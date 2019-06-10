/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.importspby.DAO;

import com.nurzaenudin.importspby.entity.Spbysakti;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author nurzaenudin
 */
public interface SpbysaktiDao extends CrudRepository<Spbysakti,String>{
    
}
