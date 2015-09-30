package org.scrappers.othercompanies;

import java.io.File;

import javax.swing.JOptionPane;

import org.scrappers.bean.FormDetails;
import org.scrappers.bean.UserDetails;
import org.scrappers.util.ApplyJobHelper;

public class ApplyJob {

	/**
	 * Method To Apply to job with applied user emailid and the company user applied.
	 * @param emailId
	 * @param company
	 */
	public static void checkAndApply(String emailId, String company){

		UserDetails user = ReadUserDetailsFromDB.fetchUserDetails(emailId); 	// Return all user details
		
		FormDetails form = ReadApplyDetailsFromDB.fetchApplyDetails(company); 	// Return all Form field values to Post
		
		String filePath = "/home/worklyf/Downloads/DOWNLOADS DUMP SEP 9/poc.doc";
        
		File uploadFile = new File(filePath);
        try {
            String serverReply = ApplyJobHelper.serverResponse(user, form , uploadFile); // Returning Server Response String
            System.out.println(serverReply);
//            Document returndoc = Jsoup.parse(serverReply.toString());
//            System.out.println(returndoc.text());
        } catch (Exception ex) {
            System.err.println(ex);
        }

	}
	
	
	public static void main(String[] args) {	
		checkAndApply("sajinvarughese@gmail.com", "Netscribes");
	}
}
