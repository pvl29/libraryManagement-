package spboot.web.jpa.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import spboot.web.jpa.demo.entity.SubscriptionPlans;
import spboot.web.jpa.demo.service.SubscriptionPlansService;
@RequestMapping("/subscriptionPlans")
@RestController
public class SubscriptionPlansController {
    @Autowired
    SubscriptionPlansService  subscriptionPlansService;
    
    @GetMapping(value="/{planId}",produces="application/json")      //http://localhost:8092/subscriptionPlans/1
    public ResponseEntity<SubscriptionPlans> getPlans(@PathVariable int planId)
    {
    	SubscriptionPlans sp = subscriptionPlansService.getPlan(planId);   
 	    return new ResponseEntity<SubscriptionPlans>(sp,HttpStatus.OK);
    }
    
    @GetMapping(produces="application/json")                        //http://localhost:8092/subscriptionPlans
    public ResponseEntity<List<SubscriptionPlans>> getAllPlans()
    {
 	  return new ResponseEntity<List<SubscriptionPlans>>(subscriptionPlansService.getPlans(),HttpStatus.OK);   
    }
    @ExceptionHandler(RuntimeException.class)
    public HttpStatus noDataFound()
    {
 	   return HttpStatus.NO_CONTENT;
    }
}
