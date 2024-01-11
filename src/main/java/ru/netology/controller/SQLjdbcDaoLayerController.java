package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

import ru.netology.repository.SQLdaoRepositoryImpl;

@RestController

public class SQLjdbcDaoLayerController {
    SQLdaoRepositoryImpl repository;

    SQLjdbcDaoLayerController(SQLdaoRepositoryImpl repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name") String name) throws SQLException {
        return repository.getProductName(name);
    }
}
