package com.project.daos;

import java.util.List;

import com.project.models.Status;

public interface StatusDao {
	public boolean addStatus(Status statusObj);
	public boolean updateStatus(String statusName);
	public List<Status> viewStatus();
}
