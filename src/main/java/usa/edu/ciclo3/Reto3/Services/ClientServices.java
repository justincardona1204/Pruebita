/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Client;
import usa.edu.ciclo3.Reto3.Repository.ClientRepository;


/**
 *
 * @author justi
 */
@Service
public class ClientServices {
     @Autowired
    private ClientRepository cliente;

    public List<Client> getClients() {
        return cliente.getClients();
    }

    public Optional<Client> getIdClient(int id) {
        return cliente.getIdClient(id);
    }

    public Client saveClient(Client objCli) {
        if (objCli.getIdClient() == null) {
            return cliente.saveClient(objCli);
        } else {
            Optional<Client> clientAux = cliente.getIdClient(objCli.getIdClient());

            if (clientAux.isEmpty()) {
                return cliente.saveClient(objCli);
            } else {
                return objCli;
            }
        }
    }
    
     public Client updateClient(Client objCl) {
        if (objCl.getIdClient() != null) { //Verifica si el id no está vacío

            //Crea un auxiliar en el que se guarda el id del elemento
            Optional<Client> clientAux = cliente.getIdClient(objCl.getIdClient());

            //Verifica que el id no sea vacío
            if (!clientAux.isEmpty()) {

                //Verifica que el nombre no sea vacío
                if (objCl.getEmail() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    clientAux.get().setEmail(objCl.getEmail());
                }

                //Verifica que la descripción no sea vacía
                if (objCl.getPassword() != null) {

                    //Busca la desc actual y la sobreescribe
                    clientAux.get().setPassword(objCl.getPassword());
                }
                
                //Verifica que la descripción no sea vacía
                if (objCl.getName() != null) {

                    //Busca la desc actual y la sobreescribe
                    clientAux.get().setName(objCl.getName());
                }
                
                
                //Verifica que la descripción no sea vacía
                if (objCl.getAge() != null) {

                    //Busca la desc actual y la sobreescribe
                    clientAux.get().setAge(objCl.getAge());
                }
                
                
                
                 if (objCl.getReservations() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    clientAux.get().setReservations(objCl.getReservations());
                   
                }
                
                
                
                
                if (objCl.getMessages() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    clientAux.get().setMessages(objCl.getMessages());
                   
                }
 
 
                //Guarda el valor actual de categoryAux
                cliente.saveClient(clientAux.get());

                //Retorna el valor de categoryAux
                return clientAux.get();
            } else {

                //Si name o description son vacios retorna el objeto original
                return objCl;
            }
        } else {

            //Si el id es null retorna el objeto original
            return objCl;
        }
    }

    public Boolean delClient(Integer id) {
        Boolean objEliminar = getIdClient(id).map(Client -> {
            cliente.delClient(Client);
            return true;
        }).orElse(false);
        return objEliminar;
    }
    
    
}
