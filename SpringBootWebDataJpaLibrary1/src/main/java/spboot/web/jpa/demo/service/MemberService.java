package spboot.web.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import spboot.web.jpa.demo.entity.Member;
import spboot.web.jpa.demo.repository.MemberRepository;

@Service
public class MemberService {
    
	@Autowired
	MemberRepository memberRepository;
	
	
	@Transactional(readOnly=true)
	public Member getMemberById(int member_id)
	{
		Optional<Member> optEmp = memberRepository.findById(member_id);
		if(optEmp.isPresent()) return optEmp.get();
		throw new RuntimeException("Employee Does Not EXIST");
	}
	@Transactional(readOnly=true)
	public List<Member> getMembers()
	{
		List<Member> elist = memberRepository.findAll();
		if(elist.size() > 0) return elist;
		throw new RuntimeException("No data Found");
	}
	
	@Transactional
	public boolean addMember(Member member)
	{
	   Member m = memberRepository.save(member);
	   return m!=null;
	}
	
	@Transactional
	public boolean removeMember(int memberId)
	{
		Optional<Member> mem =memberRepository.findById(memberId);
		if(mem.isPresent())
		{
		    memberRepository.deleteById(memberId);
		    return true;
		}
		return false;
	}


}

