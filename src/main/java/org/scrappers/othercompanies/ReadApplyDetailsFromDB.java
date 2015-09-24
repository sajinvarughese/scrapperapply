package org.scrappers.othercompanies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.scrappers.DB.DataSource;
import org.scrappers.bean.FormDetails;

public class ReadApplyDetailsFromDB {

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
			form.setApplyUrl(result.getString(3) == null ? "" : result.getString(3)); 
			form.setFormType(result.getString(4) == null ? "" : result.getString(4));
			form.setParameterCount(result.getString(5) == null ? "" : result.getString(5));
			form.setFullName(result.getString(6) == null ? "" : result.getString(6));
			form.setEmailId(result.getString(7) == null ? "" : result.getString(7));
			form.setMobileNumber(result.getString(8) == null ? "" : result.getString(8));
			form.setDateOfBirth(result.getString(9) == null ? "" : result.getString(9));
			form.setCountry(result.getString(10) == null ? "" : result.getString(10));
			form.setState(result.getString(11) == null ? "" : result.getString(11));
			form.setCity(result.getString(12) == null ? "" : result.getString(12));
			form.setExperience(result.getString(13) == null ? "" : result.getString(13));
			form.setExperienceMonth(result.getString(14) == null ? "" : result.getString(14));
			form.setExperienceYear(result.getString(15) == null ? "" : result.getString(15));
			form.setCurrentSalary(result.getString(16) == null ? "" : result.getString(16));
			form.setExpectedSalary(result.getString(17) == null ? "" : result.getString(17));
			form.setSubmitId(result.getString(18) == null ? "" : result.getString(18));
			form.setResumeUploaderId(result.getString(19) == null ? "" : result.getString(19));
			
		}
		
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		return form;
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
}
