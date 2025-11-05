package com.danmarkmodmadspild.webapp.service;

import com.danmarkmodmadspild.webapp.FoodItem;
import com.danmarkmodmadspild.webapp.data.InMemoryFoodRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    public static final List<String> DEFAULT_CATEGORIES =
            Arrays.asList("vegansk", "vegetarisk", "andet");

    private final InMemoryFoodRepository repo;

    public FoodService(InMemoryFoodRepository repo) {
        this.repo = repo;
    }

    public List<FoodItem> findFiltered(List<String> categories, String q) {
        List<String> active = (categories == null || categories.isEmpty())
                ? DEFAULT_CATEGORIES
                : categories;

        String query = Optional.ofNullable(q).orElse("").trim().toLowerCase();

        return repo.findAll().stream()
                .filter(i -> active.contains(i.getCategory()))
                .filter(i -> query.isEmpty()
                        || i.getName().toLowerCase().contains(query)
                        || Optional.ofNullable(i.getDesc()).orElse("").toLowerCase().contains(query))
                .toList();
    }

    public Optional<FoodItem> findById(String id) {
        return repo.findById(id);
    }

    public FoodItem save(FoodItem f) {
        if (f.getQty() == null || f.getQty() < 1) f.setQty(1);
        if (f.getKg() == null || f.getKg() < 0) f.setKg(0.0);
        if (f.getPrice() == null || f.getPrice() < 0) f.setPrice(0.0);
        return repo.save(f);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
