package com.ql.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ql.blog.domain.Reply;
import com.ql.blog.domain.User;
import com.ql.blog.persistence.ResponseDTO;
import com.ql.blog.security.UserDetailsImpl;
import com.ql.blog.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	// 댓글 작성
	@PostMapping("/reply/{postId}")
	public @ResponseBody ResponseDTO<?> inserReply(@PathVariable int postId,
												   @RequestBody Reply reply,
												   @AuthenticationPrincipal UserDetailsImpl principal){
		
		
		replyService.insertReply(postId, reply, principal.getUser());
		
		return new ResponseDTO<>(HttpStatus.OK.value(), postId + "번 포스트에 대한 댓글이 등록되었습니다.");
		
	}
	
	// 댓글 삭제
	@DeleteMapping("/reply/{replyId}")
	public @ResponseBody ResponseDTO<?> deleteReply(@PathVariable int replyId){
		
		replyService.deleteReply(replyId);
		
		return new ResponseDTO<>(HttpStatus.OK.value(), replyId + "번 댓글이 삭제 되었습니다.");
		
	}

}
