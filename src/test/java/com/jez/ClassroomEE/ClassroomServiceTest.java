package com.jez.ClassroomEE;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.jez.persistence.domain.Classroom;
import com.jez.persistence.domain.Trainee;
import com.jez.persistence.repository.ClassroomDBRepo;
import com.jez.persistence.repository.ClassroomMapRepo;
import com.jez.persistence.repository.ClassroomRepository;
import com.jez.util.JSONUtil;

@Ignore
public class ClassroomServiceTest {

	private ClassroomRepository myRepo;
	
	private JSONUtil jsonUtil;
	
	private String successMessage = "{\"message\":\"Sucess\"}";
	private String failureMessage = "{\"message\":\"Failure\"}";
	
	@Before
	public void setUp() {
		myRepo = new ClassroomMapRepo();
		jsonUtil = new JSONUtil();
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void addClassroomTest() {
		Classroom myClassroom = new Classroom("Matt");
		//myClassroom.addTrainee(new Trainee("Jez"));
		String classroomJson = jsonUtil.getJSONForObject(myClassroom);
		assertTrue(this.successMessage.equals(myRepo.createClassroom(classroomJson)));
		Classroom[] classrooms = jsonUtil.getObjectForJSON(myRepo.getAllClassrooms(), Classroom[].class);
		assertEquals(1, classrooms.length);
	}
	
	@Test
	public void add2ClassroomTest() {
		Classroom myClassroom = new Classroom("Matt");
		Classroom myClassroom2 = new Classroom("Chez");
		myClassroom.addTrainee(new Trainee("Jez"));
		String classroomJson = jsonUtil.getJSONForObject(myClassroom);
		myClassroom2.addTrainee(new Trainee("Jez"));
		String classroomJson2 = jsonUtil.getJSONForObject(myClassroom2);
		
		assertTrue(this.successMessage.equals(myRepo.createClassroom(classroomJson)));
		assertTrue(this.successMessage.equals(myRepo.createClassroom(classroomJson2)));
		
		Classroom[] classrooms = jsonUtil.getObjectForJSON(myRepo.getAllClassrooms(), Classroom[].class);
		assertEquals(2, classrooms.length);
	}
	
	@Test
	public void removeClassroomTest() {
		Classroom myClassroom = new Classroom("Matt");
		myRepo.createClassroom(jsonUtil.getJSONForObject(myClassroom));
		assertTrue(this.successMessage.equals(myRepo.deleteClassroom(myClassroom.getClassroomID())));
		Classroom[] classrooms = jsonUtil.getObjectForJSON(myRepo.getAllClassrooms(), Classroom[].class);
		assertEquals(0, classrooms.length);
	}
	
	@Test
	public void removeClassFailTest() {
		Classroom myClassroom = new Classroom("Matt");
		assertTrue(this.failureMessage.equals((myRepo.deleteClassroom(myClassroom.getClassroomID()))));
	}
}
