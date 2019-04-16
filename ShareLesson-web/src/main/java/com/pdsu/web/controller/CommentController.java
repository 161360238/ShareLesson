package com.pdsu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Comment;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.User;
import com.pdsu.service.CommentService;
import com.pdsu.utils.CodecUtil;
import com.pdsu.utils.Constant;
import com.pdsu.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/4/14
 * @Description: com.pdsu.web.controller
 * @version: 1.0
 */
@RequestMapping("/comment")
@Controller
@Api(tags = {"11,用户评论 相关接口"})
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentServiceImpl;

    /**
     * 新增评论
     *
     * @param pid
     * @param content
     * @param from
     * @param lId
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", required = false, paramType = "query", value = "父评论id"),
            @ApiImplicitParam(name = "content", required = true, paramType = "query", value = "评论内容"),
            @ApiImplicitParam(name = "from", required = true, paramType = "query", value = "作者id"),
            @ApiImplicitParam(name = "token", required = true, paramType = "query", value = "作者token"),
            @ApiImplicitParam(name = "lId", required = true, paramType = "query", value = "评论的课程id")
    })
    @ApiOperation(value = "新增评论")
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    @ResponseBody
    public Result addComment(String token, String pid, String content, String from, String lId) {
        Result result = new Result();
        User user = getUser(token);
        Comment comment = new Comment();
        if (user == null) {
            result.setMessage(Constant.BAD_TOKEN_MSG);
            result.setCode(Constant.BAD_TOKEN_CODE);
            return result;
        }
        try {
            content = new String(content.getBytes("iso-8859-1"), "utf-8");
            if (pid == null || pid.trim().equals("")) {
                pid = "0";
            }
            comment.setCommentId(CodecUtil.createUUID());
            comment.setContent(content);
            comment.setCreated(new Date());
            comment.setlId(lId);
            comment.setPid(pid);
            comment.setuId(from);
            int num = commentServiceImpl.addComment(comment);
            if (num > 0) {
                result.setMessage("评论成功");
                result.setCode("200");
                return result;
            } else {
                result.setMessage("评论失败");
                result.setCode("201");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "lid", required = true, dataType = "String", paramType = "query", value = "老师的id"),
            @ApiImplicitParam(name = "pn", required = true, dataType = "int", paramType = "query", value = "页码"),
    })
    @ApiOperation(value = "根据课程id查询课程的评论（分页显示）")
    @RequestMapping(value = "/selectCommentByLid", method = RequestMethod.GET)
    @ResponseBody
    public Result selectCommentByLid(String lid,
                                     @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Result result = new Result();
        try {
            PageHelper.startPage(pn, 10); //每页显示10条数据
            List<Comment> comments = commentServiceImpl.selectCommentByLid(lid);
            PageInfo page = new PageInfo(comments, 5);
            if (comments != null) {
                result.setCode("200");
                result.setMessage("查询成功");
                result.setData(page);
            } else {
                result.setCode("201");
                result.setMessage("该老师还没有发布课程");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }
}
