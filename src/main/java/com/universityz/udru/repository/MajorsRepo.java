/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityz.udru.repository;

import com.universityz.udru.model.entity.Majors;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author TheGrinm
 */
public interface MajorsRepo extends JpaRepository<Majors, Integer> {
    
}
