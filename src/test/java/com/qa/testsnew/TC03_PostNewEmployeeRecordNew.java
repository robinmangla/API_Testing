package com.qa.testsnew;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.basenew.TestBaseRevised;
import com.qa.clientnew.RestAPIClientNew;
import com.qa.datanew.PostNewEmployeePayloadNew;
import com.qa.utilitiesnew.RandomDataUtilitiesNew;

public class TC03_PostNewEmployeeRecordNew extends TestBaseRevised 
{
	@Test
	public void postNewRecordWithHeaders() throws StreamWriteException, DatabindException, IOException, InterruptedException 
	{
		restClientNew = new RestAPIClientNew();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		//jackson API:
		ObjectMapper mapper = new ObjectMapper();
		PostNewEmployeePayloadNew newEmployeeData = new PostNewEmployeePayloadNew(RandomDataUtilitiesNew.empName(), RandomDataUtilitiesNew.empSalary(), RandomDataUtilitiesNew.empAge()); //expected users object
		
		//object to json file
		mapper.writeValue(new File(System.getProperty("user.dir") + "/src/main/java/com/qa/datanew/postNewEmployeePayloadNew.json"), newEmployeeData);
		
		//java object to json in String:
		String newEmployeeDataJsonString = mapper.writeValueAsString(newEmployeeData);
		System.out.println(newEmployeeDataJsonString);
		
		closeableHttpResponse = restClientNew.post(urlPostNewEmployee, newEmployeeDataJsonString, headerMap); //call the API
		
		Thread.sleep(3000);
		
	    //status code
	    int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is " + statusCode);
		Assert.assertEquals(statusCode, RESPOSNE_STATUS_CODE_200, "Status Code is not 200");
		
		//JSON String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("Response in String Format from POST API " + responseString);
		     
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Reponse in JSON Format from POST API " + responseJson);
	}
}
