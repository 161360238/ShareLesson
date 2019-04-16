package com.pdsu.service;

import com.pdsu.pojo.Comment;
import com.pdsu.pojo.Lesson;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/4/14
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface CommentService {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    public int addComment(Comment comment);

    /**
     * 根据课程id，查询课程的评论
     * @param lid
     * @return
     */
    List<Comment> selectCommentByLid(String lid);
}
