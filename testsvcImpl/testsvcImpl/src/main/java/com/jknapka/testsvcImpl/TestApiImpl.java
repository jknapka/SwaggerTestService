package com.jknapka.testsvcImpl;

import com.jknapka.testsvc.model.OutputThing;
import com.jknapka.testsvc.model.InputThing;
import com.jknapka.testsvc.model.KeyError;
import com.jknapka.testsvc.api.NotFoundException;
import com.jknapka.testsvc.api.TestApiInterface;
import javax.ws.rs.core.Response;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TestApiImpl implements TestApiInterface {
  
    public Response testGetImpl( String oname)
        throws NotFoundException {
        Logger logger = LoggerFactory.getLogger(TestApiImpl.class);
        String val = things.get(oname);
        logger.info("Got value of "+oname+": "+val);
        if (val == null) {
            KeyError kerr = new KeyError();
            kerr.setOname(oname);
            return Response.status(404).entity(kerr).build();
        }
        OutputThing result = new OutputThing();
        result.setOname(oname);
        result.setOvalue(val);
        return Response.ok().entity(result).build();
    }

  
    public Response testPostImpl( InputThing inthing)
        throws NotFoundException {
        Logger logger = LoggerFactory.getLogger(TestApiImpl.class);
        logger.info("TestApiImpl putting "+inthing);
        things.put(inthing.getOname(),inthing.getOvalue());
        return testGetImpl(inthing.getOname());
    }

    HashMap<String,String> things = new HashMap();


}
