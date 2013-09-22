package com.marksmenus.controller;

import java.util.ArrayList;

import com.marksmenus.domain.*;
import com.marksmenus.handlers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class MarksMenus implements APIMap {

	//ContentHandler handler;
	String proxyURL;
	int proxyPort;
	boolean usesProxy = false;
	
	public MarksMenus(){
		
	}
	
	public MarksMenus(String proxyURL, int proxyPort){
		this.proxyURL = proxyURL;
		this.proxyPort = proxyPort;
		this.usesProxy = true;
	}
	

	private MMObject getSingleObject(String url, MMHandler handler){
		
		MMObject object = new MMObject();
		URL addr;
		URLConnection conn;
		XMLReader xmlReader;

		try{
			addr = new URL(url);
			if(this.usesProxy){
			  conn = addr.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.proxyURL, this.proxyPort)));
			} else {
				conn = addr.openConnection();	
			}
			xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(conn.getInputStream()));
			object = handler.getMMObject();			
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return object;

	}

	@Override
	public ArrayList<Restaurant> findRestuarantsByLocation(double lat, double lng,
			int distance) {
		

		
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		URL addr;
		URLConnection conn;
		String url = new String();
		XMLReader xmlReader;
		SearchResultsHandler handler = new SearchResultsHandler(restaurants);
		// Limit distance to <= 5.  This prevents the server from getting hammered.
		if(distance > 5){
			distance = 5;
		}		
		
		// Populate the query string, create the reader and make the request to the server
		try{
			url = "http://www.marksmenus.com/search.xml?query=&lat=" + lat + "&lng=" + lng + "&within=" + distance;
			addr = new URL(url);
			//System.out.println(url);
			if(this.usesProxy){
			  conn = addr.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.proxyURL, this.proxyPort)));
			} else {
				conn = addr.openConnection();	
			}
			xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(conn.getInputStream()));
			// Get the populated arraylist back from the handler.

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return restaurants;
	}

	@Override
	public ArrayList<Restaurant> findRestaurantsByKeyword(double lat, double lng,
			int distance, String keyword) {

		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		URL addr;
		URLConnection conn;
		String url = new String();
		XMLReader xmlReader;
		SearchResultsHandler handler = new SearchResultsHandler(restaurants);
		// Limit distance to <= 5.  This prevents the server from getting hammered.
		if(distance > 5){
			distance = 5;
		}		
		
		// Populate the query string, create the reader and make the request to the server
		try{
			url = "http://www.marksmenus.com/search.xml?query=" + keyword +  "&lat=" + lat + "&lng=" + lng + "&within=" + distance;
			addr = new URL(url);
			//System.out.println(url);
			if(this.usesProxy){
			  conn = addr.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.proxyURL, this.proxyPort)));
			} else {
				conn = addr.openConnection();	
			}
			xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(conn.getInputStream()));
			// Get the populated arraylist back from the handler.
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return restaurants;		
		
	}

	@Override
	public Restaurant getRestaurant(String id) {
		Restaurant restaurant = new Restaurant();
		
		String url = new String();
		RestaurantHandler handler = new RestaurantHandler(restaurant);
		
		// Populate the query string, create the reader and make the request to the server
		try{
			url = "http://www.marksmenus.com/restaurants/" + id + ".xml";     //98616 = BBQ Shop
			restaurant.setId(id);
			restaurant = (Restaurant) getSingleObject(url, handler);

		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		return restaurant;
	}

	@Override
	public Menu getMenu(String id) {
		Menu menu = new Menu();
		String url = new String();
		MenuHandler handler = new MenuHandler(menu);
		try{
			url = "http://www.marksmenus.com/restaurants/" + id + ".xml";
			menu.setId(id);
			menu = (Menu) getSingleObject(url, handler);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return menu;
	}


	@Override
	public MenuItem getMenuItem(String id) {
		// Test URL http://www.marksmenus.com/menu_items/2354059
		MenuItem menuItem = new MenuItem();
		String url = new String();
		MenuItemHandler handler = new MenuItemHandler(menuItem);
		try{
			url = "http://www.marksmenus.com/menu_items/" + id + ".xml";
			menuItem.setId(id);
			menuItem = (MenuItem) getSingleObject(url, handler);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return menuItem;
	}

}
