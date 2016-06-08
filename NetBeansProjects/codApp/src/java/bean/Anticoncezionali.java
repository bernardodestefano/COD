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
@Table(name = "anticoncezionali")
@NamedQueries({
    @NamedQuery(name = "Anticoncezionali.findAll", query = "SELECT a FROM Anticoncezionali a"),
    @NamedQuery(name = "Anticoncezionali.findById", query = "SELECT a FROM Anticoncezionali a WHERE a.id = :id"),
    @NamedQuery(name = "Anticoncezionali.findByPillola", query = "SELECT a FROM Anticoncezionali a WHERE a.pillola = :pillola"),
    @NamedQuery(name = "Anticoncezionali.findByPillolaTipo", query = "SELECT a FROM Anticoncezionali a WHERE a.pillolaTipo = :pillolaTipo"),
    @NamedQuery(name = "Anticoncezionali.findByPillolaDurata", query = "SELECT a FROM Anticoncezionali a WHERE a.pillolaDurata = :pillolaDurata"),
    @NamedQuery(name = "Anticoncezionali.findByPillolaEffetti", query = "SELECT a FROM Anticoncezionali a WHERE a.pillolaEffetti = :pillolaEffetti"),
    @NamedQuery(name = "Anticoncezionali.findByIud", query = "SELECT a FROM Anticoncezionali a WHERE a.iud = :iud"),
    @NamedQuery(name = "Anticoncezionali.findByIUDTipo", query = "SELECT a FROM Anticoncezionali a WHERE a.iUDTipo = :iUDTipo"),
    @NamedQuery(name = "Anticoncezionali.findByIUDDurata", query = "SELECT a FROM Anticoncezionali a WHERE a.iUDDurata = :iUDDurata"),
    @NamedQuery(name = "Anticoncezionali.findByIUDEffetti", query = "SELECT a FROM Anticoncezionali a WHERE a.iUDEffetti = :iUDEffetti"),
    @NamedQuery(name = "Anticoncezionali.findByDiaframma", query = "SELECT a FROM Anticoncezionali a WHERE a.diaframma = :diaframma"),
    @NamedQuery(name = "Anticoncezionali.findByDiaframaTipo", query = "SELECT a FROM Anticoncezionali a WHERE a.diaframaTipo = :diaframaTipo"),
    @NamedQuery(name = "Anticoncezionali.findByDiaframmaDurata", query = "SELECT a FROM Anticoncezionali a WHERE a.diaframmaDurata = :diaframmaDurata"),
    @NamedQuery(name = "Anticoncezionali.findByDiaframmaEffetti", query = "SELECT a FROM Anticoncezionali a WHERE a.diaframmaEffetti = :diaframmaEffetti"),
    @NamedQuery(name = "Anticoncezionali.findByAltro", query = "SELECT a FROM Anticoncezionali a WHERE a.altro = :altro"),
    @NamedQuery(name = "Anticoncezionali.findByAltroTipo", query = "SELECT a FROM Anticoncezionali a WHERE a.altroTipo = :altroTipo"),
    @NamedQuery(name = "Anticoncezionali.findByAltroDurata", query = "SELECT a FROM Anticoncezionali a WHERE a.altroDurata = :altroDurata"),
    @NamedQuery(name = "Anticoncezionali.findByAltroEffetti", query = "SELECT a FROM Anticoncezionali a WHERE a.altroEffetti = :altroEffetti")})
public class Anticoncezionali implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pillola")
    private Boolean pillola;
    @Column(name = "pillolaTipo")
    private String pillolaTipo;
    @Column(name = "pillolaDurata")
    private Integer pillolaDurata;
    @Column(name = "pillolaEffetti")
    private String pillolaEffetti;
    @Column(name = "IUD")
    private Boolean iud;
    @Column(name = "IUDTipo")
    private String iUDTipo;
    @Column(name = "IUDDurata")
    private Integer iUDDurata;
    @Column(name = "IUDEffetti")
    private String iUDEffetti;
    @Column(name = "diaframma")
    private Boolean diaframma;
    @Column(name = "diaframaTipo")
    private String diaframaTipo;
    @Column(name = "diaframmaDurata")
    private Integer diaframmaDurata;
    @Column(name = "diaframmaEffetti")
    private String diaframmaEffetti;
    @Column(name = "altro")
    private Boolean altro;
    @Column(name = "altroTipo")
    private String altroTipo;
    @Column(name = "altroDurata")
    private Integer altroDurata;
    @Column(name = "altroEffetti")
    private String altroEffetti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anticoncezionali")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Anticoncezionali() {
    }

    public Anticoncezionali(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPillola() {
        return pillola;
    }

    public void setPillola(Boolean pillola) {
        this.pillola = pillola;
    }

    public String getPillolaTipo() {
        return pillolaTipo;
    }

    public void setPillolaTipo(String pillolaTipo) {
        this.pillolaTipo = pillolaTipo;
    }

    public Integer getPillolaDurata() {
        return pillolaDurata;
    }

    public void setPillolaDurata(Integer pillolaDurata) {
        this.pillolaDurata = pillolaDurata;
    }

    public String getPillolaEffetti() {
        return pillolaEffetti;
    }

    public void setPillolaEffetti(String pillolaEffetti) {
        this.pillolaEffetti = pillolaEffetti;
    }

    public Boolean getIud() {
        return iud;
    }

    public void setIud(Boolean iud) {
        this.iud = iud;
    }

    public String getIUDTipo() {
        return iUDTipo;
    }

    public void setIUDTipo(String iUDTipo) {
        this.iUDTipo = iUDTipo;
    }

    public Integer getIUDDurata() {
        return iUDDurata;
    }

    public void setIUDDurata(Integer iUDDurata) {
        this.iUDDurata = iUDDurata;
    }

    public String getIUDEffetti() {
        return iUDEffetti;
    }

    public void setIUDEffetti(String iUDEffetti) {
        this.iUDEffetti = iUDEffetti;
    }

    public Boolean getDiaframma() {
        return diaframma;
    }

    public void setDiaframma(Boolean diaframma) {
        this.diaframma = diaframma;
    }

    public String getDiaframaTipo() {
        return diaframaTipo;
    }

    public void setDiaframaTipo(String diaframaTipo) {
        this.diaframaTipo = diaframaTipo;
    }

    public Integer getDiaframmaDurata() {
        return diaframmaDurata;
    }

    public void setDiaframmaDurata(Integer diaframmaDurata) {
        this.diaframmaDurata = diaframmaDurata;
    }

    public String getDiaframmaEffetti() {
        return diaframmaEffetti;
    }

    public void setDiaframmaEffetti(String diaframmaEffetti) {
        this.diaframmaEffetti = diaframmaEffetti;
    }

    public Boolean getAltro() {
        return altro;
    }

    public void setAltro(Boolean altro) {
        this.altro = altro;
    }

    public String getAltroTipo() {
        return altroTipo;
    }

    public void setAltroTipo(String altroTipo) {
        this.altroTipo = altroTipo;
    }

    public Integer getAltroDurata() {
        return altroDurata;
    }

    public void setAltroDurata(Integer altroDurata) {
        this.altroDurata = altroDurata;
    }

    public String getAltroEffetti() {
        return altroEffetti;
    }

    public void setAltroEffetti(String altroEffetti) {
        this.altroEffetti = altroEffetti;
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
        if (!(object instanceof Anticoncezionali)) {
            return false;
        }
        Anticoncezionali other = (Anticoncezionali) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Anticoncezionali[id=" + id + "]";
    }

}
