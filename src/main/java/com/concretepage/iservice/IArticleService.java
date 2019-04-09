/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.iservice;

import java.util.List;
import com.concretepage.entity.Article;

/**
 *
 * @author Admin
 */
public interface IArticleService {

    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    boolean addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);
}
