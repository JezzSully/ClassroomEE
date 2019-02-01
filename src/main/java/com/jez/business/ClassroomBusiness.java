package com.jez.business;

import javax.inject.Inject;

import com.jez.persistence.repository.ClassroomRepository;
import com.jez.util.JSONUtil;

public class ClassroomBusiness implements BusinessInterface {

	@Inject
	private ClassroomRepository myRepo;

	@Inject
	private JSONUtil jsonUtil;

	public String getAllClassrooms() {
		return myRepo.getAllClassrooms();
	}

	public String createClassroom(String classroom) {
		return myRepo.createClassroom(classroom);
	}

	public String deleteClassroom(Long id) {
		return myRepo.deleteClassroom(id);
	}

	public String updateClassroom(long id, String classroom) {
		return myRepo.updateClassroom(id, classroom);
	}

}
