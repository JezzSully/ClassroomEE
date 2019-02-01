package com.jez.persistence.repository;

public interface ClassroomRepository {

	String getAllClassrooms();

	String createClassroom(String classroom);

	String deleteClassroom(Long id);

	String updateClassroom(long id, String classroom);
}
