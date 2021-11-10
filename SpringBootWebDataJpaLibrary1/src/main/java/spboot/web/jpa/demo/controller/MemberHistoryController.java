package spboot.web.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import spboot.web.jpa.demo.entity.MemberHistory;
import spboot.web.jpa.demo.service.MemberHistoryService;
@RequestMapping("/memberhistory")
@RestController
public class MemberHistoryController {
     @Autowired
     MemberHistoryService memberHistoryService;
     
     
     @GetMapping(value="history/{member_id}",produces="application/json")
     public ResponseEntity<List<MemberHistory>> getMemberHistoryById(@PathVariable int member_id)
     {
  		List<MemberHistory> bk = memberHistoryService.getMemberById(member_id);   
  	    return new ResponseEntity<List<MemberHistory>>(bk,HttpStatus.OK);
     }
     
     @ExceptionHandler(RuntimeException.class)
     public HttpStatus noDataFound()
     {
  	   return HttpStatus.NO_CONTENT;
     }
}
