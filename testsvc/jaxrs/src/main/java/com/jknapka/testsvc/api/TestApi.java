package com.jknapka.testsvc.api;

import com.jknapka.testsvc.model.*;

import com.wordnik.swagger.annotations.*;
import com.sun.jersey.multipart.FormDataParam;

import com.jknapka.testsvc.model.KeyError;
import com.jknapka.testsvc.model.OutputThing;
import com.jknapka.testsvc.model.InputThing;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import com.jknapka.testsvc.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/test")
@Api(value = "/test", description = "the test API")

public class TestApi {
	
	//load instance via ServiceLoader
//	static TestApiInterface instance ;=new TestApiSTUB();
	static TestApiInterface instance ;//=new TestApiImpl();
	static  {
		    ServiceLoader<TestApiInterface> loader = ServiceLoader.load(TestApiInterface.class);
		    List<TestApiInterface> output = new ArrayList<TestApiInterface>();
		    Iterator<TestApiInterface> itr = loader.iterator();
		    TestApiInterface stub=null;
		    while(itr.hasNext()) {
		    	
		    	try{
			    	TestApiInterface next =itr.next();
			    	System.out.println(next.getClass().getName());
			    	if(next.getClass().getName().endsWith("STUB")){
			    		stub=next;
			    	}
			    	else{
			    		instance=next;
			    	}
		    	}catch(Throwable t){
		    		t.printStackTrace();
		    	}
		    }
		    if (instance==null)instance=stub;
		  }
	
	
	
	public TestApiInterface getInstance() {
		return instance;
	}
	public void setInstance(TestApiInterface instance) {
		this.instance = instance;
	}

  
  @GET
  
  
  
  @ApiOperation(value = "", notes = "Get the OutputThing for a given name.", response = OutputThing.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Got an output thing."),
    
    @ApiResponse(code = 404, message = "No such key.") })

  public Response testGet(@ApiParam(value = "",required=true) @QueryParam("oname") String oname)
      throws NotFoundException {
	  Response response=null;
	  try{
		  
		  response=instance.testGetImpl(  oname);
	  }catch(Exception e){
		e.printStackTrace();
		response = Response.status(500).entity(e.getMessage()).build();
	  }
      return response;
   }

  
  @POST
  
  
  
  @ApiOperation(value = "", notes = "If a value is provided, update the name with the value. Otherwise, set the value to an empty string. In either case, return the corresponding OutputThing.", response = OutputThing.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Got an output thing.") })

  public Response testPost(@ApiParam(value = "" ,required=true ) InputThing inthing)
      throws NotFoundException {
	  Response response=null;
	  try{
		  
		  response=instance.testPostImpl(inthing);
	  }catch(Exception e){
		e.printStackTrace();
		response = Response.status(500).entity(e.getMessage()).build();
	  }
      return response;
   }

  
}

