package com.moussaabmma.microsrv.dao;


import com.moussaabmma.microsrv.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
