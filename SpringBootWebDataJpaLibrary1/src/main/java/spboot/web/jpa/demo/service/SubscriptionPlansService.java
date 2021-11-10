package spboot.web.jpa.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.demo.entity.SubscriptionPlans;
import spboot.web.jpa.demo.repository.SubscriptionPlansRepository;
@Service
public class SubscriptionPlansService {

	 @Autowired
	 SubscriptionPlansRepository subscriptionPlansRepository;
	 
	 @Transactional(readOnly=true)
		public SubscriptionPlans getPlan(int planId)
		{
			Optional<SubscriptionPlans> optPl = subscriptionPlansRepository.findById(planId);
			if(optPl.isPresent()) return optPl.get();
			throw new RuntimeException("Plan Does Not EXIST");
		}
	 
	 @Transactional(readOnly=true)
		public List<SubscriptionPlans> getPlans()
		{
			List<SubscriptionPlans> elist = subscriptionPlansRepository.findAll();
			if(elist.size() > 0) return elist;
			throw new RuntimeException("No data Found");
		}
}
