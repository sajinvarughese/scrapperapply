package org.scrappers.othercompanies;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.scrappers.bean.FormDetails;
import org.scrappers.bean.UserDetails;
import org.scrappers.util.MultipartUtility;

public class ApplyJob {

	
	public static void checkAndApply(String emailId, String company){
		
		UserDetails user = ReadUserDetailsFromDB.fetchUserDetails(emailId);
		
		FormDetails form = ReadApplyDetailsFromDB.fetchApplyDetails(company);
		
		String filePath = "/home/worklyf/Downloads/DOWNLOADS DUMP SEP 9/skill MODIFIED.docx";
		String charset = "UTF-8";
        File uploadFile = new File(filePath);
        String requestURL = form.getApplyUrl();
        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
             
            // Adding Header Parameters
            multipart.addHeaderField("Accept-Encoding", "gzip, deflate");
            multipart.addHeaderField("Content-Type", "multipart/form-data; boundary=---------------------------1866402817982626520474774539");
            multipart.addHeaderField("Connection", "keep-alive");
//            multipart.addHeaderField("Host", "www.eventurers.com");
//            multipart.addHeaderField("Referer", "http://www.eventurers.com/contact/careers/career-form/?pos=PPM");
            multipart.addHeaderField("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:40.0) Gecko/20100101 Firefox/40.0");

            
            if(!(form.getFullName().equals("") || form.getFullName() == null)){
            	multipart.addFormField(form.getFullName(), user.getFullName());
            }
            if(!form.getEmailId().equals("")){
            	multipart.addFormField(form.getEmailId(), user.getEmailId());
            }
            if(!form.getMobileNumber().equals("")){
            	multipart.addFormField(form.getMobileNumber(), user.getMobileNumber());
            }
            if(!form.getDateOfBirth().equals("")){
            	multipart.addFormField(form.getDateOfBirth(), user.getDateOfBirth());
            }
            if(!form.getCountry().equals("")){
            	multipart.addFormField(form.getCountry(), user.getCountry());
            }
            if(!form.getState().equals("")){
            	multipart.addFormField(form.getState(), user.getState());
            }
            if(!form.getCity().equals("")){
            	multipart.addFormField(form.getCity(), user.getCity());
            }
            if(!form.getExperience().equals("")){
            	multipart.addFormField(form.getExperience(), user.getExperienceYear()+" Year "+user.getExperienceMonth()+" Month");
            }
            if(!form.getExperienceMonth().equals("")){
            	multipart.addFormField(form.getExperienceMonth(), user.getExperienceMonth());
            }
            if(!form.getExperienceYear().equals("")){
            	multipart.addFormField(form.getExperienceYear(), user.getExperienceYear());
            }
            if(!form.getCurrentSalary().equals("")){
            	multipart.addFormField(form.getCurrentSalary(), user.getCurrentSalary());
            }
            if(!form.getExpectedSalary().equals("")){
            	multipart.addFormField(form.getExpectedSalary(), user.getExpectedSalary());
            }
            System.out.println(form.getSubmitId().split("~:~")[0]);
            if(!form.getSubmitId().equals("")){
            	multipart.addFormField(form.getSubmitId().split("~:~")[0], form.getSubmitId().split("~:~")[1]);
            }
            if(!form.getResumeUploaderId().equals("")){
            	multipart.addFilePart(form.getResumeUploaderId(), uploadFile);
            }
            
   
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
            StringBuffer serverReply = new StringBuffer(); //String to Store Server Reply
           
            for (String line : response) {
            	serverReply.append(line);
            }
            System.out.println(serverReply);
            Document returndoc = Jsoup.parse(serverReply.toString());

        } catch (IOException ex) {
            System.err.println(ex);
        }
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		checkAndApply("sajinvarughese@gmail.com", "VGN Infra India");
		
	}
}
