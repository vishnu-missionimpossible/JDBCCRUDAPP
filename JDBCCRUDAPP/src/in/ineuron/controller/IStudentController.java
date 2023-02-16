package in.ineuron.controller;

import in.ineuron.dto.Student;

public interface IStudentController {

	 String save(Student student);//For create operation of database. 
	 Student findById(Integer sid);//For Reading a record 
	 String updateById(Student student);//Updating a record
	 String deleteById(Integer sid);//Deleting a record
}
