/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Reservation;
import usa.edu.ciclo3.Reto3.Repository.ReservationRepository;


/**
 *
 * @author justi
 */
@Service
public class ReservationServices {
      @Autowired
    private ReservationRepository reservacion;

    public List<Reservation> getReservations() {
        return reservacion.getReservations();
    }

    public Optional<Reservation> getIdreservation(int id) {
        return reservacion.getIdReservation(id);
    }

    public Reservation saveReservation(Reservation objRe) {
        if (objRe.getIdReservation() == null) {
            return reservacion.saveReservation(objRe);
        } else {
            Optional<Reservation> reservationAux = reservacion.getIdReservation(objRe.getIdReservation());

            if (reservationAux.isEmpty()) {
                return reservacion.saveReservation(objRe);
            } else {
                return objRe;
            }
        }
    }
    
    public Reservation updateReservation(Reservation objR) {
        if (objR.getIdReservation() != null) { //Verifica si el id no está vacío

            //Crea un auxiliar en el que se guarda el id del elemento
            Optional<Reservation> ReservationAux = reservacion.getIdReservation(objR.getIdReservation());

            //Verifica que el id no sea vacío
            if (!ReservationAux.isEmpty()) {

                //Verifica que el nombre no sea vacío
                if (objR.getStartDate() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    ReservationAux.get().setStartDate(objR.getStartDate());
                }

                //Verifica que la descripción no sea vacía
                if (objR.getDevolutionDate() != null) {

                    //Busca la desc actual y la sobreescribe
                    ReservationAux.get().setDevolutionDate(objR.getDevolutionDate());
                }
                
                
                if (objR.getRoom() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    ReservationAux.get().setRoom(objR.getRoom());
                   
                }
                
                if (objR.getClient() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    ReservationAux.get().setClient(objR.getClient());
                   
                }
                
                
                
                
                
                

                //Guarda el valor actual de categoryAux
                reservacion.saveReservation(ReservationAux.get());

                //Retorna el valor de categoryAux
                return ReservationAux.get();
            } else {

                //Si name o description son vacios retorna el objeto original
                return objR;
            }
        } else {

            //Si el id es null retorna el objeto original
            return objR;
        }
    }

    public Boolean delReservation(Integer id) {
        Boolean objEliminar = getIdReservation(id).map(Reservation -> {
            reservacion.delReservation(Reservation);
            return true;
        }).orElse(false);
        return objEliminar;
    }
    
    
    
    
    
    

    public Optional<Reservation> getIdReservation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
