package com.project.service;

import java.util.List;

import com.project.models.PurchaseOrder;

public interface PurchaseOrderService {
	public boolean addPo(PurchaseOrder pObj);
	public List<PurchaseOrder> viewAllPo();
}
