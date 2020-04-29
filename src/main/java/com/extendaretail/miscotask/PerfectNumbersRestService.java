package com.extendaretail.miscotask;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.extendaretail.miscotask.perfectnumber.PerfectNumberService;
import com.extendaretail.miscotask.perfectnumber.PerfectNumbersImmutableObjectsService;

@Path("/")
public class PerfectNumbersRestService {
	private final PerfectNumberService perfectNumbersService = new PerfectNumbersImmutableObjectsService();
	
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "PerfectNumbersRestService is running";
    }
    
    @GET
    @Path("isPerfect/{number}")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean isPerfect(@PathParam("number")Long number) {
    	return perfectNumbersService.isPerfect(number) ? true : false; 
    }
    
    @GET
    @Path("perfectNumbersFromRange/{start}/{end}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Long> perfectNumbersFromRange(@PathParam("start")Long start, @PathParam("end")Long end) {
		return perfectNumbersService.perfectNumbersFromRange(start, end);
    }
}
