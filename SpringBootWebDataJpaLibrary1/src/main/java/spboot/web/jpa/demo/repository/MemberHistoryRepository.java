package spboot.web.jpa.demo.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import spboot.web.jpa.demo.entity.Books;
import spboot.web.jpa.demo.entity.MemberHistory;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Integer>{

	

	List<MemberHistory> findByMemberId(int member_id);
}
