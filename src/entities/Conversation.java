/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Rafaa
 */
public class Conversation {
    
    private int id;
    private String nom;
    private XMLGregorianCalendar dateCreation;

    public Conversation() {
    }

    public Conversation(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Conversation(int id, String nom, XMLGregorianCalendar dateCreation) {
        this.id = id;
        this.nom = nom;
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public XMLGregorianCalendar getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(XMLGregorianCalendar dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Conversation{" + "id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conversation other = (Conversation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.dateCreation, other.dateCreation)) {
            return false;
        }
        return true;
    }
    
    
    
}
