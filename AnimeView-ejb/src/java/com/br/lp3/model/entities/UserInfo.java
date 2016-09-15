/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31517072
 */
@Entity
@Table(name = "USERINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u"),
    @NamedQuery(name = "UserInfo.findByIdUserinfo", query = "SELECT u FROM UserInfo u WHERE u.idUserinfo = :idUserinfo"),
    @NamedQuery(name = "UserInfo.findByNome", query = "SELECT u FROM UserInfo u WHERE u.nome = :nome"),
    @NamedQuery(name = "UserInfo.findByEmail", query = "SELECT u FROM UserInfo u WHERE u.email = :email"),
    @NamedQuery(name = "UserInfo.findByDnascimento", query = "SELECT u FROM UserInfo u WHERE u.dnascimento = :dnascimento")})
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USERINFO")
    private Long idUserinfo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "NOME")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DNASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dnascimento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userinfo")
    private UserAnime useranime;

    public UserInfo() {
    }

    public UserInfo(Long idUserinfo) {
        this.idUserinfo = idUserinfo;
    }

    public UserInfo(Long idUserinfo, String nome, String email) {
        this.idUserinfo = idUserinfo;
        this.nome = nome;
        this.email = email;
    }

    public Long getIdUserinfo() {
        return idUserinfo;
    }

    public void setIdUserinfo(Long idUserinfo) {
        this.idUserinfo = idUserinfo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDnascimento() {
        return dnascimento;
    }

    public void setDnascimento(Date dnascimento) {
        this.dnascimento = dnascimento;
    }

    public UserAnime getUseranime() {
        return useranime;
    }

    public void setUseranime(UserAnime useranime) {
        this.useranime = useranime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserinfo != null ? idUserinfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.idUserinfo == null && other.idUserinfo != null) || (this.idUserinfo != null && !this.idUserinfo.equals(other.idUserinfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Userinfo[ idUserinfo=" + idUserinfo + " ]";
    }
    
}
