package com.netcracker;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Scanner;

public class CalculationRestClient {

    public static double getRes(WebTarget webTarget){
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();
        return response.readEntity(Double.class);
    }

    public static void main(String[] args) throws IOException {
        Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();

        WebTarget webTarget = client.target("http://localhost:8080/rest/calc").path("add").path(String.valueOf(a)).path(String.valueOf(b));
        double res = getRes(webTarget);
        System.out.println(a+"+"+b+"="+res);

        a = in.nextDouble();
        b = in.nextDouble();

        webTarget = client.target("http://localhost:8080/rest/calc").path("del").path(String.valueOf(a)).path(String.valueOf(b));
        res = getRes(webTarget);
        System.out.println(a+"-"+b+"="+res);

        a = in.nextDouble();
        b = in.nextDouble();

        webTarget = client.target("http://localhost:8080/rest/calc").path("mult").path(String.valueOf(a)).path(String.valueOf(b));
        res = getRes(webTarget);
        System.out.println(a+"*"+b+"="+res);

        a = in.nextDouble();
        b = in.nextDouble();

        webTarget = client.target("http://localhost:8080/rest/calc").path("div").path(String.valueOf(a)).path(String.valueOf(b));
        res = getRes(webTarget);
        System.out.println(a+"/"+b+"="+res);
    }
}
