package com.marksmenus.controller;

import com.marksmenus.domain.*;
import java.util.ArrayList;

public interface APIMap {

	public ArrayList<Restaurant> findRestuarantsByLocation(double lat, double lng, int distance);
	public ArrayList<Restaurant> findRestaurantsByKeyword(double lat, double lng, int distance, String keyword);
	public Restaurant getRestaurant(String id);
	public Menu getMenu(String id);
	public MenuItem getMenuItem(String id);
	
	
}
