/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author justi
 */
@Entity
@Table(name = "Messages")
public class Messages implements Serializable{
    
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     
     private Integer idMessage;
     private String messageText;
     
     
    //relacion tabla habitación
    @ManyToOne
    @JoinColumn (name = "id") //roomId
    @JsonIgnoreProperties({"messages" , "reservations" , "client"})//
    private Room room;
    
    //relacion tabla cliente
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages" , "reservations", "client"}) //"client" , "messages", "reservations"
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
     
     
     
     

    
     
    
    
    
}
