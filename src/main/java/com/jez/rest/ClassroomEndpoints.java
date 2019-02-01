package com.jez.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.jez.business.ClassroomBusiness;

@Path("/classroom")
public class ClassroomEndpoints {
	
	@Inject
	private ClassroomBusiness service;
	
	@Path("/")
	@GET
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/")
	@POST
	public String createClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/{id}")
	@POST
	public String updateClassroom(@PathParam("id")long id, String classroom) {
		return service.updateClassroom(id, classroom);
	}
	
	@Path("/{id}")
	@POST
	public String deleteClassroom(@PathParam("id")long id) {
		return service.deleteClassroom(id);
	}
}
