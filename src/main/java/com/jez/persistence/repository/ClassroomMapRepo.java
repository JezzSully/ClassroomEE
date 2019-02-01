package com.jez.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.jez.persistence.domain.Classroom;
import com.jez.util.JSONUtil;

@Alternative
public class ClassroomMapRepo implements ClassroomRepository {

	@Inject
	private JSONUtil jsonUtil;

	private Map<Long, Classroom> classroomMap = new HashMap<>();

	private String successMessage = "{\"message\":\"Success\"}";
	private String failureMessage = "{\"message\":\"Failure\"}";

	public String getAllClassrooms() {
		return jsonUtil.getJSONForObject(classroomMap.values());
	}

	public String createClassroom(String classroom) {
		Classroom newClassroom = jsonUtil.getObjectForJSON(classroom, Classroom.class);
		this.classroomMap.put(newClassroom.getClassroomID(), newClassroom);
		return this.successMessage;
	}

	public String deleteClassroom(Long id) {
		if (classroomMap.containsKey(id)) {
			classroomMap.remove(id);
			return this.successMessage;
		} else {
			return this.failureMessage;
		}
	}

	public String updateClassroom(long id, String classroom) {
		if (classroomMap.containsKey(id)) {
			Classroom newClassroom = jsonUtil.getObjectForJSON(classroom, Classroom.class);
			this.classroomMap.put(id, newClassroom);
			return this.successMessage;
		} else {
			return this.failureMessage;
		}
	}

}
