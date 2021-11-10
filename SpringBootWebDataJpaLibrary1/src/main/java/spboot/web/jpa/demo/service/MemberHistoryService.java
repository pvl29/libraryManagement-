package spboot.web.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spboot.web.jpa.demo.entity.MemberHistory;
import spboot.web.jpa.demo.repository.MemberHistoryRepository;

@Service
public class MemberHistoryService {

	 @Autowired
	 MemberHistoryRepository memberHistoryRepository;
	 
	 @Transactional(readOnly=true)
		public List<MemberHistory> getMemberById(int member_id)
		{
			List<MemberHistory> optEmp = memberHistoryRepository.findByMemberId(member_id);
			if(optEmp.size() > 0) return optEmp;
			throw new RuntimeException("History Does Not EXIST");
		}
}
