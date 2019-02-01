package com.jez.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.jez.persistence.domain.Classroom;
import com.jez.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepo implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonUtil;

	private String successMessage = "{\"message\":\"Success\"}";
	private String failureMessage = "{\"message\":\"Failure\"}";

	public String getAllClassrooms() {
		TypedQuery<Classroom> query = manager.createQuery("SELECT c from Classroom c", Classroom.class);
		return jsonUtil.getJSONForObject(query.getResultList());
	}

	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom myClassroom = jsonUtil.getObjectForJSON(classroom, Classroom.class);
		manager.persist(myClassroom);
		return this.successMessage;
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom myClassroom = manager.find(Classroom.class, id);
		if (myClassroom != null) {
			manager.remove(myClassroom);
			return this.successMessage;
		} else {
			return this.failureMessage;
		}
	}

	@Transactional(REQUIRED)
	public String updateClassroom(long id, String classroom) {
		if (deleteClassroom(id).equals(this.successMessage)) {
			createClassroom(classroom);
			return this.successMessage;
		} else {
			return this.failureMessage;
		}
	}

}
