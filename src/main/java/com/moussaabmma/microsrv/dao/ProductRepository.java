package com.moussaabmma.microsrv.dao;

import com.moussaabmma.microsrv.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
