package com.qa.clientnew;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestAPIClientNew 
{
	  //1. GET Method Without Headers
		public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
		{
			 CloseableHttpClient httpClient = HttpClients.createDefault();
	         HttpGet httpGet = new HttpGet(url);
	         CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
	         return closeableHttpResponse;
		}
		
	  //2. GET Method With Headers
		public CloseableHttpResponse get(String url, HashMap<String, String>headerMap) throws ClientProtocolException, IOException
		{
		     CloseableHttpClient httpClient = HttpClients.createDefault();
		     HttpGet httpGet = new HttpGet(url);
		         
		     for(Map.Entry<String,String> entry : headerMap.entrySet())
		      {
		 	     httpGet.addHeader(entry.getKey(), entry.getValue());
		 	  }
		         	         
		     CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
		     return closeableHttpResponse;
		}
		
	  // 3. POST Method with Headers
		public CloseableHttpResponse post(String url, String entityString, HashMap<String,String>headerMap) throws ClientProtocolException, IOException
		{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url); //http post request
			httpPost.setEntity(new StringEntity(entityString)); //for payload
			
			//for headers:
			for(Map.Entry<String,String> entry : headerMap.entrySet())
			{
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
			
			CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httpPost);
			return closebaleHttpResponse;
		}
		
		//4. PUT Method with Headers
		public CloseableHttpResponse put(String url, String entityString, HashMap<String,String>headerMap) throws ClientProtocolException, IOException
		{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPut httpPut = new HttpPut(url); //http post request
			httpPut.setEntity(new StringEntity(entityString)); //for payload
			
			//for headers:
			for(Map.Entry<String,String> entry : headerMap.entrySet())
			{
				httpPut.addHeader(entry.getKey(), entry.getValue());
			}
			
			CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httpPut);
			return closebaleHttpResponse;
		}
		
		//5. DELETE Method 
		public CloseableHttpResponse delete(String url) throws ClientProtocolException, IOException
		{
			 CloseableHttpClient httpClient = HttpClients.createDefault();
	         HttpDelete httpDelete = new HttpDelete(url);
	         CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpDelete);
	         return closeableHttpResponse;
		}
}
