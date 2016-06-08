/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "storiaginecologica")
@NamedQueries({
    @NamedQuery(name = "Storiaginecologica.findAll", query = "SELECT s FROM Storiaginecologica s"),
    @NamedQuery(name = "Storiaginecologica.findById", query = "SELECT s FROM Storiaginecologica s WHERE s.id = :id"),
    @NamedQuery(name = "Storiaginecologica.findByPapTest", query = "SELECT s FROM Storiaginecologica s WHERE s.papTest = :papTest"),
    @NamedQuery(name = "Storiaginecologica.findByPapTestDataUltimo", query = "SELECT s FROM Storiaginecologica s WHERE s.papTestDataUltimo = :papTestDataUltimo"),
    @NamedQuery(name = "Storiaginecologica.findByPapTestEsito", query = "SELECT s FROM Storiaginecologica s WHERE s.papTestEsito = :papTestEsito"),
    @NamedQuery(name = "Storiaginecologica.findByColposcopia", query = "SELECT s FROM Storiaginecologica s WHERE s.colposcopia = :colposcopia"),
    @NamedQuery(name = "Storiaginecologica.findByColposcopiaData", query = "SELECT s FROM Storiaginecologica s WHERE s.colposcopiaData = :colposcopiaData"),
    @NamedQuery(name = "Storiaginecologica.findByPatalogiaMammella", query = "SELECT s FROM Storiaginecologica s WHERE s.patalogiaMammella = :patalogiaMammella"),
    @NamedQuery(name = "Storiaginecologica.findByInterventiChirurgici", query = "SELECT s FROM Storiaginecologica s WHERE s.interventiChirurgici = :interventiChirurgici")})
public class Storiaginecologica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "papTest")
    private Boolean papTest;
    @Column(name = "papTestDataUltimo")
    @Temporal(TemporalType.DATE)
    private Date papTestDataUltimo;
    @Column(name = "papTestEsito")
    private String papTestEsito;
    @Column(name = "colposcopia")
    private Boolean colposcopia;
    @Column(name = "colposcopiaData")
    @Temporal(TemporalType.DATE)
    private Date colposcopiaData;
    @Column(name = "patalogiaMammella")
    private Boolean patalogiaMammella;
    @Column(name = "interventiChirurgici")
    private String interventiChirurgici;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storiaginecologica")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Storiaginecologica() {
    }

    public Storiaginecologica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPapTest() {
        return papTest;
    }

    public void setPapTest(Boolean papTest) {
        this.papTest = papTest;
    }

    public Date getPapTestDataUltimo() {
        return papTestDataUltimo;
    }

    public void setPapTestDataUltimo(Date papTestDataUltimo) {
        this.papTestDataUltimo = papTestDataUltimo;
    }

    public String getPapTestEsito() {
        return papTestEsito;
    }

    public void setPapTestEsito(String papTestEsito) {
        this.papTestEsito = papTestEsito;
    }

    public Boolean getColposcopia() {
        return colposcopia;
    }

    public void setColposcopia(Boolean colposcopia) {
        this.colposcopia = colposcopia;
    }

    public Date getColposcopiaData() {
        return colposcopiaData;
    }

    public void setColposcopiaData(Date colposcopiaData) {
        this.colposcopiaData = colposcopiaData;
    }

    public Boolean getPatalogiaMammella() {
        return patalogiaMammella;
    }

    public void setPatalogiaMammella(Boolean patalogiaMammella) {
        this.patalogiaMammella = patalogiaMammella;
    }

    public String getInterventiChirurgici() {
        return interventiChirurgici;
    }

    public void setInterventiChirurgici(String interventiChirurgici) {
        this.interventiChirurgici = interventiChirurgici;
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
        if (!(object instanceof Storiaginecologica)) {
            return false;
        }
        Storiaginecologica other = (Storiaginecologica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Storiaginecologica[id=" + id + "]";
    }

}
