package com.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Status")
public class Status {
	@Id
	@Column(name="status_id")
	private int statusId=911;
	
	@Column(name="status_name")
	private String statusName;
	
	@Override
	public String toString() {
		return "status [statusId=" + statusId + ", statusName=" + statusName + "]";
	}

	public int getstatusId() {
		return statusId;
	}

	public void setstatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getstatusName() {
		return statusName;
	}

	public void setstatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
