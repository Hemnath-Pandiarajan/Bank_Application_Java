package com.prodian.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cif_number;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "mobile_number")
	private long mobile_number;

	@Column(name = "email_id")
	private String email_id;

	@NotNull
	@Column(name = "mpin")
	private long mpin;

	@JsonManagedReference
	@OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="customer")
	private Account account;

	public Customer(long cif_number, String first_name, String last_name, long mobile_number, String email_id,
			long mpin, Account account) {
		super();
		this.cif_number = cif_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		this.email_id = email_id;
		this.mpin = mpin;
		this.account = account;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer []";
	}

	public long getCif_number() {
		return cif_number;
	}

	public void setCif_number(long cif_number) {
		this.cif_number = cif_number;
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

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public long getMpin() {
		return mpin;
	}

	public void setMpin(long mpin) {
		this.mpin = mpin;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
