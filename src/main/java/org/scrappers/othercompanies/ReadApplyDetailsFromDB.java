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
			
			form.setFormfillUrl(result.getString(3) == null ? "" : result.getString(3));
			form.setApplyUrl(result.getString(4) == null ? "" : result.getString(4)); 
			form.setFormType(result.getString(5) == null ? "" : result.getString(5));
			form.setParameterCount(result.getString(6) == null ? "" : result.getString(6));
			form.setFullName(result.getString(7) == null ? "" : result.getString(7));
			form.setEmailId(result.getString(8) == null ? "" : result.getString(8));
			form.setMobileNumber(result.getString(9) == null ? "" : result.getString(9));
			form.setDateOfBirth(result.getString(10) == null ? "" : result.getString(10));
			form.setCountry(result.getString(11) == null ? "" : result.getString(11));
			form.setState(result.getString(12) == null ? "" : result.getString(12));
			form.setCity(result.getString(13) == null ? "" : result.getString(13));
			form.setAddress(result.getString(14) == null ? "" : result.getString(14));
			form.setExperience(result.getString(15) == null ? "" : result.getString(15));
			form.setExperienceMonth(result.getString(16) == null ? "" : result.getString(16));
			form.setExperienceYear(result.getString(17) == null ? "" : result.getString(17));
			form.setCurrentOrganization(result.getString(18) == null ? "" : result.getString(18));
			form.setCurrentDesignation(result.getString(19) == null ? "" : result.getString(19));
			form.setCurrentSalary(result.getString(20) == null ? "" : result.getString(20));
			form.setExpectedSalary(result.getString(21) == null ? "" : result.getString(21));
			form.setSubmitId(result.getString(22) == null ? "" : result.getString(22));
			form.setResumeUploaderId(result.getString(23) == null ? "" : result.getString(23));
			form.setHiddenInputFields(result.getString(24) == null ? "" : result.getString(24));
			form.setSkills(result.getString(25) == null ? "" : result.getString(25));
			form.setApplyPost(result.getString(26) == null ? "" : result.getString(26));
			form.setQualification(result.getString(27) == null ? "" : result.getString(27));
			form.setGender(result.getString(28) == null ? "" : result.getString(28));

			
		}
		
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		return form;
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
}
