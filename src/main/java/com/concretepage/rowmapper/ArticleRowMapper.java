/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concretepage.rowmapper;

import com.concretepage.entity.Article;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Admin
 */
public class ArticleRowMapper implements RowMapper<Article> {

    @Override
    public Article mapRow(ResultSet row, int rowNum) throws SQLException {
        Article article = new Article();
        article.setArticleId(row.getInt("articleId"));
        article.setTitle(row.getString("title"));
        article.setCategory(row.getString("category"));
        return article;
    }
}
