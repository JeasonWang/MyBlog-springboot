package com.wang.myblog.service;

import com.wang.myblog.entity.SysLog;
import com.wang.myblog.entity.SysView;

import java.util.List;

/**
 * 日志/访问统计等系统相关Service
 */
public interface SysService {
    void addLog(SysLog sysLog);

    void addView(SysView sysView);

    int getLogCount();

    int getViewCount();

    List<SysLog> listAllLog();

    List<SysView> listAllView();
}
