package com.danmarkmodmadspild.webapp;

import java.time.LocalDateTime;

/**
 * Model class for one food item in the system.
 * Used to store info about food that can be picked up.
 */
public class FoodItem {

    // unique id for item
    private String id;

    // name of item, ex "Brød"
    private String name;

    // food type, ex "vegansk"
    private String category;

    // number of units or portions
    private Integer qty;

    // weight in kilos
    private Double kg;

    // price in kr
    private Double price;

    // time when user can pick up
    private LocalDateTime pickup;

    // short text about item, ex allergy info
    private String desc;

    // empty constructor for forms (Spring needs this)
    public FoodItem() {}

    // full constructor for creating a food item
    public FoodItem(String id, String name, String category, Integer qty,
                    Double kg, Double price, LocalDateTime pickup, String desc) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.qty = qty;
        this.kg = kg;
        this.price = price;
        this.pickup = pickup;
        this.desc = desc;
    }

    // getters and setters (used by Spring to read/write values)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }

    public Double getKg() { return kg; }
    public void setKg(Double kg) { this.kg = kg; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public LocalDateTime getPickup() { return pickup; }
    public void setPickup(LocalDateTime pickup) { this.pickup = pickup; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
}
