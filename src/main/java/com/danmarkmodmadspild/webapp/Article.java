package com.danmarkmodmadspild.webapp.service;

import java.time.LocalDateTime;

/** Model for en artikel, oprettet af en OrgUser (admin). */
public class Article {

    private String id;
    private String title;        // artikel-titel
    private String category;     // fx "nyhed", "guide", "drift"
    private String summary;      // kort resume/teaser
    private String body;         // selve indholdet (tekst/HTML/markdown)
    private LocalDateTime publishedAt; // valgfrit: publicerings-tid
    private Boolean draft;       // true = kladde (ikke vist for brugere)

    public Article() {}

    public Article(String id, String title, String category, String summary,
                   String body, LocalDateTime publishedAt, Boolean draft) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.summary = summary;
        this.body = body;
        this.publishedAt = publishedAt;
        this.draft = draft;
    }

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public LocalDateTime getPublishedAt() { return publishedAt; }
    public void setPublishedAt(LocalDateTime publishedAt) { this.publishedAt = publishedAt; }

    public Boolean getDraft() { return draft; }
    public void setDraft(Boolean draft) { this.draft = draft; }
}
