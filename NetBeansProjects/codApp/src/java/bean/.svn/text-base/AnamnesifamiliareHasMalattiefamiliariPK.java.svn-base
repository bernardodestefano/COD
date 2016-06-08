/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Lodato
 */
@Embeddable
public class AnamnesifamiliareHasMalattiefamiliariPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "anamnesiFamiliare_id")
    private int anamnesiFamiliareid;
    @Basic(optional = false)
    @Column(name = "malattieFamiliari_nome")
    private String malattieFamiliarinome;

    public AnamnesifamiliareHasMalattiefamiliariPK() {
    }

    public AnamnesifamiliareHasMalattiefamiliariPK(int anamnesiFamiliareid, String malattieFamiliarinome) {
        this.anamnesiFamiliareid = anamnesiFamiliareid;
        this.malattieFamiliarinome = malattieFamiliarinome;
    }

    public int getAnamnesiFamiliareid() {
        return anamnesiFamiliareid;
    }

    public void setAnamnesiFamiliareid(int anamnesiFamiliareid) {
        this.anamnesiFamiliareid = anamnesiFamiliareid;
    }

    public String getMalattieFamiliarinome() {
        return malattieFamiliarinome;
    }

    public void setMalattieFamiliarinome(String malattieFamiliarinome) {
        this.malattieFamiliarinome = malattieFamiliarinome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) anamnesiFamiliareid;
        hash += (malattieFamiliarinome != null ? malattieFamiliarinome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnamnesifamiliareHasMalattiefamiliariPK)) {
            return false;
        }
        AnamnesifamiliareHasMalattiefamiliariPK other = (AnamnesifamiliareHasMalattiefamiliariPK) object;
        if (this.anamnesiFamiliareid != other.anamnesiFamiliareid) {
            return false;
        }
        if ((this.malattieFamiliarinome == null && other.malattieFamiliarinome != null) || (this.malattieFamiliarinome != null && !this.malattieFamiliarinome.equals(other.malattieFamiliarinome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.AnamnesifamiliareHasMalattiefamiliariPK[anamnesiFamiliareid=" + anamnesiFamiliareid + ", malattieFamiliarinome=" + malattieFamiliarinome + "]";
    }

}
