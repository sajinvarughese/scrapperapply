package org.scrappers.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.scrappers.bean.FormDetails;
import org.scrappers.bean.UserDetails;

public class ApplyJobHelper {

	/**
	 * Method which posting user data to Server and return the Response From Server
	 * @param requestURL
	 * @param user
	 * @param form
	 * @param uploadFile
	 * @return String
	 */
	public static String serverResponse(UserDetails user, FormDetails form, File uploadFile){
		String charset = "UTF-8";
        String requestURL = form.getApplyUrl();
		StringBuffer serverReply = new StringBuffer(); //String to Store Server Reply
		try{
		MultipartUtility multipart = new MultipartUtility(requestURL, charset);
			
        // Adding Header Parameters
        multipart.addHeaderField("Accept-Encoding", "gzip, deflate");
        multipart.addHeaderField("Content-Type", "multipart/form-data; boundary=---------------------------1866402817982626520474774539");
        multipart.addHeaderField("Connection", "keep-alive");
        multipart.addHeaderField("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:40.0) Gecko/20100101 Firefox/40.0");

        
        if(!(form.getFullName().equals(""))){
        	multipart.addFormField(form.getFullName(), user.getFullName());
        }
        if(!form.getEmailId().equals("")){
        	multipart.addFormField(form.getEmailId(), user.getEmailId());
        }
        if(!form.getMobileNumber().equals("")){
        	multipart.addFormField(form.getMobileNumber(), user.getMobileNumber());
        }
        if(!form.getDateOfBirth().equals("")){
        	String dateOfBirthField = form.getDateOfBirth();
        	String dobFormat = dateOfBirthField.split("\\~\\|\\~")[1];
        	String dateOfBirthParameter = dateOfBirthField.split("\\~\\|\\~")[0];
        	String dateOfBirthValue = user.getDateOfBirth();
        	if(!dobFormat.equals("dd/MM/yyyy")){
        		dateOfBirthValue = new SimpleDateFormat(dobFormat).format(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthValue));
        	}
        	multipart.addFormField(dateOfBirthParameter, dateOfBirthValue);
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
        if(!form.getAddress().equals("")){
        	multipart.addFormField(form.getAddress(), user.getAddress());
        }
        if(!form.getQualification().equals("")){
        	String qualifications = form.getQualification();
        	String[] split = null;
        	if(qualifications.contains("~:~")){     	
        		split	= qualifications.split("\\~\\:\\~");
            }else{
            	split = new String[]{qualifications};;
            }
        	for(String qualificationParameter : split){        		
            	multipart.addFormField(qualificationParameter, user.getQualification());
        	}
        }
        if(!form.getGender().equals("")){
        	multipart.addFormField(form.getGender(), user.getGender());
        }
        if(!form.getExperience().equals("")){
        	multipart.addFormField(form.getExperience(), "Fresher");
        }
        if(!form.getExperienceMonth().equals("")){
        	multipart.addFormField(form.getExperienceMonth(), user.getExperienceMonth());
        }
        if(!form.getExperienceYear().equals("")){
        	multipart.addFormField(form.getExperienceYear(), user.getExperienceYear());
        }
        if(!form.getSkills().equals("")){
        	multipart.addFormField(form.getSkills(), user.getSkills());
        }

        if(!form.getCurrentOrganization().equals("")){
        	multipart.addFormField(form.getCurrentOrganization(), user.getCurrentOrganization());
        }
        if(!form.getCurrentDesignation().equals("")){
        	multipart.addFormField(form.getCurrentDesignation(), user.getCurrentDesignation());
        }
        if(!form.getCurrentSalary().equals("")){
        	multipart.addFormField(form.getCurrentSalary(), user.getCurrentSalary());
        }
        if(!form.getExpectedSalary().equals("")){
        	multipart.addFormField(form.getExpectedSalary(), user.getExpectedSalary());
        }
        if(!form.getSubmitId().equals("")){
        	multipart.addFormField(form.getSubmitId().split("\\~\\|\\~")[0], form.getSubmitId().split("\\~\\|\\~")[1]);
        }
        if(!form.getApplyPost().equals("")){
        	multipart.addFormField(form.getApplyPost().split("\\~\\|\\~")[0], form.getApplyPost().split("\\~\\|\\~")[1]);
        }
        
        if(!form.getHiddenInputFields().equals("")){
        	String hiddenFields = form.getHiddenInputFields();
        	String[] split = null;
        	if(hiddenFields.contains("~:~")){     	
        		split	= hiddenFields.split("\\~\\:\\~");
            }else{
            	split = new String[]{hiddenFields};;
            }
        	Response conn = Jsoup.connect(form.getFormfillUrl()).timeout(30000).execute();
    		Document doc = conn.parse();	
        	for(String hiddenParameter : split){
        		String hiddenValue = "";
        		if(hiddenParameter.contains("~|~")){
        			hiddenValue = hiddenParameter.split("\\~\\|\\~")[1];
        			hiddenParameter = hiddenParameter.split("\\~\\|\\~")[0];
        		}else{
        			try{
        			hiddenValue = doc.select("[name = "+hiddenParameter+"]").attr("value");
        			if(hiddenValue.equals("")){
        				hiddenValue = doc.select("[name = "+hiddenParameter+"]").text();
        			}
        			}catch(Exception e){
        				hiddenValue = "";
        			}
        		}
            	multipart.addFormField(hiddenParameter, hiddenValue);
        	}
        	
        }
        
        if(!form.getResumeUploaderId().equals("")){
        	multipart.addFilePart(form.getResumeUploaderId(), uploadFile);
        }
        

        List<String> response = multipart.finish();
         
        System.out.println("SERVER REPLIED:");
       
        for (String line : response) {
        	serverReply.append(line);
        }
        
		}catch(Exception e){
			System.out.println(e);
		}
		return serverReply.toString();
	}
	
}
