package com.wang.myblog.dao;

import com.wang.myblog.entity.ArticleCategory;
import com.wang.myblog.entity.ArticleCategoryExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    List<ArticleCategory> selectByExample(ArticleCategoryExample example);

    ArticleCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleCategory record);

    int updateByPrimaryKey(ArticleCategory record);
}