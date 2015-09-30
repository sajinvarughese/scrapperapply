package org.scrappers.othercompanies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.scrappers.DB.DataSource;
import org.scrappers.bean.FormDetails;

public class ReadApplyDetailsFromDB {
	
	/**
	 * Method which reads all the form field values from DB and set it into bean class FormDetails
	 * @param company
	 * @return FormDetails
	 */
	public static FormDetails fetchApplyDetails(String company){
		
		FormDetails form = null;
		DataSource ds = null;
		Connection con = null;
		try {
			ds = DataSource.getInstance();
			con =  ds.getConnection();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try{
		form = new FormDetails();
		form.setCompany(company);
		
		PreparedStatement statement = con.prepareStatement("select * from apply_details where company = ?");
		statement.setString(1, company);
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()){
			
			form.setFormfillUrl(result.getString("formfill_url") == null ? "" : result.getString("formfill_url"));
			form.setApplyUrl(result.getString("apply_url") == null ? "" : result.getString("apply_url")); 
			form.setFormType(result.getString("form_type") == null ? "" : result.getString("form_type"));
			form.setParameterCount(result.getString("parameter_count") == null ? "" : result.getString("parameter_count"));
			form.setFullName(result.getString("full_name") == null ? "" : result.getString("full_name"));
			form.setFirstName(result.getString("first_name") == null ? "" : result.getString("first_name"));
			form.setLastName(result.getString("last_name") == null ? "" : result.getString("last_name"));
			form.setEmailId(result.getString("email_id") == null ? "" : result.getString("email_id"));
			form.setMobileNumber(result.getString("mobile_number") == null ? "" : result.getString("mobile_number"));
			form.setDateOfBirth(result.getString("date_of_birth") == null ? "" : result.getString("date_of_birth"));
			form.setCountry(result.getString("country") == null ? "" : result.getString("country"));
			form.setState(result.getString("state") == null ? "" : result.getString("state"));
			form.setCity(result.getString("city") == null ? "" : result.getString("city"));
			form.setAddress(result.getString("address") == null ? "" : result.getString("address"));
			form.setExperience(result.getString("experience") == null ? "" : result.getString("experience"));
			form.setExperienceMonth(result.getString("experience_month") == null ? "" : result.getString("experience_month"));
			form.setExperienceYear(result.getString("experience_year") == null ? "" : result.getString("experience_year"));
			form.setCurrentOrganization(result.getString("current_organization") == null ? "" : result.getString("current_organization"));
			form.setCurrentDesignation(result.getString("current_designation") == null ? "" : result.getString("current_designation"));
			form.setCurrentSalary(result.getString("current_salary") == null ? "" : result.getString("current_salary"));
			form.setExpectedSalary(result.getString("expected_salary") == null ? "" : result.getString("expected_salary"));
			form.setSubmitId(result.getString("submit_id") == null ? "" : result.getString("submit_id"));
			form.setResumeUploaderId(result.getString("resume_uploader_id") == null ? "" : result.getString("resume_uploader_id"));
			form.setHiddenInputFields(result.getString("hidden_input_fields") == null ? "" : result.getString("hidden_input_fields"));
			form.setSkills(result.getString("skills") == null ? "" : result.getString("skills"));
			form.setApplyPost(result.getString("apply_post") == null ? "" : result.getString("apply_post"));
			form.setQualification(result.getString("qualification") == null ? "" : result.getString("qualification"));
			form.setGender(result.getString("gender") == null ? "" : result.getString("gender"));
			form.setNoticePeriod(result.getString("notice_period") == null ? "" : result.getString("notice_period"));
			form.setDobDay(result.getString("dob_day") == null ? "" : result.getString("dob_day"));
			form.setDobMonth(result.getString("dob_month") == null ? "" : result.getString("dob_month"));
			form.setDobYear(result.getString("dob_year") == null ? "" : result.getString("dob_year"));
			form.setPreferredLocation(result.getString("preferred_location") == null ? "" : result.getString("preferred_location"));

			
		}
		
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		return form;
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
}
