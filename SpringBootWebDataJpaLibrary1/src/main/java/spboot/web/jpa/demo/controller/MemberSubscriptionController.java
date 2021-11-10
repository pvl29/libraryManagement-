package spboot.web.jpa.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spboot.web.jpa.demo.entity.Books;
import spboot.web.jpa.demo.entity.Member;
import spboot.web.jpa.demo.entity.MemberSubscription;
import spboot.web.jpa.demo.service.*;
@RequestMapping("/membersubscription")
@RestController
public class MemberSubscriptionController
{
	@Autowired
	MemberSubscriptionService memberSubscriptionService;
	
    @GetMapping(value="/{memberId}",produces="application/json")
    public ResponseEntity<List<MemberSubscription>> getSubscriptionPlansByMemberId(@PathVariable int memberId)
    {
 		List<MemberSubscription> bk = memberSubscriptionService.getSubscriptionPlansByMemberId(memberId);   
 	    return new ResponseEntity<List<MemberSubscription>>(bk,HttpStatus.OK);
    }
    @PostMapping(value = "subadd" ,consumes="application/json")
	public HttpStatus addSubscriptionDetails(@RequestBody MemberSubscription memsub)
	{
		if(memberSubscriptionService.addSubscription(memsub))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
		
	}
    @DeleteMapping(value="removesub/{memberId}")
 	public HttpStatus deleteSubscriptionDetails(@PathVariable int memberId)
 	{
 		memberSubscriptionService.removeSubscription(memberId);
 			return HttpStatus.OK;
 		//return HttpStatus.NO_CONTENT;
 	}
    @ExceptionHandler(RuntimeException.class)
    public HttpStatus noDataFound()
    {
 	   return HttpStatus.NO_CONTENT;
    }

}
