package com.sparta.test_petstore.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Inventory {
	public Inventory(int approved, int placed, int delivered) {
		this.approved = approved;
		this.placed = placed;
		this.delivered = delivered;
	}

	@JsonProperty("approved")
	private int approved;

	@JsonProperty("placed")
	private int placed;

	@JsonProperty("delivered")
	private int delivered;

	public int getApproved(){
		return approved;
	}

	public int getPlaced(){
		return placed;
	}

	public int getDelivered(){
		return delivered;
	}
}