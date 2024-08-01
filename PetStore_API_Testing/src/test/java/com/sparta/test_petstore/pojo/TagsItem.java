package com.sparta.test_petstore.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagsItem{

	public TagsItem(){}

	public TagsItem(int id, String name) {
		this.name = name;
		this.id = id;
	}

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}