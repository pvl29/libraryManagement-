package spboot.web.jpa.demo.entity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="member_subscription")
public class MemberSubscription 
{
   @Id
   @Column(name="subscription_id")
   int subscriptionId;
   
   @Column(name="member_id")
   int memberId;
   
   //@Column(name="plan_id")
   //int planId;
   
   @Column(name="sub_from")
   LocalDate subfrom;
   
   @Column(name="sub_to")
   LocalDate subto;
   
   @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinColumn(name = "plan_id")
 
   SubscriptionPlans subscriptionPlans;
   public MemberSubscription() 
   {
	   
   }

   public MemberSubscription(int subscriptionId, int memberId, LocalDate subfrom, LocalDate subto) 
   {
	
	this.subscriptionId = subscriptionId;
	this.memberId = memberId;
	//this.planId = planId;
	this.subfrom = subfrom;
	this.subto = subto;
   }

   public int getSubscriptionId()
   {
 	return subscriptionId;
   }

   public void setSubscriptionId(int subscriptionId) 
   {
	this.subscriptionId = subscriptionId;
   }

   public int getMemberId() 
   {
	return memberId;
   }

   public void setMemberId(int memberId) 
   {
	this.memberId = memberId;
   }

  /* public int getPlanId() 
   {
	return planId;
   }

   public void setPlanId(int planId) 
   {
	this.planId = planId;
   }*/

   public LocalDate getSubfrom() 
   {
	return subfrom;
   }

   public void setSubfrom(LocalDate subfrom) 
   {
	this.subfrom = subfrom;
   }

   public LocalDate getSubto() 
   {
	return subto;
   }

   public void setSubto(LocalDate subto) 
   {
	this.subto = subto;
   }
}
