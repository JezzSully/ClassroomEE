package com.jez.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CLASSROOMID")
	private long classroomID;
	
	private String trainer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "classroom", fetch = FetchType.EAGER)
	private List<Trainee> trainees;

	public long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
}
