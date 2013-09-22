package com.marksmenus.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import com.marksmenus.domain.Restaurant;
import java.util.ArrayList;

public class SearchResultsHandler implements ContentHandler {

	private String lastName;
	private Restaurant restaurant;
	private ArrayList<Restaurant> restaurants;
	
	public ArrayList<Restaurant> getRestaurants(){
		return restaurants;
	}
	
	public SearchResultsHandler(ArrayList<Restaurant> _restaurants) {
		restaurants = _restaurants;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		 String premium = "";
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
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		 if(localName.equals("restaurant"))
			{
			 //System.out.println("endElement - about to add restaurant to collection");
			 if(restaurant != null)
				 restaurants.add(restaurant);
			}

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
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
			restaurant = new Restaurant();
			try{
				restaurant.setId(atts.getValue("id"));
			} catch(Exception e){
				//System.out.println("RestaurantXMLHandler.startElement - " + e.getMessage());
			}
		}

	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub

	}

}
