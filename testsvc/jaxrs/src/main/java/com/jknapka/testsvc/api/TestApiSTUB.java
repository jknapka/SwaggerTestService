package com.jknapka.testsvc.api;

import com.jknapka.testsvc.model.*;

import com.sun.jersey.core.header.FormDataContentDisposition;
import java.io.InputStream;
import java.util.List;
import javax.ws.rs.core.Response;


import com.jknapka.testsvc.model.KeyError;
import com.jknapka.testsvc.model.OutputThing;
import com.jknapka.testsvc.model.InputThing;


import java.util.List;
import com.jknapka.testsvc.api.NotFoundException;



public class TestApiSTUB implements TestApiInterface{
  
  public Response testGetImpl( String oname)
      throws NotFoundException {
      
      return Response.ok().entity(new OutputThing()).build() /*OutputThing*/    /**/;
      
      
      }

  
  public Response testPostImpl( InputThing inthing)
      throws NotFoundException {
      
      return Response.ok().entity(new OutputThing()).build() /*OutputThing*/    /**/;
      
      
      }

  
}


