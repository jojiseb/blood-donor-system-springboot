package net.blooddonor.bds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Donors")
public class Donor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "bloodGroup")
	private String bloodGroup;
	
	@Column(name = "lastDonation")
	private Date lastDonation;
	
	public Donor() {
		
	}
	
	public Donor(String name, String sex, int age, String bloodGroup, Date lastDonation) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.lastDonation = lastDonation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public Date getLastDonation() {
		return lastDonation;
	}
	public void setLastDonation(Date lastDonation) {
		this.lastDonation = lastDonation;
	}
	
	
	
}
