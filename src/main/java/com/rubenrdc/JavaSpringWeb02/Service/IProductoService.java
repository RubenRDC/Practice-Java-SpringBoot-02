package com.rubenrdc.JavaSpringWeb02.Service;

import com.rubenrdc.JavaSpringWeb02.Models.Producto;
import java.util.List;

/**
 *
 * @author Ruben
 */
public interface IProductoService {

    public List<Producto> getListProducts();

    public Producto getProductById(Long id);
}
