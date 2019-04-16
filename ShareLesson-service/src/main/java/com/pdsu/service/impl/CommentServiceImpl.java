package com.pdsu.service.impl;

import com.pdsu.mapper.CommentMapper;
import com.pdsu.pojo.Comment;
import com.pdsu.pojo.CommentExample;
import com.pdsu.pojo.Lesson;
import com.pdsu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/4/14
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @Override
    public int addComment(Comment comment) {
        int result = commentMapper.insertSelective(comment);
        if (result > 0) {
            return 1;
        }
        return 0;
    }

    /**
     * 查询课程评论
     *
     * @param lid
     * @return
     */
    @Override
    public List<Comment> selectCommentByLid(String lid) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andLIdEqualTo(lid)
                .andPidEqualTo("0");    //先加载父id为o的评论
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
    }
}
