package org.scrappers.othercompanies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.scrappers.DB.DataSource;
import org.scrappers.bean.UserDetails;

public class ReadUserDetailsFromDB {
	
			/**
			 * Method which reads user details from DB and set it into bean class UserDetails
			 * @param email
			 * @return UserDetails
			 */
			public static UserDetails fetchUserDetails(String email){
				
				UserDetails user = null;
				DataSource ds = null;
				Connection con = null;
				try {
					ds = DataSource.getInstance();
					con =  ds.getConnection();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try{
				user = new UserDetails();
				
				PreparedStatement statement = con.prepareStatement("select * from user_details where email_id = ?");
				statement.setString(1, email);
				
				user.setEmailId(email);
				ResultSet result = statement.executeQuery();
				
				while(result.next()){
					
					user.setFirstName(result.getString("first_name") == null ? "" : result.getString("first_name"));
					user.setLastName(result.getString("last_name") == null ? "" : result.getString("last_name"));
					user.setEmailId(result.getString("email_id") == null ? "" : result.getString("email_id"));
					user.setMobileNumber(result.getString("mobile_number") == null ? "" : result.getString("mobile_number"));
					user.setDateOfBirth(result.getString("date_of_birth") == null ? "" : result.getString("date_of_birth"));
					user.setCountry(result.getString("country") == null ? "" : result.getString("country"));
					user.setState(result.getString("state") == null ? "" : result.getString("state"));
					user.setCity(result.getString("city") == null ? "" : result.getString("city"));
					user.setAddress(result.getString("address") == null ? "" : result.getString("address"));
					user.setExperienceMonth(result.getString("experience_month") == null ? "" : result.getString("experience_month"));
					user.setExperienceYear(result.getString("experience_year") == null ? "" : result.getString("experience_year"));
					user.setCurrentOrganization(result.getString("current_organization") == null ? "" : result.getString("current_organization"));
					user.setCurrentDesignation(result.getString("current_designation") == null ? "" : result.getString("current_designation"));
					user.setCurrentSalary(result.getString("current_salary") == null ? "" : result.getString("current_salary"));
					user.setExpectedSalary(result.getString("expected_salary") == null ? "" : result.getString("expected_salary"));
					user.setSkills(result.getString("skills") == null ? "" : result.getString("skills"));
					user.setQualification(result.getString("qualification") == null ? "" : result.getString("qualification"));
					user.setGender(result.getString("gender") == null ? "" : result.getString("gender"));


				}
				
				
				}catch(Exception e){
					System.out.println(e);
				}
				
				return user;
			}
}
