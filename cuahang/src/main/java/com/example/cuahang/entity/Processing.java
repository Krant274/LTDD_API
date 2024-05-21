package com.example.cuahang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "[Processing]")
public class Processing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(columnDefinition = "nvarchar(255)")
	private String donhang;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDonHang() {
		return donhang;
	}
	
	public void setDonHang(String donHang) {
		this.donhang = donHang;
	}
}