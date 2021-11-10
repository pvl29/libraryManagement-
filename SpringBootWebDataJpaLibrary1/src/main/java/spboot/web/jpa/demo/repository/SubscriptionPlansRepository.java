package spboot.web.jpa.demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import spboot.web.jpa.demo.entity.SubscriptionPlans;
public interface SubscriptionPlansRepository extends JpaRepository<SubscriptionPlans, Integer>{

	

}