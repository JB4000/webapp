package com.danmarkmodmadspild.webapp.data;

import com.danmarkmodmadspild.webapp.service.Article;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryArticleRepository {

    private final Map<String, Article> store = new ConcurrentHashMap<>();

    @PostConstruct
    void seed(){
        save(new Article(null, "Velkommen til vidensbasen", "nyhed",
                "Kort intro til platformen.",
                "Her kan du dele guides og information med brugerne.",
                LocalDateTime.now(), false));

        save(new Article(null, "Sådan donerer du korrekt", "guide",
                "Trin-for-trin vejledning.",
                "1) Pak maden...\n2) Mærkning...\n3) Aflevering...",
                null, true));
    }

    public List<Article> findAll(){
        var all = new ArrayList<>(store.values());
        all.sort(Comparator.comparing(Article::getTitle));
        return all;
    }

    public Optional<Article> findById(String id){
        return Optional.ofNullable(store.get(id));
    }

    public Article save(Article a){
        if (a.getId() == null || a.getId().isBlank()){
            a.setId(UUID.randomUUID().toString());
        }
        normalize(a);
        store.put(a.getId(), a);
        return a;
    }

    public void deleteById(String id){
        store.remove(id);
    }

    private void normalize(Article a){
        if (a.getDraft() == null) a.setDraft(false);
        // publishedAt kan være null (kladder)
        if (a.getTitle() == null) a.setTitle("");
        if (a.getCategory() == null) a.setCategory("nyhed");
    }
}
