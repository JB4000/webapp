package com.danmarkmodmadspild.webapp.controller;

import com.danmarkmodmadspild.webapp.FoodItem;
import com.danmarkmodmadspild.webapp.data.InMemoryFoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Controller for business page.
 * Handles showing food items, making new, editing and removing.
 * This class talks to the "fake database" (in memory repo).
 */
@Controller
public class HomeController {

    // connect to in-memory storage
    private final InMemoryFoodRepository repo;

    public HomeController(InMemoryFoodRepository repo) {
        this.repo = repo;
    }

    /**
     * Show main page with food list and search filters.
     * Runs when user visits "/"
     */
    @GetMapping("/")
    public String home(
            @RequestParam(name = "category", required = false) List<String> categories,
            @RequestParam(name = "q",        required = false) String q,
            Model model
    ) {

        // what food types are active (default all)
        List<String> activeCategories = (categories == null || categories.isEmpty())
                ? Arrays.asList("vegansk", "vegetarisk", "andet")
                : categories;

        // text from search box (lowercase for match)
        String query = Optional.ofNullable(q).orElse("").trim().toLowerCase();

        // filter food list by category and text
        var filtered = repo.findAll().stream()
                .filter(i -> activeCategories.contains(i.getCategory()))
                .filter(i -> query.isEmpty()
                        || i.getName().toLowerCase().contains(query)
                        || Optional.ofNullable(i.getDesc()).orElse("").toLowerCase().contains(query))
                .collect(Collectors.toList());

        // send values to Thymeleaf page
        model.addAttribute("items", filtered);
        model.addAttribute("count", filtered.size());
        model.addAttribute("activeCategories", activeCategories);
        model.addAttribute("q", q == null ? "" : q);
        model.addAttribute("form", new FoodItem()); // empty form for new item

        // return page name
        return "BusinessFoodManage";
    }

    /**
     * Load one item into form so user can edit it.
     * Same page is used, but input boxes get filled.
     */
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable String id,
            @RequestParam(name = "category", required = false) List<String> categories,
            @RequestParam(name = "q",        required = false) String q,
            Model model
    ) {
        // try find item, else go back
        var item = repo.findById(id).orElse(null);
        if (item == null) return "redirect:/";

        // keep current filter state
        List<String> activeCategories = (categories == null || categories.isEmpty())
                ? Arrays.asList("vegansk", "vegetarisk", "andet")
                : categories;

        // send data to page
        model.addAttribute("items", repo.findAll());
        model.addAttribute("count", repo.findAll().size());
        model.addAttribute("activeCategories", activeCategories);
        model.addAttribute("q", q == null ? "" : q);
        model.addAttribute("form", item); // fill form with food data

        // open same view
        return "BusinessFoodManage";
    }

    /**
     * Save item from form (create or update).
     * Called when user presses "Gem"
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("form") FoodItem form) {
        repo.save(form);
        return "redirect:/"; // go back to list
    }

    /**
     * Delete item by id.
     * Called when user presses "Slet"
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
