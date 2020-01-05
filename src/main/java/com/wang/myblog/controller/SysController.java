package com.wang.myblog.controller;

import com.wang.myblog.entity.SysLog;
import com.wang.myblog.entity.SysView;
import com.wang.myblog.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统Controller
 *
 * @author:wmyskxz
 * @create:2018-06-21-上午 10:23
 */
@RestController
@RequestMapping("/admin")
public class SysController {


    @Autowired
    SysService sysService;

    /**
     * 返回所有的系统日志记录信息
     *
     * @return
     */
    @GetMapping("/sys/log")
    public List<SysLog> listAllLog() {
        return sysService.listAllLog();
    }

    /**
     * 返回所有的系统浏览记录信息
     *
     * @return
     */
    @GetMapping("sys/view")
    public List<SysView> listAllView() {
        return sysService.listAllView();
    }

}
