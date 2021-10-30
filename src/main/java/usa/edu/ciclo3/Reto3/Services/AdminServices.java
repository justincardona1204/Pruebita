/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo3.Reto3.Model.Admin;
import usa.edu.ciclo3.Reto3.Repository.AdminRepository;


/**
 *
 * @author justi
 */
@Repository
public class AdminServices {
    
     @Autowired
    private AdminRepository administrador;

    public List<Admin> getAdmins() {
        return administrador.getAdmins();
    }

    public Optional<Admin> getIdAdmin(int id) {
        return administrador.getIdAdmin(id);
    }

    public Admin saveAdmin(Admin objAd) {
        if (objAd.getId() == null) {
            return administrador.saveAdmin(objAd);
        } else {
            Optional<Admin> AdminAux = administrador.getIdAdmin(objAd.getId());

            if (AdminAux.isEmpty()) {
                return administrador.saveAdmin(objAd);
            } else {
                return objAd;
            }
        }
    }
    
     public Admin updateAdmin(Admin objA) {
        if (objA.getId() != null) { //Verifica si el id no está vacío

            //Crea un auxiliar en el que se guarda el id del elemento
            Optional<Admin> AdminAux = administrador.getIdAdmin(objA.getId());

            //Verifica que el id no sea vacío
            if (!AdminAux.isEmpty()) {

                //Verifica que el nombre no sea vacío
                if (objA.getName() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    AdminAux.get().setName(objA.getName());
                }

                //Verifica que la descripción no sea vacía
                if (objA.getEmail() != null) {

                    //Busca la desc actual y la sobreescribe
                    AdminAux.get().setEmail(objA.getEmail());
                }
                
                
                 //Verifica que la descripción no sea vacía
                if (objA.getPassword() != null) {

                    //Busca la desc actual y la sobreescribe
                    AdminAux.get().setPassword(objA.getPassword());
                }

                        
           
                //Guarda el valor actual de categoryAux
                administrador.saveAdmin(AdminAux.get());

                //Retorna el valor de categoryAux
                return AdminAux.get();
            } else {

                //Si name o description son vacios retorna el objeto original
                return objA;
            }
        } else {

            //Si el id es null retorna el objeto original
            return objA;
        }
    }

    public Boolean delAdmin(Integer id) {
        Boolean objEliminar = getIdAdmin(id).map(Admin -> {
            administrador.delAdmin(Admin);
            return true;
        }).orElse(false);
        return objEliminar;
    }
    
    
}
