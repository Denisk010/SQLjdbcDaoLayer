package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.repository.SQLdaoRepository;

import java.util.List;

@RestController

public class SQLjdbcDaoLayerController {
    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name") String name) {
        return SQLdaoRepository.getProductName(name);
    }
}
