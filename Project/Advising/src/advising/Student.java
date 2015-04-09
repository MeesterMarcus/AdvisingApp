package advising;

import java.util.Arrays;

public class Student {
	//bannerid, fname, lname,  dob, address, city, state, zip, email
	private String personalInfo[] = new String[9];
	
	public Student () {
		for (int i = 0; i < 8; i++) {
			personalInfo[i] = ""; 
		}
	}
	
	public Student (String initPersonal[]) {
		personalInfo = initPersonal; 
	}
	
	public String getBanner(){
		return personalInfo[0];
	}
	
	public String getFName() {
		return personalInfo[1]; 
	}
	
	public String getLName() {
		return personalInfo[2]; 
	}
	
	public String getDOB() {
		return personalInfo[3]; 
	}
	
	public String getAddress() {
		return personalInfo[4]; 
	}
	
	public String getCity() {
		return personalInfo[5]; 
	}
	
	public String getState() {
		return personalInfo[6]; 
	}
	
	public String getZip() {
		return personalInfo[7]; 
	}
	public String getEmail() {
		return personalInfo[8]; 
	}
	

	
	public String toString() {
		return Arrays.toString(personalInfo); 
	}

}
