package com.marksmenus.domain;

import java.util.ArrayList;

public class Menu {

	private int id;
	private String name = new String();
	private String description = new String();
	private ArrayList<MenuCategory> menuCategories = new ArrayList<MenuCategory>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<MenuCategory> getMenuCategories() {
		return menuCategories;
	}
	public void setMenuCategories(ArrayList<MenuCategory> menuCategories) {
		this.menuCategories = menuCategories;
	}
	
	
	
	
}
