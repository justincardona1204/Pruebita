/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo3.Reto3.Model.Messages;
import usa.edu.ciclo3.Reto3.Repository.Crud.MessagesCrud;


/**
 *
 * @author justi
 */
@Repository
public class MessagesRepository {
    
    @Autowired
    private MessagesCrud mensajes; 
    
     //obtengo todos los registros de la tabla categoria
    public List<Messages> getMessages() {
        return (List<Messages>) mensajes.findAll();
    }
    //aqui me devuelve el id que seleccione y si no me devuelve otra cosa.
    public Optional<Messages> getIdMessage(int id) {
        return mensajes.findById(id);
    }
    // en este guardo un registro de tipo categoria 
    public Messages saveMessages(Messages objMes) {
        return mensajes.save(objMes);

    }
    
     public void delMessages(Messages mensajito){
        mensajes.delete(mensajito);
    }
    
    
}
