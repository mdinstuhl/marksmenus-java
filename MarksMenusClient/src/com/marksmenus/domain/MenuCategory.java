package com.marksmenus.domain;

import java.util.ArrayList;

public class MenuCategory {

	private String name = new String();
	private String description = new String();
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
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
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	

	
}
