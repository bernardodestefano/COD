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
@Table(name = "malattiefamiliari")
@NamedQueries({
    @NamedQuery(name = "Malattiefamiliari.findAll", query = "SELECT m FROM Malattiefamiliari m"),
    @NamedQuery(name = "Malattiefamiliari.findByNome", query = "SELECT m FROM Malattiefamiliari m WHERE m.nome = :nome")})
public class Malattiefamiliari implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "malattiefamiliari")
    private List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariList;

    public Malattiefamiliari() {
    }

    public Malattiefamiliari(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AnamnesifamiliareHasMalattiefamiliari> getAnamnesifamiliareHasMalattiefamiliariList() {
        return anamnesifamiliareHasMalattiefamiliariList;
    }

    public void setAnamnesifamiliareHasMalattiefamiliariList(List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariList) {
        this.anamnesifamiliareHasMalattiefamiliariList = anamnesifamiliareHasMalattiefamiliariList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Malattiefamiliari)) {
            return false;
        }
        Malattiefamiliari other = (Malattiefamiliari) object;
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Malattiefamiliari[nome=" + nome + "]";
    }

}
