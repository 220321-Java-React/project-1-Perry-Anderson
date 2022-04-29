package com.revature.models;

public class ErsReimbursement {
	private int id;
	private int amount;
	private String submitted;
	private int authorId;
	private int statusId;
	private int typeId;
	
	public ErsReimbursement(int id, int amount, String submitted, int authorId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	

	public ErsReimbursement(int amount, String submitted, int authorId, int statusId, int typeId) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	
	
	
}
