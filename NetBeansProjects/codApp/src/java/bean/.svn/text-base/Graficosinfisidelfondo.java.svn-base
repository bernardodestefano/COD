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
@Table(name = "graficosinfisidelfondo")
@NamedQueries({
    @NamedQuery(name = "Graficosinfisidelfondo.findAll", query = "SELECT g FROM Graficosinfisidelfondo g"),
    @NamedQuery(name = "Graficosinfisidelfondo.findById", query = "SELECT g FROM Graficosinfisidelfondo g WHERE g.id = :id"),
    @NamedQuery(name = "Graficosinfisidelfondo.findBySettimana", query = "SELECT g FROM Graficosinfisidelfondo g WHERE g.settimana = :settimana"),
    @NamedQuery(name = "Graficosinfisidelfondo.findByCentimetri", query = "SELECT g FROM Graficosinfisidelfondo g WHERE g.centimetri = :centimetri")})
public class Graficosinfisidelfondo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "settimana")
    private Integer settimana;
    @Column(name = "centimetri")
    private Double centimetri;
    @JoinColumn(name = "bambino_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bambino bambino;

    public Graficosinfisidelfondo() {
    }

    public Graficosinfisidelfondo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSettimana() {
        return settimana;
    }

    public void setSettimana(Integer settimana) {
        this.settimana = settimana;
    }

    public Double getCentimetri() {
        return centimetri;
    }

    public void setCentimetri(Double centimetri) {
        this.centimetri = centimetri;
    }

    public Bambino getBambino() {
        return bambino;
    }

    public void setBambino(Bambino bambino) {
        this.bambino = bambino;
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
        if (!(object instanceof Graficosinfisidelfondo)) {
            return false;
        }
        Graficosinfisidelfondo other = (Graficosinfisidelfondo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Graficosinfisidelfondo[id=" + id + "]";
    }

}
