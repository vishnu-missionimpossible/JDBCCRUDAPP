package in.ineuron.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IStudentController studentController = null;
		String status=null,name=null,city=null,email=null,country=null;
		Integer id=null;
		Student studentRecord = null;
		
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("Enter the number to perform the operation...");
				Integer option = Integer.parseInt(br.readLine());
				
				
				switch (option) {
				case 1: {
					System.out.println("Enter the name:: ");
					name = br.readLine();
					
					System.out.println("Enter the email:: ");
					email = br.readLine();
					
					System.out.println("Enter the city:: ");
					city = br.readLine();
					
					System.out.println("Enter the country:: ");
					country = br.readLine();
					
					Student student = new Student();
					student.setName(name);
					student.setEmail(email);
					student.setCity(city);
					student.setCountry(country);
					
					
					studentController = StudentControllerFactory.getStudentController();
					status = studentController.save(student);
					if(status.equalsIgnoreCase("success"))
						System.out.println("Records inserted successfully..");
					else if(status.equalsIgnoreCase("failure"))
						System.out.println("Records insertion failed...");
					else
						System.out.println("Some problem occurred...");
					break;
				}
				case 2: {
					System.out.println("Enter the id to view the record: ");
					id= Integer.parseInt(br.readLine());
					studentController = StudentControllerFactory.getStudentController();
					studentRecord = studentController.findById(id);
					
					if (studentRecord != null) {
						System.out.println(studentRecord);
					}else {
						System.out.println("Record is not available for the given id ::"+id);
					}
					break;
				}
				case 3: {
					System.out.println("Enter the id of the record to be updated: ");
					id= Integer.parseInt(br.readLine());
					studentController = StudentControllerFactory.getStudentController();
					
					if (studentRecord != null) {
							Student newStudent  = new Student();
							newStudent.setId(id);
							//Updation of name 
							System.out.print("StudentName is ::[Old name is :: "+studentRecord.getName()+"]");
							String newName= br.readLine();
								if (newName == null || newName.equals("")) {
									newStudent.setName(studentRecord.getName());
								}else {
									newStudent.setName(newName);
								}
							//Updation of Email	
							System.out.print("StudentEmail is ::[Old email is :: "+studentRecord.getEmail()+"]");
							String newEmail= br.readLine();
								if (newEmail == null || newEmail.equals("")) {
										newStudent.setEmail(studentRecord.getEmail());
									}else {
										newStudent.setEmail(newEmail);
									}	
							
						  //Updation of City	
							System.out.print("StudentCity is ::[Old city is :: "+studentRecord.getCity()+"]");
							String newCity= br.readLine();
									if (newCity == null || newCity.equals("")) {
											newStudent.setCity(studentRecord.getCity());
										}else {
											newStudent.setCity(newCity);
										}	
							//Updation of Country		
							System.out.print("StudentCountry is ::[Old country is :: "+studentRecord.getCountry()+"]");
							String newCountry= br.readLine();
										if (newCountry == null || newCountry.equals("")) {
													newStudent.setCountry(studentRecord.getCountry());
											}else {
													newStudent.setCountry(newCountry);
											}		
							status = studentController.updateById(newStudent);			
							if(status.equalsIgnoreCase("success"))
								System.out.println("Records updation successfully..");
							else if(status.equalsIgnoreCase("failure"))
								System.out.println("Records updation failed...");
							else
								System.out.println("Record not available for the given id to update... ");	
						
					}else {
						System.out.println("Record is not available for the given id ::"+id);
					}
					break;
				}
				case 4: {
					System.out.println("Please Enter the id below to perform delete operation : ");
					id= Integer.parseInt(br.readLine());
					studentController = StudentControllerFactory.getStudentController();
					status = studentController.deleteById(id);
					if(status.equalsIgnoreCase("success"))
						System.out.println("Records deleted successfully..");
					else if(status.equalsIgnoreCase("failure"))
						System.out.println("Records deletion failed...");
					else
						System.out.println("Record not available for the given id to delete... ");
					break;
				}
				case 5: {
					System.out.println("Thanks for using the application");
					System.exit(0);
				}
				default:
					System.out.println("Plz enter the option like [1,2,3,4,5] for operation");
					break;
				}
				
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
     
	}

}
