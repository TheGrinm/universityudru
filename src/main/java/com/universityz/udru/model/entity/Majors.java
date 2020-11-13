/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universityz.udru.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SNRKK
 */
@Entity
@Table(name = "majors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Majors.findAll", query = "SELECT m FROM Majors m"),
    @NamedQuery(name = "Majors.findByNo", query = "SELECT m FROM Majors m WHERE m.no = :no"),
    @NamedQuery(name = "Majors.findByNameMajor", query = "SELECT m FROM Majors m WHERE m.nameMajor = :nameMajor"),
    @NamedQuery(name = "Majors.findByNumStudent", query = "SELECT m FROM Majors m WHERE m.numStudent = :numStudent")})
public class Majors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Column(name = "name_major")
    private String nameMajor;
    @Column(name = "num_student")
    private String numStudent;

    public Majors() {
    }

    public Majors(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getNameMajor() {
        return nameMajor;
    }

    public void setNameMajor(String nameMajor) {
        this.nameMajor = nameMajor;
    }

    public String getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(String numStudent) {
        this.numStudent = numStudent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Majors)) {
            return false;
        }
        Majors other = (Majors) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universityz.udru.model.entity.Majors[ no=" + no + " ]";
    }
    
}
