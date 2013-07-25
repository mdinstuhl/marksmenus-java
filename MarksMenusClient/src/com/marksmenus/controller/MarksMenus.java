package com.marksmenus.controller;

import java.util.ArrayList;

import com.marksmenus.domain.Menu;
import com.marksmenus.domain.MenuCategory;
import com.marksmenus.domain.MenuItem;
import com.marksmenus.domain.Restaurant;
import com.marksmenus.handlers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class MarksMenus implements APIMap {

	ContentHandler handler;
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
	
	@Override
	public ArrayList<Restaurant> findRestuarantsByLocation(double lat, double lng,
			int distance) {
		

		
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		URL addr;
		URLConnection conn;
		String url = new String();
		XMLReader xmlReader;
		handler = new RestaurantHandler(restaurants);
		// Limit distance to <= 5.  This prevents the server from getting hammered.
		if(distance > 5){
			distance = 5;
		}		
		
		// Populate the query string, create the reader and make the request to the server
		try{
			url = "http://www.marksmenus.com/search.xml?query=&lat=" + lat + "&lng=" + lng + "&within=" + distance;
			addr = new URL(url);
			System.out.println(url);
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
		handler = new RestaurantHandler(restaurants);
		// Limit distance to <= 5.  This prevents the server from getting hammered.
		if(distance > 5){
			distance = 5;
		}		
		
		// Populate the query string, create the reader and make the request to the server
		try{
			url = "http://www.marksmenus.com/search.xml?query=" + keyword +  "&lat=" + lat + "&lng=" + lng + "&within=" + distance;
			addr = new URL(url);
			System.out.println(url);
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
