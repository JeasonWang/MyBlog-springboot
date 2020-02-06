package com.wang.myblog.controller;

import com.wang.myblog.dto.ArticleDto;
import com.wang.myblog.entity.*;
import com.wang.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 后台控制器
 *
 * @author:wanghuan
 * @create:2018-06-16-下午 15:08
 */
@RestController
@RequestMapping("/admin")
public class BackController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 后台登录操作
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User user1 = userService.getUser(user);
        if (user1 != null) {
            System.out.println("user = " + user);
            return user;
        } else {
            System.out.println("user is not exit");
            return null;
        }
    }

    /**
     * 增加一篇文章
     *
     * @return
     */
    @PostMapping("article")
    public String addArticle(@RequestBody ArticleDto articleDto) {
        articleService.addArticle(articleDto);
        return null;
    }


    /**
     * 删除一篇文章
     *
     * @param id
     * @return
     */

    @DeleteMapping("article/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return null;
    }

    /**
     * 编辑/更新一篇文章
     *
     * @return
     */

    @PutMapping("article/{id}")
    public String updateArticle(@PathVariable Long id, @RequestBody ArticleDto articleDto) {
        articleDto.setId(id);
        articleService.updateArticle(articleDto);
        return null;
    }

    /**
     * 改变某一篇文章的分类
     *
     * @param id
     * @return
     */

    @PutMapping("article/sort/{id}")
    public String changeArticleCategory(@PathVariable Long id, Long categoryId) {
        articleService.updateArticleCategory(id, categoryId);
        return null;
    }

    /**
     * 通过题图的id更改题图信息
     *
     * @param id
     * @return
     */

    @PutMapping("article/picture/{id}")
    public String updateArticlePicture(@PathVariable Long id, String pictureUrl) {
        ArticleDto articleDto = articleService.getOneById(id);
        articleDto.setPictureUrl(pictureUrl);
        articleService.updateArticle(articleDto);
        return null;
    }



    /**
     * 增加一条分类信息数据
     *
     * @return
     */

    @PostMapping("category")
    public String addCategoryInfo(@RequestBody CategoryInfo categoryInfo) {
        categoryService.addCategory(categoryInfo);
        return null;
    }

    /**
     * 更新/编辑一条分类信息
     *
     * @return
     */

    @PutMapping("category")
    public String updateCategoryInfo(@RequestBody CategoryInfo categoryInfo) {
        categoryService.updateCategory(categoryInfo);
        return null;
    }

    /**
     * 根据ID删除分类信息
     *
     * @param id
     * @return
     */

    @DeleteMapping("category/{id}")
    public String deleteCategoryInfo(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return null;
    }

    /**
     * 通过id获取一条分类信息
     *
     * @param id
     * @return
     */

    @GetMapping("category/{id}")
    public CategoryInfo getCategoryInfo(@PathVariable Long id) {
        return categoryService.getOneById(id);
    }

    /**
     * 通过评论ID删除文章评论信息
     *
     * @param id
     * @return
     */

    @DeleteMapping("comment/article/{id}")
    public String deleteArticleComment(@PathVariable Long id) {
        commentService.deleteArticleCommentById(id);
        return null;
    }

    /**
     * 通过id删除某一条留言
     *
     * @param id
     * @return
     */

    @DeleteMapping("comment/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteCommentById(id);
        return null;
    }

    /**
     * 回复留言/评论，通过id去找到对应的Email
     *
     * @param id
     * @return
     */

    @GetMapping("comment/reply/{id}")
    public String replyComment(@PathVariable Long id) {
        return null;
    }

    /**
     * 通过id获取某一条评论/留言
     *
     * @param id
     * @return
     */

    @GetMapping("comment/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return null;
    }


    /**
     * 通过ID获取一篇文章，内容为MD源码格式
     *
     * @param id
     * @return
     */
    @GetMapping("article/{id}")
    public ArticleDto getArticleDtoById(@PathVariable Long id) {
        return articleService.getOneById(id);
    }
}

