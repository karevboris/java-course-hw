package com.netcracker;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalculationRestService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add/{a}/{b}")
    public double add (@PathParam("a") double a, @PathParam("b") double b){
        return a+b;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/del/{a}/{b}")
    public double del (@PathParam("a") double a, @PathParam("b") double b){
        return a-b;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/mult/{a}/{b}")
    public double mult (@PathParam("a") double a, @PathParam("b") double b){
        return a*b;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/div/{a}/{b}")
    public double div (@PathParam("a") double a, @PathParam("b") double b){
        return a/b;
    }
}
