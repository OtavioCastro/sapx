package br.com.erp.sapx.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper mapper(){
        System.out.println("INICIANDO O MODELMAPPER");
        return new ModelMapper();
    }

}
