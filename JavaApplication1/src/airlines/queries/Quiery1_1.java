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
@Table(name = "quiery1", catalog = "air", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Quiery1_1.findAll", query = "SELECT q FROM Quiery1_1 q"),
    @NamedQuery(name = "Quiery1_1.findById", query = "SELECT q FROM Quiery1_1 q WHERE q.id = :id"),
    @NamedQuery(name = "Quiery1_1.findByIdDeparture", query = "SELECT q FROM Quiery1_1 q WHERE q.idDeparture = :idDeparture"),
    @NamedQuery(name = "Quiery1_1.findByIdAirline", query = "SELECT q FROM Quiery1_1 q WHERE q.idAirline = :idAirline")})
public class Quiery1_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_departure")
    private Integer idDeparture;
    @Column(name = "id_airline")
    private Integer idAirline;

    public Quiery1_1() {
    }

    public Quiery1_1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(Integer idDeparture) {
        Integer oldIdDeparture = this.idDeparture;
        this.idDeparture = idDeparture;
        changeSupport.firePropertyChange("idDeparture", oldIdDeparture, idDeparture);
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiery1_1)) {
            return false;
        }
        Quiery1_1 other = (Quiery1_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "airlines.queries.Quiery1_1[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
