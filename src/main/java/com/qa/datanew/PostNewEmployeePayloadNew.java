package com.qa.datanew;

public class PostNewEmployeePayloadNew 
{
	String name;
	String salary;
	String age;
	String id;
//	String status;
//	String data;
	
	public PostNewEmployeePayloadNew() 
	{

	}

	public PostNewEmployeePayloadNew(String name, String salary, String age) 
	{
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	
		//getters and setters methods:
		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public String getSalary() 
		{
			return salary;
		}

		public void setSalary(String salary) 
		{
			this.salary = salary;
		}

		public String getAge() 
		{
			return age;
		}

		public void setAge(String age) 
		{
			this.age = age;
		}

		public String getId() 
		{
			return id;
		}

		public void setId(String id) 
		{
			this.id = id;
		}
		
//		public String getStatus() 
//		{
//			return status;
//		}
//
//		public void setStatus(String status)
//		{
//			this.status = status;
//		}
//		
//		public String getData() 
//		{
//			return status;
//		}
//
//		public void setData(String data)
//		{
//			this.data = data;
//		}
}
