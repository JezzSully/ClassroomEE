package com.jez.business;

public interface BusinessInterface {
	String getAllClassrooms();

	String createClassroom(String classroom);

	String deleteClassroom(Long id);

	String updateClassroom(long id, String classroom);
}
