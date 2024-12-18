/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(schema="entities",name="Consumes")
@XmlRootElement
public class Consumes implements Serializable {
   
    
     private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ConsumesId id;
    
    @MapsId("animalGroupId")
    @ManyToOne
    private AnimalGroup animalGroup;
    
    @MapsId("productsId")
    @ManyToOne   
    private Product product;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    private Float consumeAmount;  
    
    
    public ConsumesId getId() {
        return id;
    }

    public Float getConsume() {
        return consumeAmount;
    }

    @XmlTransient
    public AnimalGroup getAnimalGroup() {
        return animalGroup;
    }
    
    @XmlTransient
    public Product getProduct() {
        return product;
    }

    public Date getDate() {
        return date;
    }

    public void setConsume(Float consume) {
        this.consumeAmount = consume;
    }

    public void setAnimalGroup(AnimalGroup animalGroup) {
        this.animalGroup = animalGroup;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public void setId(ConsumesId id) {
        this.id = id;
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
        if (!(object instanceof Consumes)) {
            return false;
        }
        Consumes other = (Consumes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Consumes[ consume=" + consumeAmount + " ]";
    }
    
}