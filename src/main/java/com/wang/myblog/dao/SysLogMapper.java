package com.wang.myblog.dao;

import com.wang.myblog.entity.SysLog;
import com.wang.myblog.entity.SysLogExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}