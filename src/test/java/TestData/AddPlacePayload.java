package TestData;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class AddPlacePayload {
	public AddPlace addPlacepayload()
	{
		AddPlace a=new AddPlace();
		Location location=new Location();
		location.setLat(-38.388494);
		location.setLng(33.429362);
		a.setLocation(location);
		a.setAccuracy(80);
		a.setName("Milan Sutar2");
		a.setPhone_number("(+91) 987 896 3237");
		a.setAddress("29, side layout, cohen 10");
		List<String> myList=new ArrayList<String>();
		myList.add("Tecuh");
		myList.add("Parkty");
		a.setTypes(myList);
		a.setWebsite("https://milansutar123.com");
		a.setLanguage("OdiSha-IN");
		return a;
	}

}
