/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "bambino")
@NamedQueries({
    @NamedQuery(name = "Bambino.findAll", query = "SELECT b FROM Bambino b"),
    @NamedQuery(name = "Bambino.findById", query = "SELECT b FROM Bambino b WHERE b.id = :id"),
    @NamedQuery(name = "Bambino.findByValutazioneBacino", query = "SELECT b FROM Bambino b WHERE b.valutazioneBacino = :valutazioneBacino"),
    @NamedQuery(name = "Bambino.findByCorsoPreparazioneParto", query = "SELECT b FROM Bambino b WHERE b.corsoPreparazioneParto = :corsoPreparazioneParto")})
public class Bambino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "valutazioneBacino")
    private String valutazioneBacino;
    @Column(name = "corsoPreparazioneParto")
    private String corsoPreparazioneParto;
    @Lob
    @Column(name = "luogoPrevistoParto")
    private String luogoPrevistoParto;
    @Lob
    @Column(name = "visitaFaseProdromica")
    private String visitaFaseProdromica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bambino")
    private List<Graficosinfisidelfondo> graficosinfisidelfondoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bambino")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Bambino() {
    }

    public Bambino(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValutazioneBacino() {
        return valutazioneBacino;
    }

    public void setValutazioneBacino(String valutazioneBacino) {
        this.valutazioneBacino = valutazioneBacino;
    }

    public String getCorsoPreparazioneParto() {
        return corsoPreparazioneParto;
    }

    public void setCorsoPreparazioneParto(String corsoPreparazioneParto) {
        this.corsoPreparazioneParto = corsoPreparazioneParto;
    }

    public String getLuogoPrevistoParto() {
        return luogoPrevistoParto;
    }

    public void setLuogoPrevistoParto(String luogoPrevistoParto) {
        this.luogoPrevistoParto = luogoPrevistoParto;
    }

    public String getVisitaFaseProdromica() {
        return visitaFaseProdromica;
    }

    public void setVisitaFaseProdromica(String visitaFaseProdromica) {
        this.visitaFaseProdromica = visitaFaseProdromica;
    }

    public List<Graficosinfisidelfondo> getGraficosinfisidelfondoList() {
        return graficosinfisidelfondoList;
    }

    public void setGraficosinfisidelfondoList(List<Graficosinfisidelfondo> graficosinfisidelfondoList) {
        this.graficosinfisidelfondoList = graficosinfisidelfondoList;
    }

    public List<Cartellaostetricadigitale> getCartellaostetricadigitaleList() {
        return cartellaostetricadigitaleList;
    }

    public void setCartellaostetricadigitaleList(List<Cartellaostetricadigitale> cartellaostetricadigitaleList) {
        this.cartellaostetricadigitaleList = cartellaostetricadigitaleList;
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
        if (!(object instanceof Bambino)) {
            return false;
        }
        Bambino other = (Bambino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Bambino[id=" + id + "]";
    }

}
