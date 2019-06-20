/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.importspby.DAO;

import com.nurzaenudin.importspby.entity.Spbysakti;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author nurzaenudin
 */
public interface SpbysaktiDao extends PagingAndSortingRepository<Spbysakti,String>{
   
    @Query ("SELECT s FROM Spbysakti s WHERE s.nomorspby = ?1 AND akunpajak = ?2")
    List<Spbysakti> findByNomorspbyAndAkunpajak(String nomorspby, String akunpajak);
}
