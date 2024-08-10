package com.rubenrdc.JavaSpringWeb02.Service;

import com.rubenrdc.JavaSpringWeb02.DaooRepository.IProductoDao;
import com.rubenrdc.JavaSpringWeb02.Models.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruben
 */
@Service("productoService")//Nombre implicito
@Primary //Lo defino como la implementacion principal, necesario si tengo mas de una implementacion de la interfaz a inyectar
public class ProductoService implements IProductoService {

    IProductoDao productoDao;

    //@Autowired Inyeccion implicita por constructor
    public ProductoService(@Qualifier("productoDaoJSON") IProductoDao productoDao) {
        this.productoDao=productoDao;
    }

    @Override
    public List<Producto> getListProducts() {
        /*Las clases de servicio se suelen utilizar para manipular los datos
        previo a mostrarlos a la siguiente capa de la aplicacion.*/
        return productoDao.getListProducts();
    }

    @Override
    public Producto getProductById(Long id) {
        return productoDao.getProductById(id);
    }
    
}
