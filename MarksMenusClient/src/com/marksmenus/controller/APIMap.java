package com.marksmenus.controller;

import com.marksmenus.domain.*;
import java.util.ArrayList;

public interface APIMap {

	public ArrayList<Restaurant> findRestuarantsByLocation(long lat, long lng, int distance);
	public ArrayList<Restaurant> findRestaurantsByKeyword(long lat, long lng, int distance, String keyword);
	public Restaurant getRestaurant(int id);
	public Menu getMenu(int id);
	public MenuCategory getMenuCategory(int id);
	public MenuItem getMenuItem(int id);
	
	
}
