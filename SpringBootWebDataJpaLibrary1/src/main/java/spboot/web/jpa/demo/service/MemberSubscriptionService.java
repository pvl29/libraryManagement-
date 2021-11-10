package spboot.web.jpa.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spboot.web.jpa.demo.entity.MemberSubscription;
import spboot.web.jpa.demo.repository.MemberSubscriptionRepository;

@Service
public class MemberSubscriptionService {
   @Autowired
   MemberSubscriptionRepository memberSubscriptionRepository;
   
   
	 @Transactional(readOnly=true)
		public List<MemberSubscription> getSubscriptionPlansByMemberId(int memberId)
		{
			return memberSubscriptionRepository.findAllByMemberId(memberId);
		}


		@Transactional
		public boolean addSubscription(MemberSubscription memsub)
		{
		   MemberSubscription m = memberSubscriptionRepository.save(memsub);
		   return m!=null;
		}


		public void removeSubscription(int memberId) {
			
			 memberSubscriptionRepository.deleteById(memberId);
		}


		
   
}
