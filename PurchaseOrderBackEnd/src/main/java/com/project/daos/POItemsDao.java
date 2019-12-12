package com.project.daos;

import java.util.List;

import com.project.models.POItems;

public interface POItemsDao {
	public List<POItems> getLineItemsById(int purchaseOrderId);
}
