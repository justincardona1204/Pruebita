/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.ciclo3.Reto3.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.ciclo3.Reto3.Model.Category;
import usa.edu.ciclo3.Reto3.Repository.Crud.CategoryCrud;

/**
 *
 * @author justi
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrud categoria;
    
    //obtengo todos los registros de la tabla categoria
    public List<Category> getCategorys() {
        return (List<Category>) categoria.findAll();
    }
    //aqui me devuelve el id que seleccione y si no me devuelve otra cosa.
    public Optional<Category> getIdCat(int id) {
        return categoria.findById(id);
    }
    // en este guardo un registro de tipo categoria 
    public Category saveCategory(Category objC) {
        return categoria.save(objC);

    }
    
    public void delCategory(Category category){
        categoria.delete(category);
    }
    
}
