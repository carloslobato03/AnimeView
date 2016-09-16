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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31517072
 */
@Entity
@Table(name = "CONTEUDOLISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conteudolista.findAll", query = "SELECT c FROM Conteudolista c"),
    @NamedQuery(name = "Conteudolista.findByIdConteudolista", query = "SELECT c FROM Conteudolista c WHERE c.idConteudolista = :idConteudolista")})
public class Conteudolista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTEUDOLISTA")
    private Long idConteudolista;
    @JoinColumn(name = "ID_CONTEUDOLISTA", referencedColumnName = "ID_ANIME", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Anime anime;
    @JoinColumn(name = "ID_CONTEUDOLISTA", referencedColumnName = "ID_LISTA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Listapessoal listapessoal;

    public Conteudolista() {
    }

    public Conteudolista(Long idConteudolista) {
        this.idConteudolista = idConteudolista;
    }

    public Long getIdConteudolista() {
        return idConteudolista;
    }

    public void setIdConteudolista(Long idConteudolista) {
        this.idConteudolista = idConteudolista;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Listapessoal getListapessoal() {
        return listapessoal;
    }

    public void setListapessoal(Listapessoal listapessoal) {
        this.listapessoal = listapessoal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConteudolista != null ? idConteudolista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conteudolista)) {
            return false;
        }
        Conteudolista other = (Conteudolista) object;
        if ((this.idConteudolista == null && other.idConteudolista != null) || (this.idConteudolista != null && !this.idConteudolista.equals(other.idConteudolista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Conteudolista[ idConteudolista=" + idConteudolista + " ]";
    }
    
}
