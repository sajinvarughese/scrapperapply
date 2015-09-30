package org.scrappers.insertdata;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.scrappers.DB.DataSource;

public class InsertValues extends InsertVariables{

	
	public void insertValues(){
		
		company = "Netscribes";
		formType = "2";
		formfillUrl = "http://www.netscribes.com/index.php/career/join-the-ns-family?tmpl=component&task=addresponse&positionid=20&position=UmVzZWFyY2ggQW5hbHlzdCAvIFNlbmlvciBSZXNlYXJjaCAgQW5hbHlzdCAoSGVhbHRoY2FyZSBWZXJ0aWNhbCk=";
		applyUrl = "http://www.netscribes.com/index.php/career/index.php";
		
		firstName = "firstname";
		lastName = "lastname";
		emailId = "emailid";
		mobileNumber = "contactnumber";
		experience = "drpExperience~$~";
		city = "clocation";

		currentSalary = "fixed_remuneration";
		noticePeriod = "notice_period";
		preferredLocation = "chkBranches[]~$~";
		resumeUploaderId = "file";
		
		hiddenInputFields = "option~:~task~:~controller~:~positionid~:~position~:~flag";

		
		DataSource ds = null;
		Connection con = null;
		try {
			ds = DataSource.getInstance();
			con =  ds.getConnection();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try{
		String query = "insert into apply_details(company, form_type, formfill_url, "
				+ "apply_url, first_name, last_name, email_id, mobile_number, "
				+ "resume_uploader_id, hidden_input_fields, submit_id, "
				+ "parameter_count, full_name, date_of_birth, dob_day, dob_month, dob_year, "
				+ "country, state, city, address, preferred_location, experience, "
				+ "experience_month, experience_year, current_organization, "
				+ "current_designation, current_salary, expected_salary, "
				+ "notice_period, skills, apply_post, qualification, gender) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, company);
		ps.setString(2, formType);
		ps.setString(3, formfillUrl);
		ps.setString(4, applyUrl);
		ps.setString(5, firstName);
		ps.setString(6, lastName);
		ps.setString(7, emailId);
		ps.setString(8, mobileNumber);
		ps.setString(9, resumeUploaderId);
		ps.setString(10, hiddenInputFields);
		ps.setString(11, submitId);
		ps.setString(12, parameterCount);
		ps.setString(13, fullName);
		ps.setString(14, dateOfBirth);
		ps.setString(15, dobDay);
		ps.setString(16, dobMonth);
		ps.setString(17, dobYear);
		ps.setString(18, country);
		ps.setString(19, state);
		ps.setString(20, city);
		ps.setString(21, address);
		ps.setString(22, preferredLocation);
		ps.setString(23, experience);
		ps.setString(24, experienceMonth);
		ps.setString(25, experienceYear);
		ps.setString(26, currentOrganization);
		ps.setString(27, currentDesignation);
		ps.setString(28, currentSalary);
		ps.setString(29, expectedSalary);
		ps.setString(30, noticePeriod);
		ps.setString(31, skills);
		ps.setString(32, applyPost);
		ps.setString(33, qualification);
		ps.setString(34, gender);

		
		int a = ps.executeUpdate();
		
		if(a > 0){
			System.out.println("inserted Successfully");
		}
		
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new InsertValues().insertValues();
	}
	
}
