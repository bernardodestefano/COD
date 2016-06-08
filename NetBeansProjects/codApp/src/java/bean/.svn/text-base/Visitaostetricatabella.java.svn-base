/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "visitaostetricatabella")
@NamedQueries({
    @NamedQuery(name = "Visitaostetricatabella.findAll", query = "SELECT v FROM Visitaostetricatabella v"),
    @NamedQuery(name = "Visitaostetricatabella.findById", query = "SELECT v FROM Visitaostetricatabella v WHERE v.id = :id"),
    @NamedQuery(name = "Visitaostetricatabella.findByPresentazione", query = "SELECT v FROM Visitaostetricatabella v WHERE v.presentazione = :presentazione"),
    @NamedQuery(name = "Visitaostetricatabella.findByLivelloPartePresentata", query = "SELECT v FROM Visitaostetricatabella v WHERE v.livelloPartePresentata = :livelloPartePresentata"),
    @NamedQuery(name = "Visitaostetricatabella.findByOsservazioni", query = "SELECT v FROM Visitaostetricatabella v WHERE v.osservazioni = :osservazioni"),
    @NamedQuery(name = "Visitaostetricatabella.findByConsigliPrescrizioni", query = "SELECT v FROM Visitaostetricatabella v WHERE v.consigliPrescrizioni = :consigliPrescrizioni")})
public class Visitaostetricatabella implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "presentazione")
    private String presentazione;
    @Column(name = "livelloPartePresentata")
    private String livelloPartePresentata;
    @Column(name = "osservazioni")
    private String osservazioni;
    @Column(name = "consigliPrescrizioni")
    private String consigliPrescrizioni;
    @JoinColumn(name = "visitaOstetrica_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Visitaostetrica visitaostetrica;

    public Visitaostetricatabella() {
    }

    public Visitaostetricatabella(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPresentazione() {
        return presentazione;
    }

    public void setPresentazione(String presentazione) {
        this.presentazione = presentazione;
    }

    public String getLivelloPartePresentata() {
        return livelloPartePresentata;
    }

    public void setLivelloPartePresentata(String livelloPartePresentata) {
        this.livelloPartePresentata = livelloPartePresentata;
    }

    public String getOsservazioni() {
        return osservazioni;
    }

    public void setOsservazioni(String osservazioni) {
        this.osservazioni = osservazioni;
    }

    public String getConsigliPrescrizioni() {
        return consigliPrescrizioni;
    }

    public void setConsigliPrescrizioni(String consigliPrescrizioni) {
        this.consigliPrescrizioni = consigliPrescrizioni;
    }

    public Visitaostetrica getVisitaostetrica() {
        return visitaostetrica;
    }

    public void setVisitaostetrica(Visitaostetrica visitaostetrica) {
        this.visitaostetrica = visitaostetrica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitaostetricatabella)) {
            return false;
        }
        Visitaostetricatabella other = (Visitaostetricatabella) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Visitaostetricatabella[id=" + id + "]";
    }

}
