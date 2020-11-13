/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityz.udru.service;

import com.universityz.udru.model.entity.Majors;
import com.universityz.udru.model.message.MajorsChangeInfo;
import com.universityz.udru.model.message.MajorsResultMessage;
import com.universityz.udru.repository.MajorsRepo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TheGrinm
 */
@Service
public class MajorsService {
    
    @Autowired
    private MajorsRepo majorsRepo;

    public List<Majors> findAllMajors() {
        return majorsRepo.findAll();
    }

    public void deleteMajorsById(int id) {
        majorsRepo.deleteById(id);
    }

    public Majors saveMajors(MajorsResultMessage majorsResultMessage) {
        Majors majors = new Majors();
        majors.setNo(majorsResultMessage.getNo());
        majors.setNumStudent(majorsResultMessage.getNumStudent());
        majors.setNameMajor(majorsResultMessage.getNameMajor());
        
        majorsRepo.save(majors);
        
        return majors;
    }

    public MajorsChangeInfo updateMajors(MajorsResultMessage majorsResultMessage) {
        Majors oldMajors = majorsRepo.getOne(majorsResultMessage.getNo());
        if(oldMajors == null){
            return null;
        }
        
        MajorsChangeInfo majorsChangeInfo = new MajorsChangeInfo();
        
        Majors tempMajors = new Majors();
        BeanUtils.copyProperties(oldMajors, tempMajors);
        majorsChangeInfo.setOldmaMajors(tempMajors);
        
        oldMajors.setNo(majorsResultMessage.getNo());
        oldMajors.setNumStudent(majorsResultMessage.getNumStudent());
        oldMajors.setNameMajor(majorsResultMessage.getNameMajor());
        
        majorsRepo.save(oldMajors);
        
        tempMajors = new Majors();
        BeanUtils.copyProperties(oldMajors, tempMajors);
        majorsChangeInfo.setNewmaMajors(tempMajors);
        
        return majorsChangeInfo;
    }
}
