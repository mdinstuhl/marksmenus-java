package com.marksmenus.domain;

import java.util.ArrayList;

public class Menu extends MMObject {

	private String description = new String();
	private ArrayList<MenuCategory> menuCategories = new ArrayList<MenuCategory>();
	

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
