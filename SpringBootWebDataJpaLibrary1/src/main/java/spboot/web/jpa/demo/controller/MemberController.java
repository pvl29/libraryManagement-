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

import spboot.web.jpa.demo.entity.Member;
import spboot.web.jpa.demo.service.MemberService;
@RequestMapping("/member")
@RestController
public class MemberController
{
	@Autowired
	MemberService memberService;
	
    @GetMapping(value="{memberId}",produces="application/json")
    public ResponseEntity<Member> getMemberById(@PathVariable int memberId)
    {
 		Member m = memberService.getMemberById(memberId);   
 	    return new ResponseEntity<Member>(m,HttpStatus.OK);
    }
    
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Member>> getMemberDetails()
    {
   		 return new ResponseEntity<List<Member>>(memberService.getMembers(),HttpStatus.OK);
    }
    
    @PostMapping(consumes="application/json")
	public HttpStatus addMemberDetails(@RequestBody Member member)
	{
		if(memberService.addMember(member))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
		
	}
    
 	@DeleteMapping(value="/{memberId}")
 	public HttpStatus deleteEmployeeDetails(@PathVariable int memberId)
 	{
 		if(memberService.removeMember(memberId))
 			return HttpStatus.OK;
 		return HttpStatus.NO_CONTENT;
 	}
 	
 	 @ExceptionHandler(RuntimeException.class)
     public HttpStatus noDataFound()
     {
  	   return HttpStatus.NO_CONTENT;
     }
	
}
