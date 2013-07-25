package com.marksmenus.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.marksmenus.domain.*;
import com.marksmenus.controller.*;
import java.util.ArrayList;


public class MarksMenusTest {

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
		fail("Not yet implemented");
	}

	@Test
	public void testGetMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMenuCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMenuItem() {
		fail("Not yet implemented");
	}

}
