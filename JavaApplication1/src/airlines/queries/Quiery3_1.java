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
@Table(name = "quiery3", catalog = "air", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Quiery3_1.findAll", query = "SELECT q FROM Quiery3_1 q"),
    @NamedQuery(name = "Quiery3_1.findByCount", query = "SELECT q FROM Quiery3_1 q WHERE q.count = :count")})
public class Quiery3_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "count")
    private Long count;

    public Quiery3_1() {
    }

    public Quiery3_1(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        Long oldCount = this.count;
        this.count = count;
        changeSupport.firePropertyChange("count", oldCount, count);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (count != null ? count.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiery3_1)) {
            return false;
        }
        Quiery3_1 other = (Quiery3_1) object;
        if ((this.count == null && other.count != null) || (this.count != null && !this.count.equals(other.count))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "airlines.queries.Quiery3_1[ count=" + count + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
