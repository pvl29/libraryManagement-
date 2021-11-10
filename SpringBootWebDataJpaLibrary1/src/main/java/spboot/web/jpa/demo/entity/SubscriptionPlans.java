package spboot.web.jpa.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlans 
{
	@Id
	@Column(name="plan_id")
	int planId;
	
	@Column(name="plan_amount")
	double planAmount;
	
	@Column(name="plan_description")
	String planDescription;
	
	@Column(name="plan_duration")
     String planDuration;
	
	public SubscriptionPlans() {}
	
	public SubscriptionPlans(int planId,int planAmount,String planDescription,String planDuration)
	{
		this.planId = planId;
		this.planAmount = planAmount;
		this.planDescription = planDescription;
		this.planDuration = planDuration;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public double getPlanAmount() {
		return planAmount;
	}

	public void setPlanAmount(double planAmount) {
		this.planAmount = planAmount;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getPlanDuration() {
		return planDuration;
	}

	public void setPlanDuration(String planDuration) {
		this.planDuration = planDuration;
	}
}
	
	
