package com.marksmenus.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.marksmenus.domain.*;
import com.marksmenus.controller.*;
import java.util.ArrayList;


public class MarksMenusTest {

	private String proxy = new String("");
	private int proxyPort = 3128;

	@Test
	public void testFindRestuarantsByLocation() {
		
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		MarksMenus mmClient = new MarksMenus();
		
		try{
			restaurants = mmClient.findRestuarantsByLocation(35.1494, -90.0489, 5);
			if(restaurants.size() == 0){
				fail("No restaurants returned");
			}
		}
		catch(Exception e){
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testFindRestaurantsByKeyword() {
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		MarksMenus mmClient = new MarksMenus();
		
		try{
			restaurants = mmClient.findRestaurantsByKeyword(35.1494, -90.0489, 5, "chicken");
			if(restaurants.size() == 0){
				fail("No restaurants returned");
			} 
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetRestaurant() {
		Restaurant restaurant;
		MarksMenus mmClient = new MarksMenus();
		boolean hasMenus = false;
		try{
			restaurant = mmClient.getRestaurant("46");
			
			if(!restaurant.getName().equals("Boscos Squared")){
				fail("No restaurant returned");
			}
			for(Menu menu:restaurant.getMenus()){
				hasMenus = true;
				System.out.println(menu.getName());
			}
			if(!hasMenus){
				fail("No menus returned.");
			}
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetMenu() {
		Menu menu;
		MarksMenus mmClient = new MarksMenus();
		try{
			menu = mmClient.getMenu("35004");
			if(menu.getName().length() <= 0){
				fail("No menu returned");
			}
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}


	@Test
	public void testGetMenuItem() {
		MenuItem menuItem;
		MarksMenus mmClient = new MarksMenus();
		try{
			menuItem = mmClient.getMenuItem("2354059");
			if(!menuItem.getName().equals("Hamburger")){
				fail("Wrong menu item.");	
			}			
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

}
