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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "storiapreconcezionale")
@NamedQueries({
    @NamedQuery(name = "Storiapreconcezionale.findAll", query = "SELECT s FROM Storiapreconcezionale s"),
    @NamedQuery(name = "Storiapreconcezionale.findById", query = "SELECT s FROM Storiapreconcezionale s WHERE s.id = :id"),
    @NamedQuery(name = "Storiapreconcezionale.findByGravidanzaDesiderataPrevista", query = "SELECT s FROM Storiapreconcezionale s WHERE s.gravidanzaDesiderataPrevista = :gravidanzaDesiderataPrevista"),
    @NamedQuery(name = "Storiapreconcezionale.findByGravidanzaImprevistaAccettazioneDonna", query = "SELECT s FROM Storiapreconcezionale s WHERE s.gravidanzaImprevistaAccettazioneDonna = :gravidanzaImprevistaAccettazioneDonna"),
    @NamedQuery(name = "Storiapreconcezionale.findByGravidanzaImprevistaAccettazionePartner", query = "SELECT s FROM Storiapreconcezionale s WHERE s.gravidanzaImprevistaAccettazionePartner = :gravidanzaImprevistaAccettazionePartner"),
    @NamedQuery(name = "Storiapreconcezionale.findByDifficoltaConcepimento", query = "SELECT s FROM Storiapreconcezionale s WHERE s.difficoltaConcepimento = :difficoltaConcepimento"),
    @NamedQuery(name = "Storiapreconcezionale.findByAccertamentiProvvedimenti", query = "SELECT s FROM Storiapreconcezionale s WHERE s.accertamentiProvvedimenti = :accertamentiProvvedimenti"),
    @NamedQuery(name = "Storiapreconcezionale.findByCondizioneCoppia", query = "SELECT s FROM Storiapreconcezionale s WHERE s.condizioneCoppia = :condizioneCoppia")})
public class Storiapreconcezionale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "gravidanzaDesiderataPrevista")
    private Boolean gravidanzaDesiderataPrevista;
    @Column(name = "gravidanzaImprevistaAccettazioneDonna")
    private Boolean gravidanzaImprevistaAccettazioneDonna;
    @Column(name = "gravidanzaImprevistaAccettazionePartner")
    private Boolean gravidanzaImprevistaAccettazionePartner;
    @Column(name = "difficoltaConcepimento")
    private Boolean difficoltaConcepimento;
    @Column(name = "accertamentiProvvedimenti")
    private String accertamentiProvvedimenti;
    @Column(name = "condizioneCoppia")
    private String condizioneCoppia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storiapreconcezionale")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Storiapreconcezionale() {
    }

    public Storiapreconcezionale(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getGravidanzaDesiderataPrevista() {
        return gravidanzaDesiderataPrevista;
    }

    public void setGravidanzaDesiderataPrevista(Boolean gravidanzaDesiderataPrevista) {
        this.gravidanzaDesiderataPrevista = gravidanzaDesiderataPrevista;
    }

    public Boolean getGravidanzaImprevistaAccettazioneDonna() {
        return gravidanzaImprevistaAccettazioneDonna;
    }

    public void setGravidanzaImprevistaAccettazioneDonna(Boolean gravidanzaImprevistaAccettazioneDonna) {
        this.gravidanzaImprevistaAccettazioneDonna = gravidanzaImprevistaAccettazioneDonna;
    }

    public Boolean getGravidanzaImprevistaAccettazionePartner() {
        return gravidanzaImprevistaAccettazionePartner;
    }

    public void setGravidanzaImprevistaAccettazionePartner(Boolean gravidanzaImprevistaAccettazionePartner) {
        this.gravidanzaImprevistaAccettazionePartner = gravidanzaImprevistaAccettazionePartner;
    }

    public Boolean getDifficoltaConcepimento() {
        return difficoltaConcepimento;
    }

    public void setDifficoltaConcepimento(Boolean difficoltaConcepimento) {
        this.difficoltaConcepimento = difficoltaConcepimento;
    }

    public String getAccertamentiProvvedimenti() {
        return accertamentiProvvedimenti;
    }

    public void setAccertamentiProvvedimenti(String accertamentiProvvedimenti) {
        this.accertamentiProvvedimenti = accertamentiProvvedimenti;
    }

    public String getCondizioneCoppia() {
        return condizioneCoppia;
    }

    public void setCondizioneCoppia(String condizioneCoppia) {
        this.condizioneCoppia = condizioneCoppia;
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
        if (!(object instanceof Storiapreconcezionale)) {
            return false;
        }
        Storiapreconcezionale other = (Storiapreconcezionale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Storiapreconcezionale[id=" + id + "]";
    }

}
