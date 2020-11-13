/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityz.udru.controller;

import com.universityz.udru.model.entity.Majors;
import com.universityz.udru.model.message.MajorsChangeInfo;
import com.universityz.udru.model.message.MajorsResultMessage;
import com.universityz.udru.model.message.ResultMessage;
import com.universityz.udru.service.MajorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TheGrinm
 */
@RestController
@RequestMapping("/university-majors")
public class MajorsController {
    
    @Autowired
    private MajorsService majorsService;
    
    @GetMapping("/list")
    public ResultMessage list() {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("000");
        resultMessage.setReturnMessage("SUCCESS MAJORS CLASS");
        resultMessage.setData(majorsService.findAllMajors());
        return resultMessage;
    }
    
    @GetMapping("/delete-majors")
    public ResultMessage deleteMajors(@RequestParam int id){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("000");
        resultMessage.setReturnMessage("SUCCESS MAJORS CLASS");
        
        majorsService.deleteMajorsById(id);
        resultMessage.setData(majorsService.findAllMajors());
        return resultMessage;
    }
    
    @PostMapping("/add-majors")
    public ResultMessage addMajors(@RequestBody MajorsResultMessage majorsResultMessage){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("000");
        resultMessage.setReturnMessage("SUCCESS MAJORS CLASS");
        
        Majors majors = majorsService.saveMajors(majorsResultMessage);
        
        resultMessage.setData(majors);
        
        return resultMessage;
                
    }
    
    @PostMapping("/update-majors")
    public ResultMessage updateMajors(@RequestBody MajorsResultMessage majorsResultMessage){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("000");
        resultMessage.setReturnMessage("SUCCESS MAJORS CLASS");
        
        MajorsChangeInfo majorsChangeInfo = majorsService.updateMajors(majorsResultMessage);
        
        resultMessage.setData(majorsChangeInfo);
        
        return resultMessage;
    }
    
}
