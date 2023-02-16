package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

public class StudentControllerImpl implements IStudentController {
     
	IStudentService stdService;
	@Override
	public String save(Student student) {
		stdService=StudentServiceFactory.getStudentService();
		
		// TODO Auto-generated method stub
		
		return stdService.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		// TODO Auto-generated method stub
		stdService=StudentServiceFactory.getStudentService();
		return stdService.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		// TODO Auto-generated method stub
		stdService=StudentServiceFactory.getStudentService();
		return stdService.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		// TODO Auto-generated method stub
		stdService=StudentServiceFactory.getStudentService();
		
		return stdService.deleteById(sid);
	}

}
