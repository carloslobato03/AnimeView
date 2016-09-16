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
@Table(name = "ANIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anime.findAll", query = "SELECT a FROM Anime a"),
    @NamedQuery(name = "Anime.findByIdAnime", query = "SELECT a FROM Anime a WHERE a.idAnime = :idAnime"),
    @NamedQuery(name = "Anime.findByIdApianime", query = "SELECT a FROM Anime a WHERE a.idApianime = :idApianime")})
public class Anime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANIME")
    private Long idAnime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ID_APIANIME")
    private String idApianime;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "anime")
    private Conteudolista conteudolista;

    public Anime() {
    }

    public Anime(Long idAnime) {
        this.idAnime = idAnime;
    }

    public Anime(Long idAnime, String idApianime) {
        this.idAnime = idAnime;
        this.idApianime = idApianime;
    }

    public Long getIdAnime() {
        return idAnime;
    }

    public void setIdAnime(Long idAnime) {
        this.idAnime = idAnime;
    }

    public String getIdApianime() {
        return idApianime;
    }

    public void setIdApianime(String idApianime) {
        this.idApianime = idApianime;
    }

    public Conteudolista getConteudolista() {
        return conteudolista;
    }

    public void setConteudolista(Conteudolista conteudolista) {
        this.conteudolista = conteudolista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnime != null ? idAnime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anime)) {
            return false;
        }
        Anime other = (Anime) object;
        if ((this.idAnime == null && other.idAnime != null) || (this.idAnime != null && !this.idAnime.equals(other.idAnime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Anime[ idAnime=" + idAnime + " ]";
    }
    
}
