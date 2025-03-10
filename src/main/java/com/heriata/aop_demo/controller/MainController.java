package com.heriata.aop_demo.controller;

import com.heriata.aop_demo.annotations.ListAnno;
import com.heriata.aop_demo.dto.ModelDto;
import com.heriata.aop_demo.model.MainModel;
import com.heriata.aop_demo.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService service;

    @ListAnno
    @GetMapping("/models")
    public List<MainModel> getModels() {
        return this.service.getModels();
    }

    @PostMapping("/add")
    public MainModel addModel(@RequestBody ModelDto model) {
        return this.service.add(model);
    }

    @DeleteMapping("/remove")
    public void removeModel(@RequestParam Integer id) {
        this.service.delete(id);
    }
}
