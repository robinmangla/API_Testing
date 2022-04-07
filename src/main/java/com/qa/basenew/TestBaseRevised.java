package com.qa.basenew;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.qa.clientnew.RestAPIClientNew;

//import com.qa.client.RestAPIClient;

public class TestBaseRevised 
{
	public Properties prop;
	public int  RESPOSNE_STATUS_CODE_200 = 200;
	public int  RESPOSNE_STATUS_CODE_201 = 201;
	public int  RESPOSNE_STATUS_CODE_204 = 204;
	public int  RESPOSNE_STATUS_CODE_400 = 400;
	public int  RESPOSNE_STATUS_CODE_401 = 401;
	public int  RESPOSNE_STATUS_CODE_500 = 500;
	public TestBaseRevised testBaseRevised;
	public String serviceUrl;
	public String apiUrl;
	public String url;
	public String apiURLSingleEmployeeRecord;
	public String apiURLPostNewEmployee;
	public String apiURLPutEmployee;
	public String apiURLDeleteEmployee;
	public String urlSingleEmployeeRecord;
	public String urlPostNewEmployee;
	public String urlPutEmployee;
	public String urlDeleteEmployee;
    public SoftAssert softassert;
	public RestAPIClientNew restClientNew;
	public CloseableHttpResponse closeableHttpResponse;
	
	public TestBaseRevised()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/confignew/configRevised.properties");
            prop.load(ip);            
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setUpRevised()
	   {
//		   testBaseRevised = new TestBaseRevised();
		   softassert = new SoftAssert();
		   serviceUrl = prop.getProperty("serviceURL");
		   apiUrl = prop.getProperty("apiURL");
		   apiURLSingleEmployeeRecord = prop.getProperty("apiURLSingleEmployeeRecord");
		   apiURLPostNewEmployee = prop.getProperty("apiURLPostNewEmployee");
		   apiURLPutEmployee = prop.getProperty("apiURLPutEmployee");
		   apiURLDeleteEmployee = prop.getProperty("apiURLDeleteEmployee");
		   url = serviceUrl + apiUrl;
		   urlSingleEmployeeRecord = serviceUrl + apiURLSingleEmployeeRecord;
		   urlPostNewEmployee = serviceUrl + apiURLPostNewEmployee;
		   urlPutEmployee = serviceUrl + apiURLPutEmployee;
		   urlDeleteEmployee = serviceUrl + apiURLDeleteEmployee;
	   }
}
