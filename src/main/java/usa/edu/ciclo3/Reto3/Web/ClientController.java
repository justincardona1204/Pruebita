/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.edu.ciclo3.Reto3.Model.Client;
import usa.edu.ciclo3.Reto3.Services.ClientServices;



/**
 *
 * @author justi
 */
@RestController
@RequestMapping("/api/Client") // /api/Client/save
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {
    
    
    @Autowired
    private ClientServices objClientService;

    @GetMapping("/all")
    public List<Client> getClients() {
        return objClientService.getClients(); 
    }

    @GetMapping({"/id"})
    public Optional<Client> getIdClient(@PathVariable("id") int id) {
        return objClientService.getIdClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client objCli) {
        return objClientService.saveClient(objCli);
    }

     //RETO4 
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client clientelito) {
        return objClientService.updateClient(clientelito);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delClient(@PathVariable Integer id) {
        return objClientService.delClient(id);
    }
    
    
}
