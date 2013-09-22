A few years ago I was lucky enough to be invited by Scott Brown (rsbrown) to help build a cool new web site, MarksMenus.com.  Scott was very patient with me and, eventually under his guidance, I learned enough Rails that I was able to contribute to the code base and help get everything up and running.

One of the interesting features of Rails at the time was that the scaffolding automatically generated the (rather simple) logic to provide a RESTful interface to the app.

For those of you that do not know, REST interfaces are used extensively with mobile applications (and even some javascript-based web sites).  They allow a secure and easy way to read data from a web service without having to expose the back-end data source to the internet.

As a rule, RESTful APIs are self-documenting.  Here are a few examples from the MarksMenus api:

In order to get a restaurant from the web service, simple use the following URL:

http://www.marksmenus.com/restaurants/<restaurant_id>.xml

This will return an XML-formatted restaurant.  From there, the restaurant object can be parsed and put into an object model of your chosing.

I hope that this helps developers discover new and interesting ways to interact with existing web services.

If you find this useful, drop me a line and say hello!

Mark
