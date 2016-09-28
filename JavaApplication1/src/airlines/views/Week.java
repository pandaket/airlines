/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.views;

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
@Table(name = "week", catalog = "air", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Week.findAll", query = "SELECT w FROM Week w"),
    @NamedQuery(name = "Week.findById", query = "SELECT w FROM Week w WHERE w.id = :id"),
    @NamedQuery(name = "Week.findByWeeks", query = "SELECT w FROM Week w WHERE w.weeks = :weeks")})
public class Week implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "weeks")
    private String weeks;

    public Week() {
    }

    public Week(Integer id) {
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

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        String oldWeeks = this.weeks;
        this.weeks = weeks;
        changeSupport.firePropertyChange("weeks", oldWeeks, weeks);
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
        if (!(object instanceof Week)) {
            return false;
        }
        Week other = (Week) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "airlines.views.Week[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
