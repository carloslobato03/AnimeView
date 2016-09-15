/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31517072
 */
@Entity
@Table(name = "USERANIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAnime.findAll", query = "SELECT u FROM UserAnime u"),
    @NamedQuery(name = "UserAnime.findByIdUseranime", query = "SELECT u FROM UserAnime u WHERE u.idUseranime = :idUseranime"),
    @NamedQuery(name = "UserAnime.findByUsername", query = "SELECT u FROM UserAnime u WHERE u.username = :username"),
    @NamedQuery(name = "UserAnime.findByPassword", query = "SELECT u FROM UserAnime u WHERE u.password = :password")})
public class UserAnime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USERANIME")
    private Long idUseranime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "ID_USERANIME", referencedColumnName = "ID_USERINFO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserInfo userinfo;

    public UserAnime() {
    }

    public UserAnime(Long idUseranime) {
        this.idUseranime = idUseranime;
    }

    public UserAnime(Long idUseranime, String username, String password) {
        this.idUseranime = idUseranime;
        this.username = username;
        this.password = password;
    }

    public Long getIdUseranime() {
        return idUseranime;
    }

    public void setIdUseranime(Long idUseranime) {
        this.idUseranime = idUseranime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUseranime != null ? idUseranime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAnime)) {
            return false;
        }
        UserAnime other = (UserAnime) object;
        if ((this.idUseranime == null && other.idUseranime != null) || (this.idUseranime != null && !this.idUseranime.equals(other.idUseranime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Useranime[ idUseranime=" + idUseranime + " ]";
    }
    
}
