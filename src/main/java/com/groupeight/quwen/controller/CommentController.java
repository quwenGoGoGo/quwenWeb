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

    @GetMapping("/toAdd")
    public String toAdd(Model model){
        model.addAttribute("cmts", new Comment());
        return "comment_add";
    }

    @PostMapping("/add")
    public  String add(Model model, @ModelAttribute Comment cmts){
        commentService.addComment(cmts);
        List<Comment> lists = commentService.getAllComment();
        model.addAttribute("cmts", lists);
        return "comment_list";
    }

    @RequestMapping("/update/{id}")
    public String toUpdate(Model model, @PathVariable("id") Long commentID){
        model.addAttribute("cmts", commentService.getCommentByID(commentID) );
        return "comment_update";
    }

//    @RequestMapping("/update/{id}")
//    public String update(Model model, @PathVariable Long commentID, @ModelAttribute Comment cmts){}
}
