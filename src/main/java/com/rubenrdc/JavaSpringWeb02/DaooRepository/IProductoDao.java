package com.rubenrdc.JavaSpringWeb02.DaooRepository;

import com.rubenrdc.JavaSpringWeb02.Models.Producto;
import java.util.List;

/**
 *
 * @author Ruben
 */
public interface IProductoDao {

    public List<Producto> getListProducts();

    public Producto getProductById(Long id);

}
