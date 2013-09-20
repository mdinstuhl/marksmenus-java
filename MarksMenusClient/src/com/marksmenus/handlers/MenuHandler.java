package com.marksmenus.handlers;

import java.util.Stack;

import com.marksmenus.domain.*;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MenuHandler implements ContentHandler {

	
	String lastName;
	Menu menu;
	MenuCategory menuCategory;
	MenuItem menuItem;
	char currentNode;
	String textValue = new String();
	private Stack currentElement = new Stack();
	boolean foundCData = false;	

	public MenuHandler(Menu _menu){
		menu = _menu;
	}

	public Menu getMenu(){
		return this.menu;
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {


		 
		 
		 if(lastName.equals("name"))
		 {
			 switch(currentNode){
				case 'm':
					if(menu.getName().length() == 0){
						menu.setName(String.copyValueOf(ch,start,length));
					}
					break;
				case 'c':
					if(menuCategory.getName().length()==0){
						menuCategory.setName(String.copyValueOf(ch,start,length));
					}
					break;
				case 'i':
					if(menuItem.getName().length()==0){
						menuItem.setName(String.copyValueOf(ch,start,length));
					}
					break;
			}
		 }
		 else if(lastName.equals("description"))
		 {
			String cdata = new String();
			if (foundCData){
				cdata = new String(ch,start,length);
				
			}
			
			switch(currentNode){
				case 'm':
					if(menu.getDescription().length() ==0){
						menu.setDescription(String.copyValueOf(ch,start,length));
					}
					break;
				case 'c':
					if(menuCategory.getDescription().length() == 0){
						menuCategory.setDescription(String.copyValueOf(ch,start,length));
					}
					break;
				case 'i':
					if(menuItem.getDescription().length() == 0 && foundCData){
						System.out.println("Setting description for menu item " + menuItem.getName());
						
						System.out.println("Description SHOULD be " + cdata);
						menuItem.setDescription(cdata);
						System.out.println("Description set for menu item " + menuItem.getName() + " - " + menuItem.getDescription());
					}
					break;
			}
		 }else if(lastName.equals("rating")){
			System.out.println("About to set the rating of menu item " + menuItem.getName());
			try{
				menuItem.setRating(Double.parseDouble(String.copyValueOf(ch,start,length)));
			} catch (Exception e){
				System.out.println("Setting rating failed.");
			}
			System.out.println("Rating for menu item " + menuItem.getName() + " has been set.");
			
		}else if(lastName.equals("rating_count")){
			System.out.println("About to set the rating count of menu item " + menuItem.getName());
			try{
				menuItem.setRatingCount(Integer.parseInt(String.copyValueOf(ch,start,length)));
			} catch(Exception e){
				System.out.println("Rating count not set for menu item " + menuItem.getName());
			}
			System.out.println("Rating for menu item " + menuItem.getName() + " has been set.");
			
		}else if(lastName.equals("price") && menuItem.getPrice().length() == 0){
			System.out.println("About to set price.");
			menuItem.setPrice(String.copyValueOf(ch,start,length));
		}else if(lastName.equals("picture_url") && menuItem.getPictureURL().length() == 0){
			menuItem.setPictureURL(String.copyValueOf(ch,start,length));
		}		
		

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		 if(localName.equals("menu")){
			 System.out.println("endElement - about to add menu to restaurant");
			 if(menu != null){
				 //Globals.currentRestaurant.menus.add(menu);
			 }
		} else if(localName.equals("menu_category") && menuCategory != null){
			menu.getMenuCategories().add(menuCategory);
		} else if(localName.equals("menu_item") && menuItem !=null){
			menuCategory.getMenuItems().add(menuItem);
		}
		currentElement.pop();		
		

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

		String type;
		System.out.println("Setting lastName to " + localName);
		lastName = localName;
		currentElement.push(qName);
		if(localName.equals("menu"))
		{
			//System.out.println("MenuXMLHandler.startElement - found a menu");
			menu = new Menu();
			currentNode = 'm';
			try{
				menu.setId(atts.getValue("id"));
			} catch(Exception e){
				System.out.println("MenuXMLHandler.startElement - " + e.getMessage());
			}
		} else if(localName.equals("menu_category")){
			//System.out.println("MenuXMLHandler.startElement - found a menu category");
			menuCategory = new MenuCategory();
			currentNode = 'c';
		} else if(localName.equals("menu_item")){
			
			System.out.println("MenuXMLHandler.startElement - found a menu item");				
			menuItem = new MenuItem();
			menuItem.setId(atts.getValue("id"));
			currentNode = 'i';
		} 		
		

	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub

	}

}
