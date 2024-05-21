package com.example.cuahang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "[Processed]")
public class Processed {
  
	  @Id
	  private Integer id;
	  
	  @Column(columnDefinition = "nvarchar(255)")
	  private String donhang;
	  

	  @Column(columnDefinition = "varchar(255)")
	  private String lastUpdate;
	  
	  
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

		public String getLastUpdate() {
			return lastUpdate;
		}
		
		public void setLastUpdate(String lastUpdate) {
			this.lastUpdate = lastUpdate;
		}
 
}