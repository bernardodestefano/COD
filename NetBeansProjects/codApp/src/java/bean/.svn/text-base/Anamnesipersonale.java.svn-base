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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "anamnesipersonale")
@NamedQueries({
    @NamedQuery(name = "Anamnesipersonale.findAll", query = "SELECT a FROM Anamnesipersonale a"),
    @NamedQuery(name = "Anamnesipersonale.findById", query = "SELECT a FROM Anamnesipersonale a WHERE a.id = :id"),
    @NamedQuery(name = "Anamnesipersonale.findByDiabete", query = "SELECT a FROM Anamnesipersonale a WHERE a.diabete = :diabete"),
    @NamedQuery(name = "Anamnesipersonale.findByObesita", query = "SELECT a FROM Anamnesipersonale a WHERE a.obesita = :obesita"),
    @NamedQuery(name = "Anamnesipersonale.findByMalattieInfettive", query = "SELECT a FROM Anamnesipersonale a WHERE a.malattieInfettive = :malattieInfettive"),
    @NamedQuery(name = "Anamnesipersonale.findByDisturbiAlimentari", query = "SELECT a FROM Anamnesipersonale a WHERE a.disturbiAlimentari = :disturbiAlimentari"),
    @NamedQuery(name = "Anamnesipersonale.findByMalattieEsantematiche", query = "SELECT a FROM Anamnesipersonale a WHERE a.malattieEsantematiche = :malattieEsantematiche"),
    @NamedQuery(name = "Anamnesipersonale.findByMalattieSessualmenteTrasmesse", query = "SELECT a FROM Anamnesipersonale a WHERE a.malattieSessualmenteTrasmesse = :malattieSessualmenteTrasmesse"),
    @NamedQuery(name = "Anamnesipersonale.findByInterventiChirurgici", query = "SELECT a FROM Anamnesipersonale a WHERE a.interventiChirurgici = :interventiChirurgici"),
    @NamedQuery(name = "Anamnesipersonale.findByAllergie", query = "SELECT a FROM Anamnesipersonale a WHERE a.allergie = :allergie"),
    @NamedQuery(name = "Anamnesipersonale.findByIncidentiTraumiFratture", query = "SELECT a FROM Anamnesipersonale a WHERE a.incidentiTraumiFratture = :incidentiTraumiFratture"),
    @NamedQuery(name = "Anamnesipersonale.findByAltro", query = "SELECT a FROM Anamnesipersonale a WHERE a.altro = :altro")})
public class Anamnesipersonale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "diabete")
    private Boolean diabete;
    @Column(name = "obesita")
    private Boolean obesita;
    @Column(name = "malattieInfettive")
    private Boolean malattieInfettive;
    @Column(name = "disturbiAlimentari")
    private Boolean disturbiAlimentari;
    @Column(name = "malattieEsantematiche")
    private Boolean malattieEsantematiche;
    @Column(name = "malattieSessualmenteTrasmesse")
    private Boolean malattieSessualmenteTrasmesse;
    @Column(name = "interventiChirurgici")
    private Boolean interventiChirurgici;
    @Column(name = "allergie")
    private Boolean allergie;
    @Column(name = "incidentiTraumiFratture")
    private Boolean incidentiTraumiFratture;
    @Column(name = "altro")
    private String altro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anamnesipersonale")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "anamnesipersonale")
    private Disturbi disturbi;

    public Anamnesipersonale() {
    }

    public Anamnesipersonale(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDiabete() {
        return diabete;
    }

    public void setDiabete(Boolean diabete) {
        this.diabete = diabete;
    }

    public Boolean getObesita() {
        return obesita;
    }

    public void setObesita(Boolean obesita) {
        this.obesita = obesita;
    }

    public Boolean getMalattieInfettive() {
        return malattieInfettive;
    }

    public void setMalattieInfettive(Boolean malattieInfettive) {
        this.malattieInfettive = malattieInfettive;
    }

    public Boolean getDisturbiAlimentari() {
        return disturbiAlimentari;
    }

    public void setDisturbiAlimentari(Boolean disturbiAlimentari) {
        this.disturbiAlimentari = disturbiAlimentari;
    }

    public Boolean getMalattieEsantematiche() {
        return malattieEsantematiche;
    }

    public void setMalattieEsantematiche(Boolean malattieEsantematiche) {
        this.malattieEsantematiche = malattieEsantematiche;
    }

    public Boolean getMalattieSessualmenteTrasmesse() {
        return malattieSessualmenteTrasmesse;
    }

    public void setMalattieSessualmenteTrasmesse(Boolean malattieSessualmenteTrasmesse) {
        this.malattieSessualmenteTrasmesse = malattieSessualmenteTrasmesse;
    }

    public Boolean getInterventiChirurgici() {
        return interventiChirurgici;
    }

    public void setInterventiChirurgici(Boolean interventiChirurgici) {
        this.interventiChirurgici = interventiChirurgici;
    }

    public Boolean getAllergie() {
        return allergie;
    }

    public void setAllergie(Boolean allergie) {
        this.allergie = allergie;
    }

    public Boolean getIncidentiTraumiFratture() {
        return incidentiTraumiFratture;
    }

    public void setIncidentiTraumiFratture(Boolean incidentiTraumiFratture) {
        this.incidentiTraumiFratture = incidentiTraumiFratture;
    }

    public String getAltro() {
        return altro;
    }

    public void setAltro(String altro) {
        this.altro = altro;
    }

    public List<Cartellaostetricadigitale> getCartellaostetricadigitaleList() {
        return cartellaostetricadigitaleList;
    }

    public void setCartellaostetricadigitaleList(List<Cartellaostetricadigitale> cartellaostetricadigitaleList) {
        this.cartellaostetricadigitaleList = cartellaostetricadigitaleList;
    }

    public Disturbi getDisturbi() {
        return disturbi;
    }

    public void setDisturbi(Disturbi disturbi) {
        this.disturbi = disturbi;
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
        if (!(object instanceof Anamnesipersonale)) {
            return false;
        }
        Anamnesipersonale other = (Anamnesipersonale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Anamnesipersonale[id=" + id + "]";
    }

}
