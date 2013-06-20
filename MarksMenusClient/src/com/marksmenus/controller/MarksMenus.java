package com.marksmenus.controller;

import java.util.ArrayList;

import com.marksmenus.domain.Menu;
import com.marksmenus.domain.MenuCategory;
import com.marksmenus.domain.MenuItem;
import com.marksmenus.domain.Restaurant;
import com.marksmenus.handlers.*;
import org.xml.sax.*;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.net.URL;

public class MarksMenus implements APIMap {

	ContentHandler handler;
	
	@Override
	public ArrayList<Restaurant> findRestuarantsByLocation(long lat, long lng,
			int distance) {
		

		
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		URL addr;
		XMLReader xmlReader;
		handler = new RestaurantHandler();
		// Limit distance to <= 5.  This prevents the server from getting hammered.
		if(distance > 5){
			distance = 5;
		}		
		
		// Populate the query string, create the reader and make the request to the server
		try{
			addr = new URL("http://www.marksmenus.com/search.xml?query=&lat=" + lat + "&lng=" + lng + "&within=" + distance);
			xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(addr.openStream()));
			// Get the populated arraylist back from the handler.
		}
		catch(Exception e){
			
		}
		
		return restaurants;
	}

	@Override
	public ArrayList<Restaurant> findRestaurantsByKeyword(long lat, long lng,
			int distance, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getRestaurant(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getMenu(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuCategory getMenuCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuItem getMenuItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
