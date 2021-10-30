/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo3.Reto3.Model.Admin;
import usa.edu.ciclo3.Reto3.Repository.Crud.AdminCrud;


/** 
 * 
 * @author justi
 */
@Repository
public class AdminRepository {
    
     @Autowired
    private AdminCrud administrador; 
    
     //obtengo todos los registros de la tabla categoria
    public List<Admin> getAdmins() {
        return (List<Admin>) administrador.findAll();
    }
    //aqui me devuelve el id que seleccione y si no me devuelve otra cosa.
    public Optional<Admin> getIdAdmin(int id) {
        return administrador.findById(id);
    }
    // en este guardo un registro de tipo categoria 
    public Admin saveAdmin(Admin objAd) {
        return administrador.save(objAd);

    }
    
      public void delAdmin(Admin admin){
        administrador.delete(admin);
    }
    
}
