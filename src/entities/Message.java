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
public class Message {

    private int id;
    private String body;
    private boolean visible;
    private String file;
    private XMLGregorianCalendar dateEnvoi;

    public Message() {
    }

    public Message(int id, String body) {
        this.id = id;
        this.body = body;
    }

    public Message(int id, String body, boolean visible, String file, XMLGregorianCalendar dateEnvoi) {
        this.id = id;
        this.body = body;
        this.visible = visible;
        this.file = file;
        this.dateEnvoi = dateEnvoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public XMLGregorianCalendar getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(XMLGregorianCalendar dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", body=" + body + ", visible=" + visible + ", file=" + file + ", dateEnvoi=" + dateEnvoi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Message other = (Message) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.visible != other.visible) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        if (!Objects.equals(this.file, other.file)) {
            return false;
        }
        if (!Objects.equals(this.dateEnvoi, other.dateEnvoi)) {
            return false;
        }
        return true;
    }
    
    
    
}
