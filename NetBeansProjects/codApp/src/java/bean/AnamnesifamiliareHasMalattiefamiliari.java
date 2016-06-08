/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "anamnesifamiliare_has_malattiefamiliari")
@NamedQueries({
    @NamedQuery(name = "AnamnesifamiliareHasMalattiefamiliari.findAll", query = "SELECT a FROM AnamnesifamiliareHasMalattiefamiliari a"),
    @NamedQuery(name = "AnamnesifamiliareHasMalattiefamiliari.findByAnamnesiFamiliareid", query = "SELECT a FROM AnamnesifamiliareHasMalattiefamiliari a WHERE a.anamnesifamiliareHasMalattiefamiliariPK.anamnesiFamiliareid = :anamnesiFamiliareid"),
    @NamedQuery(name = "AnamnesifamiliareHasMalattiefamiliari.findByMalattieFamiliarinome", query = "SELECT a FROM AnamnesifamiliareHasMalattiefamiliari a WHERE a.anamnesifamiliareHasMalattiefamiliariPK.malattieFamiliarinome = :malattieFamiliarinome"),
    @NamedQuery(name = "AnamnesifamiliareHasMalattiefamiliari.findByFamiliare", query = "SELECT a FROM AnamnesifamiliareHasMalattiefamiliari a WHERE a.familiare = :familiare")})
public class AnamnesifamiliareHasMalattiefamiliari implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnamnesifamiliareHasMalattiefamiliariPK anamnesifamiliareHasMalattiefamiliariPK;
    @Column(name = "familiare")
    private String familiare;
    @Lob
    @Column(name = "inizioEDettagli")
    private String inizioEDettagli;
    @JoinColumn(name = "malattieFamiliari_nome", referencedColumnName = "nome", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Malattiefamiliari malattiefamiliari;
    @JoinColumn(name = "anamnesiFamiliare_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Anamnesifamiliare anamnesifamiliare;

    public AnamnesifamiliareHasMalattiefamiliari() {
    }

    public AnamnesifamiliareHasMalattiefamiliari(AnamnesifamiliareHasMalattiefamiliariPK anamnesifamiliareHasMalattiefamiliariPK) {
        this.anamnesifamiliareHasMalattiefamiliariPK = anamnesifamiliareHasMalattiefamiliariPK;
    }

    public AnamnesifamiliareHasMalattiefamiliari(int anamnesiFamiliareid, String malattieFamiliarinome) {
        this.anamnesifamiliareHasMalattiefamiliariPK = new AnamnesifamiliareHasMalattiefamiliariPK(anamnesiFamiliareid, malattieFamiliarinome);
    }

    public AnamnesifamiliareHasMalattiefamiliariPK getAnamnesifamiliareHasMalattiefamiliariPK() {
        return anamnesifamiliareHasMalattiefamiliariPK;
    }

    public void setAnamnesifamiliareHasMalattiefamiliariPK(AnamnesifamiliareHasMalattiefamiliariPK anamnesifamiliareHasMalattiefamiliariPK) {
        this.anamnesifamiliareHasMalattiefamiliariPK = anamnesifamiliareHasMalattiefamiliariPK;
    }

    public String getFamiliare() {
        return familiare;
    }

    public void setFamiliare(String familiare) {
        this.familiare = familiare;
    }

    public String getInizioEDettagli() {
        return inizioEDettagli;
    }

    public void setInizioEDettagli(String inizioEDettagli) {
        this.inizioEDettagli = inizioEDettagli;
    }

    public Malattiefamiliari getMalattiefamiliari() {
        return malattiefamiliari;
    }

    public void setMalattiefamiliari(Malattiefamiliari malattiefamiliari) {
        this.malattiefamiliari = malattiefamiliari;
    }

    public Anamnesifamiliare getAnamnesifamiliare() {
        return anamnesifamiliare;
    }

    public void setAnamnesifamiliare(Anamnesifamiliare anamnesifamiliare) {
        this.anamnesifamiliare = anamnesifamiliare;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anamnesifamiliareHasMalattiefamiliariPK != null ? anamnesifamiliareHasMalattiefamiliariPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnamnesifamiliareHasMalattiefamiliari)) {
            return false;
        }
        AnamnesifamiliareHasMalattiefamiliari other = (AnamnesifamiliareHasMalattiefamiliari) object;
        if ((this.anamnesifamiliareHasMalattiefamiliariPK == null && other.anamnesifamiliareHasMalattiefamiliariPK != null) || (this.anamnesifamiliareHasMalattiefamiliariPK != null && !this.anamnesifamiliareHasMalattiefamiliariPK.equals(other.anamnesifamiliareHasMalattiefamiliariPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.AnamnesifamiliareHasMalattiefamiliari[anamnesifamiliareHasMalattiefamiliariPK=" + anamnesifamiliareHasMalattiefamiliariPK + "]";
    }

}
