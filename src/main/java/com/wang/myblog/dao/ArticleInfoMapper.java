package com.wang.myblog.dao;

import com.wang.myblog.entity.ArticleInfo;
import com.wang.myblog.entity.ArticleInfoExample;

import java.util.List;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    List<ArticleInfo> selectByExample(ArticleInfoExample example);

    ArticleInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);
}