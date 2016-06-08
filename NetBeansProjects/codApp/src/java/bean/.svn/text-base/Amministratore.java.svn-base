/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "amministratore")
@NamedQueries({
    @NamedQuery(name = "Amministratore.findAll", query = "SELECT a FROM Amministratore a"),
    @NamedQuery(name = "Amministratore.findByCodiceFiscale", query = "SELECT a FROM Amministratore a WHERE a.codiceFiscale = :codiceFiscale"),
    @NamedQuery(name = "Amministratore.findByNome", query = "SELECT a FROM Amministratore a WHERE a.nome = :nome"),
    @NamedQuery(name = "Amministratore.findByCognome", query = "SELECT a FROM Amministratore a WHERE a.cognome = :cognome"),
    @NamedQuery(name = "Amministratore.findByIndirizzo", query = "SELECT a FROM Amministratore a WHERE a.indirizzo = :indirizzo"),
    @NamedQuery(name = "Amministratore.findByCellulare", query = "SELECT a FROM Amministratore a WHERE a.cellulare = :cellulare"),
    @NamedQuery(name = "Amministratore.findByEmail", query = "SELECT a FROM Amministratore a WHERE a.email = :email")})
public class Amministratore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codiceFiscale")
    private String codiceFiscale;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "indirizzo")
    private String indirizzo;
    @Basic(optional = false)
    @Column(name = "cellulare")
    private String cellulare;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "datiAutenticazione_username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Datiautenticazione datiautenticazione;

    public Amministratore() {
    }

    public Amministratore(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Amministratore(String codiceFiscale, String nome, String cognome, String cellulare, String email) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.cellulare = cellulare;
        this.email = email;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Datiautenticazione getDatiautenticazione() {
        return datiautenticazione;
    }

    public void setDatiautenticazione(Datiautenticazione datiautenticazione) {
        this.datiautenticazione = datiautenticazione;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiceFiscale != null ? codiceFiscale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amministratore)) {
            return false;
        }
        Amministratore other = (Amministratore) object;
        if ((this.codiceFiscale == null && other.codiceFiscale != null) || (this.codiceFiscale != null && !this.codiceFiscale.equals(other.codiceFiscale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Amministratore[codiceFiscale=" + codiceFiscale + "]";
    }

}
