package spboot.web.jpa.demo.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "member")
public class Member {
	
@Id
@Column(name="member_id")
int member_id;

@Column(name="firstname")
String first_name;

@Column(name="lastname")
String last_name;

@Column(name="mobile")
long mobile_no;

@Column(name="email")
String email;

@Column(name="password")
String password;

@Column(name="member_type")
String member_type;

@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn(name = "member_id")
List<MemberSubscription> memberSubscription;

@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn(name = "member_id")
List<MemberHistory> memberHistory;
public Member() {}

public Member(int member_id, String first_name, String last_name, long mobile_no, String email, String password,
		String member_type, List<MemberSubscription> memberSubscription,List<MemberHistory> memberHistory) {
	this.member_id = member_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.mobile_no = mobile_no;
	this.email = email;
	this.password = password;
	this.member_type = member_type;
	this.memberSubscription = memberSubscription;
	this.memberHistory = memberHistory;
}

public List<MemberHistory> getMemberHistory() {
	return memberHistory;
}

public int getMember_id() {
	return member_id;
}

public void setMember_id(int member_id) {
	this.member_id = member_id;
}

public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public long getMobile_no() {
	return mobile_no;
}

public void setMobile_no(long mobile_no) {
	this.mobile_no = mobile_no;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getMember_type() {
	return member_type;
}

public void setMember_type(String member_type) {
	this.member_type = member_type;
}

public void setMemberSubscription(List<MemberSubscription> memberSubscription)
{
	this.memberSubscription=memberSubscription;
}

public List<MemberSubscription> getMemberSubscription()
{
	return memberSubscription;
}

public void setMemberHistory(List<MemberHistory> memberHistory) {
	this.memberHistory = memberHistory;
}


}
