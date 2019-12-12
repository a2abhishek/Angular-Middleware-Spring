package com.project.serviceimpl;

//import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.models.PurchaseOrder;
import com.project.service.PurchaseOrderService;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Override
	public boolean addPo(PurchaseOrder pObj) {
//		pObj.setStatus("send to seller");
//		pObj.setCreatedDate(LocalDate.now());
		return addPo(pObj);
	}

	@Override
	public List<PurchaseOrder> viewAllPo() {
		
		return viewAllPo();
	}

}
