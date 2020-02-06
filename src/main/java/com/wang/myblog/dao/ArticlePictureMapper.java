package com.wang.myblog.dao;

import com.wang.myblog.entity.ArticlePicture;
import com.wang.myblog.entity.ArticlePictureExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArticlePictureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticlePicture record);

    int insertSelective(ArticlePicture record);

    List<ArticlePicture> selectByExample(ArticlePictureExample example);

    ArticlePicture selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticlePicture record);

    int updateByPrimaryKey(ArticlePicture record);
}