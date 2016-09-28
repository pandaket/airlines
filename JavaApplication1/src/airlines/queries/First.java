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
@Table(name = "first", catalog = "air", schema = "public")
@NamedQueries({
    @NamedQuery(name = "First.findAll", query = "SELECT f FROM First f"),
    @NamedQuery(name = "First.findById", query = "SELECT f FROM First f WHERE f.id = :id"),
    @NamedQuery(name = "First.findByDep", query = "SELECT f FROM First f WHERE f.dep = :dep"),
    @NamedQuery(name = "First.findByAir", query = "SELECT f FROM First f WHERE f.air = :air")})
public class First implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dep")
    private String dep;
    @Column(name = "air")
    private String air;

    public First() {
    }

    public First(Integer id) {
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

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        String oldDep = this.dep;
        this.dep = dep;
        changeSupport.firePropertyChange("dep", oldDep, dep);
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        String oldAir = this.air;
        this.air = air;
        changeSupport.firePropertyChange("air", oldAir, air);
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
        if (!(object instanceof First)) {
            return false;
        }
        First other = (First) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "airlines.queries.First[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
