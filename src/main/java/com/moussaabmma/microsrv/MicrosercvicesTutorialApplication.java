package com.moussaabmma.microsrv;

import com.moussaabmma.microsrv.dao.CategoryRepository;
import com.moussaabmma.microsrv.dao.ProductRepository;
import com.moussaabmma.microsrv.entities.Category;
import com.moussaabmma.microsrv.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class MicrosercvicesTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosercvicesTutorialApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository){
        return args ->  {
            categoryRepository.deleteAll();
            final int[] i = {0,0};
            Stream.of("laptops","printers").forEach(c->{
                System.out.println(c.toString());
                categoryRepository.save(new Category("c"+(++i[0]),c,new ArrayList<>()));

            });
            categoryRepository.findAll().forEach(System.out::println);

            productRepository.deleteAll();
            Category c = categoryRepository.findById("c1").get();
            Stream.of("P"+(++i[1]),"P"+(++i[1]),"P"+(++i[1]),"P"+(++i[1])).forEach(p->{
                System.out.println(p.toString());
                Product product =productRepository.save(new Product(null,p,Math.random()*1000,c));
                c.getProducts().add(product);
                categoryRepository.save(c);

            });
            productRepository .findAll().forEach(System.out::println);
        };
    }

}
