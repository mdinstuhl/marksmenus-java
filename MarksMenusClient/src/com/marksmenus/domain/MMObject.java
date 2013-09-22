package com.marksmenus.domain;

public class MMObject{

	public MMObject(){
	}

	private String id = new String();
	private String name = new String();

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

}
