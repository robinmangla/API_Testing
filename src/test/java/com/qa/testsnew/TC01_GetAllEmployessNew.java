package com.qa.testsnew;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.qa.basenew.TestBaseRevised;
import com.qa.clientnew.RestAPIClientNew;
import com.qa.utilitiesnew.TestUtilitiesRevised;

public class TC01_GetAllEmployessNew extends TestBaseRevised
{
	@Test
	public void getAllEmployeesAPITestWithHeaders() throws ClientProtocolException, IOException, InterruptedException
	{
		restClientNew = new RestAPIClientNew();
	    HashMap<String, String> headerMap = new HashMap<String, String>();
	    headerMap.put("Content-Type", "application/json");
	    closeableHttpResponse = restClientNew.get(url, headerMap); 
        Thread.sleep(3000);
        
	    //status code
	    int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is " + statusCode);
		softassert.assertEquals(statusCode, RESPOSNE_STATUS_CODE_200, "Status Code is not 200");
		   
		//JSON String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("Response in String Format from GET API " + responseString);
		     
	    JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Reponse in JSON Format from GET API " + responseJson);
		   
		//employee name validation
		String statusValue = TestUtilitiesRevised.getValueByJPath(responseJson, "/status");
		System.out.println("Status Value is: " + statusValue);
		softassert.assertEquals(statusValue, "success", "Status Value is not success");
		String employeeNameValue = TestUtilitiesRevised.getValueByJPath(responseJson, "/data[0]/employee_name");
		System.out.println("employee name Value is: " + employeeNameValue);	
		softassert.assertEquals(employeeNameValue, "Tiger Nixon", "Employee name at index 0 is not Tiger Nixon");
	}
}
