package com.wang.myblog.dao;

import com.wang.myblog.entity.CategoryInfo;
import com.wang.myblog.entity.CategoryInfoExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CategoryInfo record);

    int insertSelective(CategoryInfo record);

    List<CategoryInfo> selectByExample(CategoryInfoExample example);

    CategoryInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryInfo record);

    int updateByPrimaryKey(CategoryInfo record);
}