package com.qa.testsnew;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.basenew.TestBaseRevised;
import com.qa.clientnew.RestAPIClientNew;
import com.qa.datanew.PutEmployeePayloadNew;
import com.qa.utilitiesnew.RandomDataUtilitiesNew;

public class TC04_PutEmployeeRecordNew extends TestBaseRevised
{
	@Test
	public void putEmployeeRecordWithHeaders() throws StreamWriteException, DatabindException, IOException
	{
		restClientNew = new RestAPIClientNew();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		//jackson API:
		ObjectMapper mapper = new ObjectMapper();
		PutEmployeePayloadNew updateValues = new PutEmployeePayloadNew(RandomDataUtilitiesNew.empName(), RandomDataUtilitiesNew.empSalary(), RandomDataUtilitiesNew.empAge()); //expected users object
		
		//object to json file
		mapper.writeValue(new File(System.getProperty("user.dir") + "/src/main/java/com/qa/datanew/putEmployeePayloadNew.json"), updateValues);
		
		//java object to json in String:
		String updateValuesJsonString = mapper.writeValueAsString(updateValues);
		System.out.println(updateValuesJsonString);
		
		closeableHttpResponse = restClientNew.put(urlPutEmployee, updateValuesJsonString, headerMap); //call the API
		
	    //status code
	    int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is " + statusCode);
		softassert.assertEquals(statusCode, RESPOSNE_STATUS_CODE_200, "Status Code is not 200");
		
		//JSON String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("Response in String Format from PUT API " + responseString);
		     
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Reponse in JSON Format from PUT API " + responseJson);
	}
}
