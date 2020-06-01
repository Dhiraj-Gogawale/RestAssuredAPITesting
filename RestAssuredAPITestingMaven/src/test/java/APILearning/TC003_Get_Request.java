//In below code we are doing header validation using Get method
package APILearning;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_Get_Request {
	
	@Test
    void googleMapTest() {
		
		//Specify base URl
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
		
		//Validating Header
		String contenttypeHeading = response.header("Content-Type"); //Content-Type is one off a Header
	    System.out.println("Content Type Heading Is " +contenttypeHeading);
	    Assert.assertEquals("application/xml; charset=UTF-8", contenttypeHeading);
	
	    String contenEncodingHeading = response.header("Content-Encoding"); //Content-Encoding is one off  a Header
	    System.out.println("Content Encoding Header Is " +contenEncodingHeading);
	    Assert.assertEquals("gzip", contenEncodingHeading);
	}

}
