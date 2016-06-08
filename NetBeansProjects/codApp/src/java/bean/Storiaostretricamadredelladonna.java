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
@Table(name = "storiaostretricamadredelladonna")
@NamedQueries({
    @NamedQuery(name = "Storiaostretricamadredelladonna.findAll", query = "SELECT s FROM Storiaostretricamadredelladonna s"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findById", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.id = :id"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByNumeroFiglia", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.numeroFiglia = :numeroFiglia"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByEtaParto", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.etaParto = :etaParto"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByNumeriAborti", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.numeriAborti = :numeriAborti"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByNumeriParti", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.numeriParti = :numeriParti"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByPesoBambini", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.pesoBambini = :pesoBambini"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByAllattamentoModalita", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.allattamentoModalita = :allattamentoModalita"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByAtteggiamentoNeiConfrontiDelParto", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.atteggiamentoNeiConfrontiDelParto = :atteggiamentoNeiConfrontiDelParto"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByLuogoParto", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.luogoParto = :luogoParto"),
    @NamedQuery(name = "Storiaostretricamadredelladonna.findByDurataGravidanza", query = "SELECT s FROM Storiaostretricamadredelladonna s WHERE s.durataGravidanza = :durataGravidanza")})
public class Storiaostretricamadredelladonna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numeroFiglia")
    private Integer numeroFiglia;
    @Column(name = "etaParto")
    private Integer etaParto;
    @Column(name = "numeriAborti")
    private Integer numeriAborti;
    @Column(name = "numeriParti")
    private Integer numeriParti;
    @Column(name = "pesoBambini")
    private Double pesoBambini;
    @Column(name = "allattamentoModalita")
    private String allattamentoModalita;
    @Column(name = "atteggiamentoNeiConfrontiDelParto")
    private String atteggiamentoNeiConfrontiDelParto;
    @Column(name = "luogoParto")
    private String luogoParto;
    @Column(name = "durataGravidanza")
    private String durataGravidanza;
    @Lob
    @Column(name = "complicazioniPartoGravidanza")
    private String complicazioniPartoGravidanza;
    @Lob
    @Column(name = "osservazioni")
    private String osservazioni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storiaostretricamadredelladonna")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Storiaostretricamadredelladonna() {
    }

    public Storiaostretricamadredelladonna(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroFiglia() {
        return numeroFiglia;
    }

    public void setNumeroFiglia(Integer numeroFiglia) {
        this.numeroFiglia = numeroFiglia;
    }

    public Integer getEtaParto() {
        return etaParto;
    }

    public void setEtaParto(Integer etaParto) {
        this.etaParto = etaParto;
    }

    public Integer getNumeriAborti() {
        return numeriAborti;
    }

    public void setNumeriAborti(Integer numeriAborti) {
        this.numeriAborti = numeriAborti;
    }

    public Integer getNumeriParti() {
        return numeriParti;
    }

    public void setNumeriParti(Integer numeriParti) {
        this.numeriParti = numeriParti;
    }

    public Double getPesoBambini() {
        return pesoBambini;
    }

    public void setPesoBambini(Double pesoBambini) {
        this.pesoBambini = pesoBambini;
    }

    public String getAllattamentoModalita() {
        return allattamentoModalita;
    }

    public void setAllattamentoModalita(String allattamentoModalita) {
        this.allattamentoModalita = allattamentoModalita;
    }

    public String getAtteggiamentoNeiConfrontiDelParto() {
        return atteggiamentoNeiConfrontiDelParto;
    }

    public void setAtteggiamentoNeiConfrontiDelParto(String atteggiamentoNeiConfrontiDelParto) {
        this.atteggiamentoNeiConfrontiDelParto = atteggiamentoNeiConfrontiDelParto;
    }

    public String getLuogoParto() {
        return luogoParto;
    }

    public void setLuogoParto(String luogoParto) {
        this.luogoParto = luogoParto;
    }

    public String getDurataGravidanza() {
        return durataGravidanza;
    }

    public void setDurataGravidanza(String durataGravidanza) {
        this.durataGravidanza = durataGravidanza;
    }

    public String getComplicazioniPartoGravidanza() {
        return complicazioniPartoGravidanza;
    }

    public void setComplicazioniPartoGravidanza(String complicazioniPartoGravidanza) {
        this.complicazioniPartoGravidanza = complicazioniPartoGravidanza;
    }

    public String getOsservazioni() {
        return osservazioni;
    }

    public void setOsservazioni(String osservazioni) {
        this.osservazioni = osservazioni;
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
        if (!(object instanceof Storiaostretricamadredelladonna)) {
            return false;
        }
        Storiaostretricamadredelladonna other = (Storiaostretricamadredelladonna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Storiaostretricamadredelladonna[id=" + id + "]";
    }

    public static final String TIPOALLATTAMENTO_NATURALE ="naturale";
    public static final String TIPOALLATTAMENTO_ARTIFICIALE ="artificiale";

}
