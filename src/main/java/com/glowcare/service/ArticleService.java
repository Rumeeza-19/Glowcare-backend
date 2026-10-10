package com.glowcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glowcare.dto.ArticleDto;
import com.glowcare.entity.Article;
import com.glowcare.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleDto addArticle(ArticleDto dto) {

        Article article = new Article();

        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setCategory(dto.getCategory());

        Article savedArticle = articleRepository.save(article);

        return convertToDto(savedArticle);
    }

    public List<ArticleDto> getAllArticles() {

        List<Article> articles = articleRepository.findAll();
        List<ArticleDto> result = new ArrayList<>();

        for (Article article : articles) {
            result.add(convertToDto(article));
        }

        return result;
    }

    public ArticleDto getArticleById(Long id) {

        Article article = articleRepository.findById(id).orElse(null);

        if (article == null) {
            return null;
        }

        return convertToDto(article);
    }

    public ArticleDto updateArticle(Long id, ArticleDto dto) {

        Article article = articleRepository.findById(id).orElse(null);

        if (article == null) {
            return null;
        }

        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setCategory(dto.getCategory());

        Article updatedArticle = articleRepository.save(article);

        return convertToDto(updatedArticle);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    private ArticleDto convertToDto(Article article) {

        ArticleDto dto = new ArticleDto();

        dto.setId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setContent(article.getContent());
        dto.setCategory(article.getCategory());

        return dto;
    }
}