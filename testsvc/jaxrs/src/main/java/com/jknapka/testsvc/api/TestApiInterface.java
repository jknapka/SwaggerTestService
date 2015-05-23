package com.jknapka.testsvc.api;

import com.jknapka.testsvc.model.*;


import com.jknapka.testsvc.model.KeyError;
import com.jknapka.testsvc.model.OutputThing;
import com.jknapka.testsvc.model.InputThing;


import java.util.List;
import com.jknapka.testsvc.api.NotFoundException;
import java.io.InputStream;
import com.sun.jersey.core.header.FormDataContentDisposition;
import javax.ws.rs.core.Response;



public interface TestApiInterface {
  
  public Response testGetImpl( String oname)
      throws NotFoundException ;

  
  public Response testPostImpl( InputThing inthing)
      throws NotFoundException ;

  
}


