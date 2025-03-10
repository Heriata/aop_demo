package com.heriata.aop_demo.repo;

import com.heriata.aop_demo.model.MainModel;
import jakarta.annotation.PostConstruct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends CrudRepository<MainModel, Integer> {

    @PostConstruct
    default void init() {
        System.out.println("ModelRepository init");
    }

    List<MainModel> findAll();

    MainModel save(MainModel model);
}
