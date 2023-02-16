package in.ineuron.factory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

public class StudentServiceFactory {
    private static IStudentService studentServiceImpl = null;
	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentService() {
		if (studentServiceImpl == null) 
		studentServiceImpl=new StudentServiceImpl();
		
		return studentServiceImpl;
	}
}
