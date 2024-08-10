package com.rubenrdc.JavaSpringWeb02.DaooRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rubenrdc.JavaSpringWeb02.Models.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Ruben
 */
public class ProductoDaoJSON implements IProductoDao {

    private List<Producto> list;
    
    /*Inyectado por Spring si fuera un componente
    @Value("classpath:json/ProductJson.json")
    private Resource resource;*/
    
    public ProductoDaoJSON(){
        ClassPathResource resource = new ClassPathResource("json/ProductJson.json");
        readResource(resource);
    }
    
    public ProductoDaoJSON(Resource resource){
        //ClassPathResource resource = new ClassPathResource("json/ProductJson.json");
        readResource(resource);
    }
    
    private void readResource(Resource resource){
        ObjectMapper convertObject = new ObjectMapper();
        list= new ArrayList<>();
        try {
            Producto[] readValue = convertObject.readValue(resource.getFile(), Producto[].class);
            list.addAll(Arrays.asList(readValue));
        } catch (IOException ex) {
        }
    }

    @Override
    public List<Producto> getListProducts() {
        return list;
    }

    @Override
    public Producto getProductById(Long id) {
        return list.stream().filter(p-> p.getId().equals(id)).findFirst().orElse(null);
    }

}
