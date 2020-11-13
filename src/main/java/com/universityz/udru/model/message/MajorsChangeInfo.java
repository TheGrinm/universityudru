/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityz.udru.model.message;

import com.universityz.udru.model.entity.Majors;
import java.io.Serializable;

/**
 *
 * @author TheGrinm
 */
public class MajorsChangeInfo implements Serializable{
    private Majors oldmaMajors;
    private Majors newmaMajors;

    /**
     * @return the oldmaMajors
     */
    public Majors getOldmaMajors() {
        return oldmaMajors;
    }

    /**
     * @param oldmaMajors the oldmaMajors to set
     */
    public void setOldmaMajors(Majors oldmaMajors) {
        this.oldmaMajors = oldmaMajors;
    }

    /**
     * @return the newmaMajors
     */
    public Majors getNewmaMajors() {
        return newmaMajors;
    }

    /**
     * @param newmaMajors the newmaMajors to set
     */
    public void setNewmaMajors(Majors newmaMajors) {
        this.newmaMajors = newmaMajors;
    }
    
}
