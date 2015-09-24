package org.scrappers.othercompanies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.scrappers.DB.DataSource;
import org.scrappers.bean.UserDetails;

public class ReadUserDetailsFromDB {
	
	
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
			user.setFullName(result.getString(2) == null ? "" : result.getString(2));
			user.setEmailId(result.getString(3) == null ? "" : result.getString(3));
			user.setMobileNumber(result.getString(4) == null ? "" : result.getString(4));
			user.setDateOfBirth(result.getString(5) == null ? "" : result.getString(5));
			user.setCountry(result.getString(6) == null ? "" : result.getString(6));
			user.setState(result.getString(7) == null ? "" : result.getString(7));
			user.setCity(result.getString(8) == null ? "" : result.getString(8));
			user.setAddress(result.getString(9) == null ? "" : result.getString(9));
			user.setExperienceMonth(result.getString(10) == null ? "" : result.getString(10));
			user.setExperienceYear(result.getString(11) == null ? "" : result.getString(11));
			user.setCurrentSalary(result.getString(12) == null ? "" : result.getString(12));
			user.setExpectedSalary(result.getString(13) == null ? "" : result.getString(13));
			
		}
		
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		return user;
	}
}
