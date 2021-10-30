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
import usa.edu.ciclo3.Reto3.Model.Admin;
import usa.edu.ciclo3.Reto3.Services.AdminServices;





/**
 *
 * @author justi
 */
@RestController
@RequestMapping("/api/Admin") // /api/Admin/save
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {
    
      
    @Autowired
    private AdminServices objAdminService;

    @GetMapping("/all")
    public List<Admin> getAdmins() {
        return objAdminService.getAdmins(); 
    }

    @GetMapping({"/id"})
    public Optional<Admin> getIdAdmin(@PathVariable("id") int id) {
        return objAdminService.getIdAdmin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin saveAdmin(@RequestBody Admin objAd) {
        return objAdminService.saveAdmin(objAd );
    }
    
     //RETO4 
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin updateAdmin(@RequestBody Admin administradores) {
        return objAdminService.updateAdmin(administradores);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delAdmin(@PathVariable Integer id) {
        return objAdminService.delAdmin(id);
    }

    
}
