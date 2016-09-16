/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31517072
 */
@Entity
@Table(name = "LISTAPESSOAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listapessoal.findAll", query = "SELECT l FROM Listapessoal l"),
    @NamedQuery(name = "Listapessoal.findByIdLista", query = "SELECT l FROM Listapessoal l WHERE l.idLista = :idLista")})
public class Listapessoal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LISTA")
    private Long idLista;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "listapessoal")
    private Conteudolista conteudolista;
    @JoinColumn(name = "ID_LISTA", referencedColumnName = "ID_USERANIME", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Useranime useranime;

    public Listapessoal() {
    }

    public Listapessoal(Long idLista) {
        this.idLista = idLista;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public Conteudolista getConteudolista() {
        return conteudolista;
    }

    public void setConteudolista(Conteudolista conteudolista) {
        this.conteudolista = conteudolista;
    }

    public Useranime getUseranime() {
        return useranime;
    }

    public void setUseranime(Useranime useranime) {
        this.useranime = useranime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listapessoal)) {
            return false;
        }
        Listapessoal other = (Listapessoal) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Listapessoal[ idLista=" + idLista + " ]";
    }
    
}
