package com.rubenrdc.JavaSpringWeb02;

import com.rubenrdc.JavaSpringWeb02.DaooRepository.IProductoDao;
import com.rubenrdc.JavaSpringWeb02.DaooRepository.ProductoDaoJSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class JavaSpringWeb02Application {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringWeb02Application.class, args);
    }

}

@Configuration//Marcado como una clase de configuracion
class AppConfig {
    
    //Inyectado por Spring
    @Value("classpath:json/ProductJson.json")
    private Resource resource;
    
    //Para poder inyectar una instancia de una clase que no es un componente Spring
    @Bean("productoDaoJSON")//Default es el nombre del metodo
    IProductoDao generateProductoDaoJSON() {
        //return new ProductoDaoJSON();
        return new ProductoDaoJSON(resource);
    }
}
