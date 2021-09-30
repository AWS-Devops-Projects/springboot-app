package com.techtejendra.controller;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import com.techtejendra.property.GetTimestamp;  

@RestController  
public class HelloWorldController   
{  
	@RequestMapping("/")  
	public String hello()   
	{
		System.out.println(""); 
		GetTimestamp t= new GetTimestamp();	    	
		 String prev_timestamp = t.read();
		 System.out.println("prev timestamp-----> "+prev_timestamp);
		 
		 //System.out.println("---------------------------------------------REading Again");
		 
		 java.util.Date date=new java.util.Date(); 
		 String latest_timestamp = date.toString();
		 t.write(latest_timestamp);

		 String run_env;
		 run_env = System.getenv("RUN_ENV");
		 
		 String output;
		 output = "<center><H1>Greetings for the day</H1>";
		 output = output + "<h2 style='color:green;'>version : 5.0</h2>";
		 output = output + "<h2 style='color:red;'> Previous Timestamp :"+prev_timestamp+"</h2>";
		 output = output + "<h2 style='color:blue;'> Latest Timestamp :"+latest_timestamp+"</h2>";
		 if(run_env != null)
		 	output = output + "<h2 style='color:#f90e4e;'> Run Env :"+run_env+"</h2>";
		 output = output + "";
		 output = output + "</center>";
	     
		 return output;  
	}  
}
