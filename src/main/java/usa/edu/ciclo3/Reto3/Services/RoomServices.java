/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Room;
import usa.edu.ciclo3.Reto3.Repository.RoomRepository;

/**
 *
 * @author justi
 */
@Service
public class RoomServices {
     @Autowired
    private RoomRepository reposroom;

    public List<Room> getRooms() {
        return reposroom.getRooms();
    }

    public Optional<Room> getId(int id) {
        return reposroom.getId(id);
    }

    public Room saveRoom(Room objR) {
        if (objR.getId() == null) {
            return reposroom.saveRoom(objR);
        } else {
            Optional<Room> roomAux = reposroom.getId(objR.getId());

            if (roomAux.isEmpty()) {
                return reposroom.saveRoom(objR);
            } else {
                return objR;
            }
        }
    }
    
      public Room updateRoom(Room objRoo) {
        if (objRoo.getId() != null) { //Verifica si el id no está vacío

            //Crea un auxiliar en el que se guarda el id del elemento
            Optional<Room> RoomAux = reposroom.getId(objRoo.getId());

            //Verifica que el id no sea vacío
            if (!RoomAux.isEmpty()) {

                //Verifica que el nombre no sea vacío
                if (objRoo.getName() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    RoomAux.get().setName(objRoo.getName());
                }

                //Verifica que la descripción no sea vacía
                if (objRoo.getHotel() != null) {

                    //Busca la desc actual y la sobreescribe
                    RoomAux.get().setHotel(objRoo.getHotel());
                }
                
                //Verifica que la descripción no sea vacía
                if (objRoo.getStars() != null) {

                    //Busca la desc actual y la sobreescribe
                    RoomAux.get().setStars(objRoo.getStars());
                }
                
                
                //Verifica que la descripción no sea vacía
                if (objRoo.getDescription() != null) {

                    //Busca la desc actual y la sobreescribe
                    RoomAux.get().setDescription(objRoo.getDescription());
                               
                 
                }
                
                  if (objRoo.getCategory() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    RoomAux.get().setCategory(objRoo.getCategory());
                   
                }
                
                if (objRoo.getMessages() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    RoomAux.get().setMessages(objRoo.getMessages());
                   
                }
                
                if (objRoo.getReservations() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    RoomAux.get().setReservations(objRoo.getReservations());
                   
                }
                
                
                
                
                
                
 
                //Guarda el valor actual de categoryAux
                reposroom.saveRoom(RoomAux.get());

                //Retorna el valor de categoryAux
                return RoomAux.get();
            } else {

                //Si name o description son vacios retorna el objeto original
                return objRoo;
            }
        } else {

            //Si el id es null retorna el objeto original
            return objRoo;
        }
    }

    public Boolean delRoom(Integer id) {
        Boolean objEliminar = getId(id).map(Room -> {
            reposroom.delRoom(Room);
            return true;
        }).orElse(false);
        return objEliminar;
    }
    
    
    
    
}
