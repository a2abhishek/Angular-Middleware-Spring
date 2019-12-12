package com.project.service;

import com.project.models.Status;

public interface StatusService {
	public boolean addStatus(Status statusObj);
	public boolean updateStatus(String statusName);
	public Status viewStatus(int statusId);
}
