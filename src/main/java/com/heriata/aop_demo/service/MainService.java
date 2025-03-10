package com.heriata.aop_demo.service;

import com.heriata.aop_demo.dto.ModelDto;
import com.heriata.aop_demo.model.MainModel;
import com.heriata.aop_demo.repo.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final ModelRepository repository;

    public List<MainModel> getModels() {
        return repository.findAll();
    }

    public MainModel add(ModelDto model) {
        MainModel main = MainModel.builder()
                .number(model.getNumber())
                .string(model.getString())
                .build();


        return repository.save(main);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
