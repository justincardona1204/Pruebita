/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo3.Reto3.Model.Reservation;
import usa.edu.ciclo3.Reto3.Repository.Crud.ReservationCrud;


/**
 *
 * @author justi
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrud reservacion; 
    
     //obtengo todos los registros de la tabla categoria
    public List<Reservation> getReservations() {
        return (List<Reservation>) reservacion.findAll();
    }
    //aqui me devuelve el id que seleccione y si no me devuelve otra cosa.
    public Optional<Reservation> getIdReservation(int id) {
        return reservacion.findById(id);
    }
    // en este guardo un registro de tipo categoria 
    public Reservation saveReservation(Reservation objRe) {
        return reservacion.save(objRe);

    }
    
     public void delReservation(Reservation reservacioncita){
        reservacion.delete(reservacioncita);
    }
    
    
}
