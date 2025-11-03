package com.danmarkmodmadspild.webapp.data;

import com.danmarkmodmadspild.webapp.FoodItem;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple in-memory "database".
 * Data is only stored while app is running.
 * Used so system works without real database.
 */
@Repository
public class InMemoryFoodRepository {

    // map to store items by id
    private final Map<String, FoodItem> store = new ConcurrentHashMap<>();

    /**
     * Runs once when app starts.
     * Adds three sample items so page is not empty.
     */
    @PostConstruct
    void seed() {
        save(new FoodItem(null, "Grøn salatboks", "vegansk", 6, 2.5, 0.0,
                LocalDateTime.now().plusHours(2), "Indeholder nødder"));

        save(new FoodItem(null, "Vegetarisk lasagne stykker", "vegetarisk", 4, 1.8, 15.0,
                LocalDateTime.now().plusHours(5), "Med ost (gluten)"));

        save(new FoodItem(null, "Blandede brød (daggammelt)", "andet", 10, 3.0, 0.0,
                null, "Rugbrød + boller"));
    }

    // return all items (sorted by name)
    public List<FoodItem> findAll() {
        List<FoodItem> all = new ArrayList<>(store.values());
        all.sort(Comparator.comparing(FoodItem::getName));
        return all;
    }

    // find one item by id
    public Optional<FoodItem> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    // save new or update existing item
    public FoodItem save(FoodItem item) {
        if (item.getId() == null || item.getId().isBlank()) {
            item.setId(UUID.randomUUID().toString()); // create id if missing
        }
        normalize(item); // default values
        store.put(item.getId(), item);
        return item;
    }

    // remove item from memory
    public void deleteById(String id) {
        store.remove(id);
    }

    /**
     * Set safe values if fields are missing
     * (so app does not crash if form is empty)
     */
    private void normalize(FoodItem f){
        if (f.getQty() == null || f.getQty() < 1) f.setQty(1);
        if (f.getKg() == null || f.getKg() < 0) f.setKg(0.0);
        if (f.getPrice() == null || f.getPrice() < 0) f.setPrice(0.0);
    }
}
