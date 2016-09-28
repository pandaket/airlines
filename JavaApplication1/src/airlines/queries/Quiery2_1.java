/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.queries;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Екатерина
 */
@Entity
@Table(name = "quiery2", catalog = "air", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Quiery2_1.findAll", query = "SELECT q FROM Quiery2_1 q"),
    @NamedQuery(name = "Quiery2_1.findByIdAirline", query = "SELECT q FROM Quiery2_1 q WHERE q.idAirline = :idAirline")})
public class Quiery2_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_airline")
    private Integer idAirline;

    public Quiery2_1() {
    }

    public Quiery2_1(Integer idAirline) {
        this.idAirline = idAirline;
    }

    public Integer getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Integer idAirline) {
        Integer oldIdAirline = this.idAirline;
        this.idAirline = idAirline;
        changeSupport.firePropertyChange("idAirline", oldIdAirline, idAirline);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAirline != null ? idAirline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiery2_1)) {
            return false;
        }
        Quiery2_1 other = (Quiery2_1) object;
        if ((this.idAirline == null && other.idAirline != null) || (this.idAirline != null && !this.idAirline.equals(other.idAirline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "airlines.queries.Quiery2_1[ idAirline=" + idAirline + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
