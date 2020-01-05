package com.wang.myblog.controller;

import com.wang.myblog.dto.ArticleCommentDto;
import com.wang.myblog.dto.ArticleDto;
import com.wang.myblog.dto.ArticleWithPictureDto;
import com.wang.myblog.entity.*;
import com.wang.myblog.util.Markdown2HtmlUtil;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 前台控制器
 *
 * @author:wmyskxz
 * @create:2018-06-16-下午 15:35
 */
@RestController
@RequestMapping("/api")
public class ForeController extends BaseController {

    /**
     * 获取所有文章列表
     *
     * @return
     */
    @GetMapping("article/list")
    public List<ArticleWithPictureDto> listAllArticleInfo() {
        return articleService.listAll();
    }

    /**
     * 获取某一个分类下的所有文章
     *
     * @param id
     * @return
     */

    @GetMapping("article/list/sort/{id}")
    public List<ArticleWithPictureDto> listArticleInfo(@PathVariable Long id) {
        return articleService.listByCategoryId(id);
    }

    /**
     * 获取最新的文章
     *
     * @return
     */

    @GetMapping("article/list/lastest")
    public List<ArticleWithPictureDto> listLastestArticle() {
        return articleService.listLastest();
    }

    /**
     * 通过文章的ID获取对应的文章信息
     *
     * @param id
     * @return 自己封装好的文章信息类
     */

    @GetMapping("article/{id}")
    public ArticleDto getArticleById(@PathVariable Long id) {
        ArticleDto articleDto = articleService.getOneById(id);
        articleDto.setContent(Markdown2HtmlUtil.markdown2html(articleDto.getContent()));
        return articleDto;
    }


    /**
     * 获取所有分类信息
     *
     * @return
     */
    @GetMapping("category/list")
    public List<CategoryInfo> listAllCategoryInfo() {
        return categoryService.listAllCategory();
    }

    /**
     * 获取所有的留言信息
     *
     * @return
     */
    @GetMapping("comment/list")
    public List<Comment> listAllComment() {
        return commentService.listAllComment();
    }

    /**
     * 通过文章ID获取某一篇文章的评论信息
     *
     * @param id
     * @return
     */
    @GetMapping("comment/article/{id}")
    public List<ArticleCommentDto> listMessageByArticleId(@PathVariable Long id) {
        return commentService.listAllArticleCommentById(id);
    }

    /**
     * 给某一篇文章增加一条评论信息
     *
     * @return
     */

    @PostMapping("comment/article/{id}")
    public String addArticleComment(@PathVariable Long id, @RequestBody ArticleCommentDto articleCommentDto, HttpServletRequest request) {

        String ip = request.getRemoteAddr();
        articleCommentDto.setIp(ip);
        articleCommentDto.setArticleId(id);
        commentService.addArticleComment(articleCommentDto);

        return null;
    }

    /**
     * 增加一条留言
     *
     * @return
     */
    @PostMapping("comment")
    public String addMessage(@RequestBody Comment comment, HttpServletRequest request) {

        String ip = request.getRemoteAddr();
        comment.setIp(ip);
        commentService.addComment(comment);

        return null;
    }
}
