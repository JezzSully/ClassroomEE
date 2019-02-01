package com.jez.persistence.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TRAINEEID")
	private long traineeID;
	
	private String traineeName;
	
	@ManyToOne
	@JoinColumn(name="CLASSROOMID")
	private Classroom classroom;
	
	public Trainee() {
		
	}
	
	public Trainee(String traineeName) {
		this.traineeName = traineeName;
	}

	public long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(long traineeID) {
		this.traineeID = traineeID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
}
