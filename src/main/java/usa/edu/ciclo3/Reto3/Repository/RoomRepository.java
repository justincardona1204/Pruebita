/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo3.Reto3.Model.Room;
import usa.edu.ciclo3.Reto3.Repository.Crud.RoomCrud;

/**
 *
 * @author justi
 */
@Repository
public class RoomRepository {
    @Autowired
    private RoomCrud habitacion; 
    
     //obtengo todos los registros de la tabla categoria
    public List<Room> getRooms() {
        return (List<Room>) habitacion.findAll();
    }
    //aqui me devuelve el id que seleccione y si no me devuelve otra cosa.
    public Optional<Room> getId(int id) {
        return habitacion.findById(id);
    }
    // en este guardo un registro de tipo categoria 
    public Room saveRoom(Room objR) {
        return habitacion.save(objR);

    }
    
     public void delRoom(Room habitacioncita){
        habitacion.delete(habitacioncita);
    }
    
    
}
