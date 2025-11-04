package com.danmarkmodmadspild.webapp.controller;

import com.danmarkmodmadspild.webapp.data.InMemoryArticleRepository;
import com.danmarkmodmadspild.webapp.service.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/articles")
public class AdminArticlesController {
    private final List<String> quotes = List.of(
            "Gør det let at gøre det rigtige.",
            "Små handlinger skaber store resultater.",
            "Vi lærer ved at dele.",
            "Del viden, styrk fællesskabet.",
            "Mission frem for ego.",
            "Fællesskab løfter alt.",
            "Handling > intention.",
            "Viden er noget vi deler."
    );
    private final Random random = new Random();

    private final InMemoryArticleRepository repo;
    public AdminArticlesController(InMemoryArticleRepository repo){ this.repo = repo; }

    @GetMapping
    public String list(
            @RequestParam(name="category", required=false) List<String> categories,
            @RequestParam(name="q",        required=false) String q,
            @RequestParam(name="showDrafts", required=false, defaultValue="true") boolean showDrafts,
            Model model){

        var activeCats = (categories == null || categories.isEmpty())
                ? Arrays.asList("nyhed","guide","drift")
                : categories;

        var query = Optional.ofNullable(q).orElse("").trim().toLowerCase();

        var filtered = repo.findAll().stream()
                .filter(a -> activeCats.contains(a.getCategory()))
                .filter(a -> showDrafts || Boolean.FALSE.equals(a.getDraft()))
                .filter(a -> query.isEmpty()
                        || a.getTitle().toLowerCase().contains(query)
                        || Optional.ofNullable(a.getSummary()).orElse("").toLowerCase().contains(query)
                        || Optional.ofNullable(a.getBody()).orElse("").toLowerCase().contains(query))
                .collect(Collectors.toList());

        model.addAttribute("items", filtered);
        model.addAttribute("count", filtered.size());
        model.addAttribute("activeCategories", activeCats);
        model.addAttribute("q", q == null ? "" : q);
        model.addAttribute("showDrafts", showDrafts);
        model.addAttribute("form", new Article());

        return "AdminArticlesManage";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable String id,
            @RequestParam(name="category", required=false) List<String> categories,
            @RequestParam(name="q",        required=false) String q,
            @RequestParam(name="showDrafts", required=false, defaultValue="true") boolean showDrafts,
            Model model){

        var item = repo.findById(id).orElse(null);
        if (item == null) return "redirect:/admin/articles";

        var activeCats = (categories == null || categories.isEmpty())
                ? Arrays.asList("nyhed","guide","drift")
                : categories;

        model.addAttribute("items", repo.findAll());
        model.addAttribute("count", repo.findAll().size());
        model.addAttribute("activeCategories", activeCats);
        model.addAttribute("q", q == null ? "" : q);
        model.addAttribute("showDrafts", showDrafts);
        model.addAttribute("form", item);
        model.addAttribute("quote", quotes.get(random.nextInt(quotes.size())));


        return "AdminArticlesManage";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("form") Article form){
        repo.save(form);
        return "redirect:/admin/articles";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        repo.deleteById(id);
        return "redirect:/admin/articles";
    }
}
