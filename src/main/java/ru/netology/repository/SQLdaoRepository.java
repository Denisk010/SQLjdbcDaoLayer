package ru.netology.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository

public class SQLdaoRepository {
    private static final String request = read("product_name.sql");
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SQLdaoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        SQLdaoRepository.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public static List<String> getProductName(String name) {
        return namedParameterJdbcTemplate.queryForList(request, Map.of("name", name), String.class);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
