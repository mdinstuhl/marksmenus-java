package com.marksmenus.handlers;

import com.marksmenus.domain.*;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class RestaurantHandler implements MMHandler {

	private Restaurant restaurant;
	private String lastName;
	private Menu menu;
	
	public RestaurantHandler() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant getRestaurant(){
		return this.restaurant;
	}
	
	public RestaurantHandler (Restaurant restaurant){
		this.restaurant = restaurant;
	}

	public MMObject getMMObject(){
		return this.restaurant;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		 //System.out.println("Inside characters.  lastName=" + lastName);
		 if(lastName.equals("name") && restaurant.getName().length() == 0)
		 {
			 //System.out.println("About to set restaurant name..");
			 restaurant.setName(String.copyValueOf(ch, start, length));
			 //System.out.println("Restaurant name set to " + restaurant.getName());
		 }
		 else if(lastName.equals("description") && restaurant.getDescription().length() == 0)
		 {
			 restaurant.setDescription(String.copyValueOf(ch, start, length));
		 }else if(lastName.equals("hours") && restaurant.getHours().length() == 0){
			restaurant.setHours(String.copyValueOf(ch,start,length));
			
		}else if(lastName.equals("address") && restaurant.getAddress().length()==0){
			restaurant.setAddress(String.copyValueOf(ch,start,length));
			
		}else if(lastName.equals("phone_number") && restaurant.getPhoneNumber().length()==0){
			restaurant.setPhoneNumber(String.copyValueOf(ch,start,length));
		}else if(lastName.equals("lat") && restaurant.getLat() == 0.00){
			restaurant.setLat(Double.parseDouble(String.copyValueOf(ch,start,length)));
		}else if(lastName.equals("lng") && restaurant.getLng() == 0.00){
			restaurant.setLng(Double.parseDouble(String.copyValueOf(ch,start,length)));
		}

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {

	}

	@Override
	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		lastName = localName;
		if(localName.equals("restaurant"))
		{
			//System.out.println("RestaurantXMLHandler.startElement - found a restaurant");
/*
			restaurant = new Restaurant();
			try{
				restaurant.setId(Integer.getInteger(atts.getValue("id")));
			} catch(Exception e){
				//System.out.println("RestaurantXMLHandler.startElement - " + e.getMessage());
			}
*/			
		}else if(localName.equals("menu")){
			//System.out.println("RestaurantXMLHandler.startElement - found a menu");
			menu = new Menu();
			menu.setId(atts.getValue("id"));
			restaurant.getMenus().add(menu);
		}

	}

	@Override
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub

	}

}
