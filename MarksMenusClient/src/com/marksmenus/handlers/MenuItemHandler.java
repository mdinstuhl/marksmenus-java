package com.marksmenus.handlers;

import com.marksmenus.domain.*;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.XMLReader;

public class MenuItemHandler implements MMHandler{

	MenuItem menuItem;
	String lastName;
	
	public MenuItem getMenuItem(){
		return this.menuItem;
	}

	public MMObject getMMObject(){
		return this.menuItem;
	}
	
		
		public void endDocument(){}
	 	public void   	endPrefixMapping(String prefix){}
	 	public void   	ignorableWhitespace(char[] ch, int start, int length){}
	 	public void processingInstruction(String s, String a){}
	 	public void setDocumentLocator(Locator l){}
	 	public void   	skippedEntity(String name){}
	 	
	 	public void   	startPrefixMapping(String prefix, String s){}
		public void   	startDocument(){
			//System.out.println("MenuItemXMLHandler.startDocument - clearing Globals.currentMenuItem...");
			//Globals.currentMenuItem = new MenuItem();
		}
		public MenuItemHandler(MenuItem menuItem){ }
		 public void characters(char[] ch, int start, int length)
		 {
			 String premium = "";
			 //System.out.println("Inside characters.  lastName=" + lastName);
			 if(lastName.equals("name") && menuItem.getName().length() == 0)
			 {
				 //System.out.println("About to set menuItem name..");
				 menuItem.setName(String.copyValueOf(ch, start, length));
				 //System.out.println("Menu Item name set to " + menuItem.getName());
			 }
			 else if(lastName.equals("description") && menuItem.getDescription().length() == 0){
				 menuItem.setDescription(String.copyValueOf(ch, start, length));
			 }
		 }
		public void startElement(String uri, String localName, String qName, Attributes atts)
		{
			//System.out.println("Setting lastName to " + localName);
			lastName = localName;
			if(localName.equals("menu_item"))
			{
				//System.out.println("MenuItemXMLHandler.startElement - found a menu item");
				menuItem = new MenuItem();
				try{
					menuItem.setId(atts.getValue("id"));
				} catch(Exception e){
					System.out.println("MenuItemXMLHandler.startElement - " + e.getMessage());
				}
			}
		}
		
		 public void endElement(String uri, String localName, String qName)
		 {
			 if(localName.equals("menu_item"))
				{
				 //System.out.println("endElement - about to assign local menuItem to Globals.currentMenuItem");

				}
		 }	

}
