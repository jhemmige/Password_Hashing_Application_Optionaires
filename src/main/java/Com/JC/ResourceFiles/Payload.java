package Com.JC.ResourceFiles;

import java.io.IOException;

public class Payload extends BaseURI {
	
	
public String getPayload() throws IOException {
	
	
	/*This is the payload that we'll send in the form of body to the end /hash.
	 * This accepts the key and value pair from global properties*/
		
String Payload=

//"{ \"password\":\""+getBaseURI("password")+"\"}";

"{ \""+getBaseURI("key")+"\":\""+getBaseURI("password")+"\"}";
	

	
return Payload;
		
		
	}


public String incorrect_Payload() throws IOException {
	
	
	/*This is the payload that we'll send in the form of body to the end /hash.
	 * This accepts the key and value pair from global properties*/
		
String Payload1=

//"{ \"password\":\""+getBaseURI("password")+"\"}";

"{ \""+getBaseURI("key")+"\":\""+getBaseURI("password1")+"\"}";
	

	
return Payload1;
		
		
	}






}
