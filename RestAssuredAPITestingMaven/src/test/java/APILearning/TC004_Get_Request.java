//In The below script we are going learn how to get all the Headers using Get Method and print it in console.

package APILearning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC004_Get_Request {
	
	@Test
	public void GetWeatherdetails() {
		//Specify the base URl
				RestAssured.baseURI="https://maps.googleapis.com";
				
				//Now we need send above URL as a GET Request. So we will be sending Get type of request. So we need to create below RequestSpecification Object.
			    //RequestSpecification is one of the predefine class in RestAssured.
				//With the below httprequest object we will be sending request to the server. hence it is a Request Object.
				RequestSpecification httpRequest=RestAssured.given();
				
				//Now we need to create Response Object to store the Response. For That we will create object of Response. Response is one of the class in RestAssured
				//Below Method.GET is use because the request which we are sending is of GET type. Also we need to pass parameter as an input.
				Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
				
				//Print Responce in Console Window
				String responseBody=response.getBody().asString();
				System.out.println("Response Body is :" +responseBody);
				
				
				//Headers is one of a predefine class in RestAssued. Below code will capture all the headers from response. 
			 	Headers allheader = response.headers();
			 	//Header is one of a predefine class in RestAssued.
			 	//in below for loop header contains the header key and header value which we need to separate them
			 	for(Header header:allheader) 
			 	{
			 		//Now to extract the key from the header we need to wright statement called header.getName (This will give you header name). & header.getValue will give you the value of the header.
			 	   System.out.println(header.getName()+"     "+header.getValue());
			 		
			 		
			 	}
	}

}
