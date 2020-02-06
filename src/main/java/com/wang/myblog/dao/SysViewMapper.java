package com.wang.myblog.dao;

import com.wang.myblog.entity.SysView;
import com.wang.myblog.entity.SysViewExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysView record);

    int insertSelective(SysView record);

    List<SysView> selectByExample(SysViewExample example);

    SysView selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysView record);

    int updateByPrimaryKey(SysView record);
}