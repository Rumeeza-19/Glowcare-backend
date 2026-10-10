package com.glowcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glowcare.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}