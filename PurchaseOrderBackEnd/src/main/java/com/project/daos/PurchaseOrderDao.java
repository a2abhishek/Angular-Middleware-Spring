package com.project.daos;

import java.util.List;

import com.project.models.PurchaseOrder;

public interface PurchaseOrderDao {
		
	public boolean addPo(PurchaseOrder pObj);
	public List<PurchaseOrder> viewAllPo();
}

