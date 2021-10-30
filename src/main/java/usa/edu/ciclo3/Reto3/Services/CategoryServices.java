/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.ciclo3.Reto3.Model.Category;
import usa.edu.ciclo3.Reto3.Repository.CategoryRepository;

/**
 *
 * @author justi
 */
@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repositorio;

    public List<Category> getCategorys() {
        return repositorio.getCategorys();
    }

    public Optional<Category> getIdCat(int id) {
        return repositorio.getIdCat(id);
    }

    public Category saveCategory(Category objC) {
        if (objC.getId() == null) {
            return repositorio.saveCategory(objC);
        } else {
            Optional<Category> catAux = repositorio.getIdCat(objC.getId());

            if (catAux.isEmpty()) {
                return repositorio.saveCategory(objC);
            } else {
                return objC;
            }
        }
    }

    public Category updateCategory(Category objC) {
        if (objC.getId() != null) { //Verifica si el id no está vacío

            //Crea un auxiliar en el que se guarda el id del elemento
            Optional<Category> categoryAux = repositorio.getIdCat(objC.getId());

            //Verifica que el id no sea vacío
            if (!categoryAux.isEmpty()) {

                //Verifica que el nombre no sea vacío
                if (objC.getName() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    categoryAux.get().setName(objC.getName());
                }

                //Verifica que la descripción no sea vacía
                if (objC.getDescription() != null) {

                    //Busca la desc actual y la sobreescribe
                    categoryAux.get().setDescription(objC.getDescription());
                }

                if (objC.getRooms() != null) {
                    //busca el nombre y sobreescribe el nombre actual que se consigue con .get()
                    categoryAux.get().setRooms(objC.getRooms());
                   
                }
                
      
                
                
                //Guarda el valor actual de categoryAux
                repositorio.saveCategory(categoryAux.get());

                //Retorna el valor de categoryAux
                return categoryAux.get();
            } else {

                //Si name o description son vacios retorna el objeto original
                return objC;
            }
        } else {

            //Si el id es null retorna el objeto original
            return objC;
        }
    }

    public Boolean delCategory(Integer id) {
        Boolean objEliminar = getIdCat(id).map(category -> {
            repositorio.delCategory(category);
            return true;
        }).orElse(false);
        return objEliminar;
    }
    
    
    
    
}
    
            
