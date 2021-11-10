package spboot.web.jpa.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import spboot.web.jpa.demo.entity.MemberSubscription;
public interface MemberSubscriptionRepository extends JpaRepository<MemberSubscription, Integer>{


	List<MemberSubscription> findAllByMemberId(int memberId);
}
