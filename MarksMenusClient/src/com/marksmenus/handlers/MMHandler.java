package com.marksmenus.handlers;

import com.marksmenus.domain.*;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public interface MMHandler extends ContentHandler {

	public MMObject getMMObject();

}
