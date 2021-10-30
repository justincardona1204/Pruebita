/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Messages;
import usa.edu.ciclo3.Reto3.Repository.MessagesRepository;

/**
 *
 * @author justi
 */
@Service
public class MessagesServices {
    
     @Autowired
    private MessagesRepository mensajes;

    public List<Messages> getMessages() {
        return mensajes.getMessages();
    }

    public Optional<Messages> getIdMessage(int id) {
        return mensajes.getIdMessage(id);
    }

    public Messages saveMessages(Messages objMes) {
        if (objMes.getIdMessage() == null) {
            return mensajes.saveMessages(objMes);
        } else {
            Optional<Messages> messageAux = mensajes.getIdMessage(objMes.getIdMessage());

            if (messageAux.isEmpty()) {
                return mensajes.saveMessages(objMes);
            } else {
                return objMes;
            }
        }
    }
    
    public Messages updateMessages(Messages objM) {
        if (objM.getIdMessage() != null) { //Verifica si el id no está vacío

            //Crea un auxiliar en el que se guarda el id del elemento
            Optional<Messages> MessageAux = mensajes.getIdMessage(objM.getIdMessage());

            //Verifica que el id no sea vacío
            if (!MessageAux.isEmpty()) {

                //Verifica que el nombre no sea vacío
                if (objM.getMessageText() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    MessageAux.get().setMessageText(objM.getMessageText());
                }
                
                if (objM.getRoom() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    MessageAux.get().setRoom(objM.getRoom());
                   
                }
                
                if (objM.getClient() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    MessageAux.get().setClient(objM.getClient());
                   
                }
                
                
        
                //Guarda el valor actual de categoryAux
                mensajes.saveMessages(MessageAux.get());

                //Retorna el valor de categoryAux
                return MessageAux.get();
            } else {

                //Si name o description son vacios retorna el objeto original
                return objM;
            }
        } else {

            //Si el id es null retorna el objeto original
            return objM;
        }
        
        
    }
    
   

    public Boolean delMessages(Integer id) {
        Boolean objEliminar = getIdMessage(id).map(Messages -> {
            mensajes.delMessages(Messages);
            return true;
        }).orElse(false);
        return objEliminar;
    }
    
    
    
    
    
    
}
