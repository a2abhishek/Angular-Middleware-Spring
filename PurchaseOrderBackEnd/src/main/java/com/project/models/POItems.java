package com.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PurchaseOrderLineItems")
public class POItems {
	
	@Id
	@GeneratedValue
	private int purchaseOrderItemId;
	
	@Transient
	private int productId;
	
	@OneToOne
	@JoinColumn(name="productId")
	private Products productObj;
	
	private int poQuantity;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="purchaseOrderId")
	@JsonIgnore
	private PurchaseOrder purchaseOrderObj;


	public int getPurchaseOrderItemId() {
		return purchaseOrderItemId;
	}


	public void setPurchaseOrderItemId(int purchaseOrderItemId) {
		this.purchaseOrderItemId = purchaseOrderItemId;
	}


	public Products getProductObj() {
		return productObj;
	}


	public void setProductObj(Products productObj) {
		this.productObj = productObj;
	}


	public int getPoQuantity() {
		return poQuantity;
	}


	public void setQuantity(int poQuantity) {
		this.poQuantity = poQuantity;
	}


	public PurchaseOrder getPurchaseOrderObj() {
		return purchaseOrderObj;
	}


	public void setPurchaseOrderObj(PurchaseOrder purchaseOrderObj) {
		this.purchaseOrderObj = purchaseOrderObj;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	@Override
	public String toString() {
		return "PurchaseOrderItems [purchaseOrderItemId=" + purchaseOrderItemId + ", productObj=" + productObj
				+ ", poQuantity=" + poQuantity + ", productId=" + productId + "]";
	}	
	
}