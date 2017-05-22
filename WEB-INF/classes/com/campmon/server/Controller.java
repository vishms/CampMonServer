package com.campmon.server;

import java.io.IOException;
import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;





import com.campmon.dao.AddSubClientInput;
import com.campmon.dao.CreateListClientInput;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/data")
public class Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/token/{code}")
	public Response getToken(@PathParam("code") String code) throws IOException {
		System.out.println("code: " + code);
		code = code.replace("-", "/");
		System.out.println("code original: " + code);
		
		System.out.println("in get token________________________________");
		Client client = Client.create();
		WebResource webResource = client
		   .resource("https://api.createsend.com/oauth/token?grant_type=authorization_code&client_id=107741&client_secret=6E3BvsOnC31f3GDZMhzg33tzK33BRE8dN3w7UR2383LQMtyNb331333cgO337HPf3q3mg3n71J3rOe3H&"
		   		+ "code=" + code + "&redirect_uri=http://localhost:3000/campmon");
		System.out.println("url: " +webResource.getURI().toString());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
				   .post(ClientResponse.class);
		
		
		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println("response code: " + response.getStatus() + " " + "output: " + output);
		
		return Response.status(response.getStatus())
				.entity(output)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST")
				.build();
		//return output;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list/{accesskey}")
	public Response getList(@PathParam("accesskey") String accesskey) throws IOException {
		accesskey = accesskey.replace("-", "/");

		System.out.println("in get list______________________");
		Client client = Client.create();

		accesskey = "Bearer " + accesskey; // appKey is unique number

		WebResource webResource = client
		   .resource("https://api.createsend.com/api/v3.1/clients/c249002d14a981c100799aa270c72536/lists.json");
		System.out.println("url: " +webResource.getURI().toString());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
				.header("Authorization", accesskey)
				   .get(ClientResponse.class);
		
		
		System.out.println("Output from Server ....");
		String output = response.getEntity(String.class);
		System.out.println("response code: " + response.getStatus() + " " + "output: " + output);
		
		
		
		return Response.status(response.getStatus())
				.entity(output)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET")
				.build();
		//return output;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/list/{accesskey}")
	public Response createList(@PathParam("accesskey") String accesskey, CreateListClientInput data) throws IOException {
		accesskey = accesskey.replace("-", "/");
		System.out.println("appkey: " + accesskey);
		
		System.out.println("in create list________________________________");
		System.out.println("data: " + data);

		Client client = Client.create();
		accesskey = "Bearer " + accesskey; // appKey is unique number
		String url = "https://api.createsend.com/api/v3.1/lists/c249002d14a981c100799aa270c72536.json";
		WebResource webResource = client
		   .resource(url);
		System.out.println("url: " +webResource.getURI().toString());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
				.header("Authorization", accesskey)
				   .post(ClientResponse.class, data);
		
		
		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println("response code: " + response.getStatus() + " " + "output: " + output);
		
		return Response.status(response.getStatus())
				.entity(output)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST")
				.build();
	}
	
	@OPTIONS
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/list/{accesskey}")
	public Response createListPreflight() throws IOException {
		System.out.println("in create list preflight________________________________");

		return Response.status(200)
				.entity("Create List Preflight success response")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST")
				.header("Access-Control-Allow-Headers", "content-type")
				.build();
		//return output;
	}
	
	@Path("/list/AddSubscriber/{accesskey}/{listId}")
	@POST
	public Response addSubscriber(@PathParam("accesskey") String accesskey,
			@PathParam("listId") String listId, AddSubClientInput data){
		
		accesskey = accesskey.replace("-", "/");
		System.out.println("appkey: " + accesskey);
		System.out.println("listId: " + listId);
		
		System.out.println("in add subscriber________________________________");
		System.out.println("data: " + data);

		
		Client client = Client.create();
		accesskey = "Bearer " + accesskey; // appKey is unique number
		String url = "https://api.createsend.com/api/v3.1/subscribers/" + listId + ".json";
		WebResource webResource = client
		   .resource(url);
		System.out.println("url: " +webResource.getURI().toString());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
				.header("Authorization", accesskey)
				   .post(ClientResponse.class, data);
		
		
		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println("response code: " + response.getStatus() + " " + "output: " + output);
		
		return Response.status(response.getStatus())
				.entity(output)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST")
				.build();
	}
	
	@OPTIONS
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/list/AddSubscriber/{accesskey}/{listId}")
	public Response addSubPreflight() throws IOException {
		System.out.println("in add subscriber preflight________________________________");

		return Response.status(200)
				.entity("Add Subscriber Preflight success response")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST")
				.header("Access-Control-Allow-Headers", "content-type")
				.build();
		//return output;
	}
 
}
