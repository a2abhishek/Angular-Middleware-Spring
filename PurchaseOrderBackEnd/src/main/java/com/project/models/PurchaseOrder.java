package com.project.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Purchase_Order")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	private int purchaseOrderId;
	
	@Column(name="created_Date")
	private LocalDate createdDate;
	
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="buyer_Id")
	
	private User buyerObj;
	
	@ManyToOne
	@JoinColumn(name="Seller_Id")
	
	private User sellerObj;
	
	@OneToMany(mappedBy="purchaseOrderObj",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<POItems> poItemsObj;

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}


	public User getBuyerObj() {
		return buyerObj;
	}

	public void setBuyerObj(User buyerObj) {
		this.buyerObj = buyerObj;
	}

	public User getSellerObj() {
		return sellerObj;
	}

	public void setSellerObj(User sellerObj) {
		this.sellerObj = sellerObj;
	}

	public List<POItems> getPoItemsObj() {
		return poItemsObj;
	}

	public void setPoItemsObj(List<POItems> poItemsObj) {
		this.poItemsObj = poItemsObj;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId + ", createdDate=" + createdDate + ", status="
				+ status + ", buyerObj=" + buyerObj + ", sellerObj=" + sellerObj + ", poItemsObj=" + poItemsObj + "]";
	}
}