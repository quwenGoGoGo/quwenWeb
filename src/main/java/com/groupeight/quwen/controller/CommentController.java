package com.groupeight.quwen.controller;

import com.groupeight.quwen.entity.Comment;
import com.groupeight.quwen.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public String getAllCmt(Model model){
       List<Comment> lists = commentService.getAllComment();
       model.addAttribute("cmts", lists);
       return "comment_list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") Long id){
        System.out.println(id);

        if(id > 0){
            System.out.println(id);
            model.addAttribute("isAdd", false);
            model.addAttribute("comment", commentService.getCommentByID(id));
        }
        else{
            model.addAttribute("isAdd", true);
            model.addAttribute("comment", new Comment());
        }

        return "comment_edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Comment comment){
        if(comment == null)
            return "fail";

        System.out.println(comment.getCommentID());

        if(comment.getCommentID() != null && comment.getCommentID() > 0)
            commentService.updateComment(comment);
        else
            commentService.addComment(comment);

        return "redirect:/comments/all";
    }

    @RequestMapping("/del/{id}")
    public String delByID(@PathVariable("id") Long commentID) {
        commentService.deleteComment(commentID);
        return "redirect:/comments/all";
    }
}
