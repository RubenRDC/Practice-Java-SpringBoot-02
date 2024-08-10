package com.rubenrdc.JavaSpringWeb02.DaooRepository;

import com.rubenrdc.JavaSpringWeb02.Models.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruben
 */

/*@RequestScope  Normalmente SingleTon, (solo se genera una instancia para toda la aplicacion).
En el caso de poner esta anotacion, cada vez que se requiera esta implementacion, se inyectara
una nueva instancia del objecto.*/
/*@SessionScope Con esta anotacion definimos que el objeto de esta implementacion inyectada se
mantendra y no se generara uno nuevo hasta que la sesion del usuario almacenado en el navegador
venza, cambie o se elimine.*/
@Primary //Lo defino como la implementacion principal, necesario si tengo mas de una implementacion de la interfaz a inyectar
@Repository("productoRepoDao")
public class ProductoDao implements IProductoDao {

    List<Producto> list;

    public ProductoDao() {
        list = new ArrayList<>();
        
        list.add(new Producto(1L, "Monitor 24' Asus", 124.2));
        list.add(new Producto(2L, "Monitor 27' NVIDIA", 164.9));
        list.add(new Producto(3L, "Procesador AMD R9", 1283.5));
        list.add(new Producto(4L, "8GB de Ram ADATA", 224.2));
        list.add(new Producto(5L, "16GB de Ram ADATA", 480.9));
        list.add(new Producto(6L, "32GB de Ram ADATA", 962.7));
        list.add(new Producto(7L, "MotherBoard AM4 B650 ATX", 1424.9));
        list.add(new Producto(8L, "Procesador AMD R5", 2924.2));
    }

    @Override
    public List<Producto> getListProducts() {
        return list;
    }

    @Override
    public Producto getProductById(Long id) {
        /*Genero un flujo y accedo a los elementos individuales dentro del filter
        Comparando si alguno q se encuentra en la lista consida con la id, en el caso de
        que alguno coincida retornara otro flujo con o sin contenido, intento acceder al
        primer elemento del flujo nuevo, en caso de que tenga contenido retornara el contenido
        caso contrario nulo.*/
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
