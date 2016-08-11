/**
 * 
 */
package com.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author kalaiselvan.a
 *
 */
@Entity
@Table(name = "userdetails")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "IsActive", columnDefinition = "varchar(10) DEFAULT 'Active'")
	private String IsActive;

	@Column(name = "CDate")
	@Temporal(TemporalType.DATE)
	private Date CDate;

	@Column(name = "CreatedBy")
	private String CreatedBy;

	@Column(name = "CreatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedDate;

	@Column(name = "UpdatedBy")
	private String UpdatedBy;

	@Column(name = "UpdatedDate")
	@Temporal(TemporalType.DATE)
	private Date UpdatedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIsActive() {
		return IsActive;
	}

	public void setIsActive(String isActive) {
		IsActive = isActive;
	}

	public Date getCDate() {
		return CDate;
	}

	public void setCDate(Date cDate) {
		CDate = cDate;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return UpdatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		UpdatedDate = updatedDate;
	}
}
