package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Students {	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long uid;
private String uname;
private String urollnumber;
private String ucity;

public Students() {
	
}

public long getUid() {
	return uid;
}
public void setUid(long uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUrollnumber() {
	return urollnumber;
}
public void setUrollnumber(String urollnumber) {
	this.urollnumber = urollnumber;
}
public String getUcity() {
	return ucity;
}
public void setUcity(String ucity) {
	this.ucity = ucity;
}

public Students(String uname, String urollnumber, String ucity) {
	super();
	this.uname = uname;
	this.urollnumber = urollnumber;
	this.ucity = ucity;
}





}
