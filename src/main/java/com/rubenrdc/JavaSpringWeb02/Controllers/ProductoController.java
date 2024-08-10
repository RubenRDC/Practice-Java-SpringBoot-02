package com.rubenrdc.JavaSpringWeb02.Controllers;

import com.rubenrdc.JavaSpringWeb02.Models.Producto;
import com.rubenrdc.JavaSpringWeb02.Service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Ruben
 */
//@Controller
@RestController //Para devolver JSONs
@RequestMapping("/api")
public class ProductoController {

    //Inyeccion en declaraccion
    @Autowired
    @Qualifier("productoService")
    /*Expecifico la implementacion a utilizar e inyectar, necesario cuando tengo
    mas de una implementacion y no tengo ninguna definida como primaria*/
    IProductoService productoService;

    @RequestMapping("/getProductsList")
    public List<Producto> getProductsList() {
        return productoService.getListProducts();
    }

    @RequestMapping("/getProductById/{id}")
    public Producto getProductById(@PathVariable(name = "id") Long id) {
        return productoService.getProductById(id);
    }
}
