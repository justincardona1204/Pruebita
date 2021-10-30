/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo3.Reto3.Model.Client;
import usa.edu.ciclo3.Reto3.Repository.Crud.ClientCrud;


/**
 *
 * @author justi
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrud cliente; 
    
     //obtengo todos los registros de la tabla categoria
    public List<Client> getClients() {
        return (List<Client>) cliente.findAll();
    }
    //aqui me devuelve el id que seleccione y si no me devuelve otra cosa.
    public Optional<Client> getIdClient(int id) {
        return cliente.findById(id);
    }
    // en este guardo un registro de tipo categoria 
    public Client saveClient(Client objCli) {
        return cliente.save(objCli);

    }
    
     public void delClient(Client clientecito){
        cliente.delete(clientecito);
    }
    
}
