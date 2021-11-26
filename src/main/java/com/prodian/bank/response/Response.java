package com.prodian.bank.response;

public class Response {

	public String status;

	public Response(String status) {
		super();
		this.status = status;
	}

	public Response() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
