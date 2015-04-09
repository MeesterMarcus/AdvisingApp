package advising;

import java.util.ArrayList;

public class AdvisingModel {
	private ArrayList<Student> students = new ArrayList<Student>(); 
	
	public AdvisingModel() {
		
	}
	
	public void addStudent(Student student) {
		students.add(student); 
	}
	
	
	public String toString() {
		//fname, lname,  dob, address, city, state, zip, email
		String s = ""; 
		for (int i = 0; i < students.size(); i++) {
			Student currstudent = students.get(i); 
			
			s+="Student "+(i+1)+"\n";
			s+="Banner ID: "+currstudent.getBanner()+"\n"; 
			s+="First Name: "+currstudent.getFName()+"\n"; 
			s+="Last Name: "+currstudent.getLName()+"\n"; 
			s+="Date of Birth: "+currstudent.getDOB()+"\n"; 
			s+="Address: "+currstudent.getAddress()+"\n"; 
			s+="City: "+currstudent.getCity()+"\n"; 
			s+="State: "+currstudent.getState()+"\n"; 
			s+="Zip: "+currstudent.getZip()+"\n"; 
			s+="Email: "+currstudent.getEmail()+"\n"; 
			s+="\n";
			
		}
		return s; 
	}

}
