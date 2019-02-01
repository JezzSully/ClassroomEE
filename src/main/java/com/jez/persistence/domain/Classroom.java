package com.jez.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@Column(name = "CLASSROOMID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long classroomID;

	private String trainer;

	@OneToMany(targetEntity = com.jez.persistence.domain.Trainee.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Trainee> trainees;

	public Classroom() {

	}
	
	public Classroom(String trainer) {
		this.trainer = trainer;
		this.trainees = new ArrayList<Trainee>();
	}

	public Classroom(String trainer, List<Trainee> trainees) {
		this.trainer = trainer;
		this.trainees = trainees;
	}

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
	
	public void addTrainee(Trainee trainee) {
		this.trainees.add(trainee);
	}
	
	public void removeTrainee(Trainee trainee) {
		this.trainees.remove(trainee);
	}
}
