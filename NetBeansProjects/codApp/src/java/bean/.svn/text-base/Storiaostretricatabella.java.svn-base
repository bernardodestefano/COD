/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "storiaostretricatabella")
@NamedQueries({
    @NamedQuery(name = "Storiaostretricatabella.findAll", query = "SELECT s FROM Storiaostretricatabella s"),
    @NamedQuery(name = "Storiaostretricatabella.findById", query = "SELECT s FROM Storiaostretricatabella s WHERE s.id = :id"),
    @NamedQuery(name = "Storiaostretricatabella.findByAnno", query = "SELECT s FROM Storiaostretricatabella s WHERE s.anno = :anno"),
    @NamedQuery(name = "Storiaostretricatabella.findByEtaGestionale", query = "SELECT s FROM Storiaostretricatabella s WHERE s.etaGestionale = :etaGestionale"),
    @NamedQuery(name = "Storiaostretricatabella.findByIvg", query = "SELECT s FROM Storiaostretricatabella s WHERE s.ivg = :ivg"),
    @NamedQuery(name = "Storiaostretricatabella.findByAbortoSpontaneo", query = "SELECT s FROM Storiaostretricatabella s WHERE s.abortoSpontaneo = :abortoSpontaneo"),
    @NamedQuery(name = "Storiaostretricatabella.findByTipoParto", query = "SELECT s FROM Storiaostretricatabella s WHERE s.tipoParto = :tipoParto"),
    @NamedQuery(name = "Storiaostretricatabella.findByLuogoParto", query = "SELECT s FROM Storiaostretricatabella s WHERE s.luogoParto = :luogoParto"),
    @NamedQuery(name = "Storiaostretricatabella.findByPesoBambino", query = "SELECT s FROM Storiaostretricatabella s WHERE s.pesoBambino = :pesoBambino"),
    @NamedQuery(name = "Storiaostretricatabella.findBySesso", query = "SELECT s FROM Storiaostretricatabella s WHERE s.sesso = :sesso"),
    @NamedQuery(name = "Storiaostretricatabella.findByCondizioniBambino", query = "SELECT s FROM Storiaostretricatabella s WHERE s.condizioniBambino = :condizioniBambino"),
    @NamedQuery(name = "Storiaostretricatabella.findByTipoAllattamento", query = "SELECT s FROM Storiaostretricatabella s WHERE s.tipoAllattamento = :tipoAllattamento"),
    @NamedQuery(name = "Storiaostretricatabella.findByDurataAllattamento", query = "SELECT s FROM Storiaostretricatabella s WHERE s.durataAllattamento = :durataAllattamento"),
    @NamedQuery(name = "Storiaostretricatabella.findByComplicazioniGravidanza", query = "SELECT s FROM Storiaostretricatabella s WHERE s.complicazioniGravidanza = :complicazioniGravidanza")})
public class Storiaostretricatabella implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "anno")
    private Integer anno;
    @Column(name = "etaGestionale")
    private Integer etaGestionale;
    @Column(name = "IVG")
    private Integer ivg;
    @Column(name = "abortoSpontaneo")
    private Boolean abortoSpontaneo;
    @Column(name = "tipoParto")
    private String tipoParto;
    @Column(name = "luogoParto")
    private String luogoParto;
    @Column(name = "pesoBambino")
    private Integer pesoBambino;
    @Column(name = "sesso")
    private String sesso;
    @Column(name = "condizioniBambino")
    private String condizioniBambino;
    @Column(name = "tipoAllattamento")
    private String tipoAllattamento;
    @Column(name = "durataAllattamento")
    @Temporal(TemporalType.TIME)
    private Date durataAllattamento;
    @Column(name = "complicazioniGravidanza")
    private String complicazioniGravidanza;
    @JoinColumn(name = "storiaOstetrica_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Storiaostetrica storiaostetrica;

    public Storiaostretricatabella() {
    }

    public Storiaostretricatabella(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Integer getEtaGestionale() {
        return etaGestionale;
    }

    public void setEtaGestionale(Integer etaGestionale) {
        this.etaGestionale = etaGestionale;
    }

    public Integer getIvg() {
        return ivg;
    }

    public void setIvg(Integer ivg) {
        this.ivg = ivg;
    }

    public Boolean getAbortoSpontaneo() {
        return abortoSpontaneo;
    }

    public void setAbortoSpontaneo(Boolean abortoSpontaneo) {
        this.abortoSpontaneo = abortoSpontaneo;
    }

    public String getTipoParto() {
        return tipoParto;
    }

    public void setTipoParto(String tipoParto) {
        this.tipoParto = tipoParto;
    }

    public String getLuogoParto() {
        return luogoParto;
    }

    public void setLuogoParto(String luogoParto) {
        this.luogoParto = luogoParto;
    }

    public Integer getPesoBambino() {
        return pesoBambino;
    }

    public void setPesoBambino(Integer pesoBambino) {
        this.pesoBambino = pesoBambino;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getCondizioniBambino() {
        return condizioniBambino;
    }

    public void setCondizioniBambino(String condizioniBambino) {
        this.condizioniBambino = condizioniBambino;
    }

    public String getTipoAllattamento() {
        return tipoAllattamento;
    }

    public void setTipoAllattamento(String tipoAllattamento) {
        this.tipoAllattamento = tipoAllattamento;
    }

    public Date getDurataAllattamento() {
        return durataAllattamento;
    }

    public void setDurataAllattamento(Date durataAllattamento) {
        this.durataAllattamento = durataAllattamento;
    }

    public String getComplicazioniGravidanza() {
        return complicazioniGravidanza;
    }

    public void setComplicazioniGravidanza(String complicazioniGravidanza) {
        this.complicazioniGravidanza = complicazioniGravidanza;
    }

    public Storiaostetrica getStoriaostetrica() {
        return storiaostetrica;
    }

    public void setStoriaostetrica(Storiaostetrica storiaostetrica) {
        this.storiaostetrica = storiaostetrica;
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
        if (!(object instanceof Storiaostretricatabella)) {
            return false;
        }
        Storiaostretricatabella other = (Storiaostretricatabella) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Storiaostretricatabella[id=" + id + "]";
    }



    public static final String TIPOSESSO_MASCHIO ="m";
    public static final String TIPOSESSO_FEMMINA ="f";
}
