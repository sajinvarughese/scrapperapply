package org.scrappers.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.scrappers.bean.FormDetails;
import org.scrappers.bean.UserDetails;

public class ApplyJobHelper {
	public static Document doc = null;
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

        // Getting And passing fullName to Form
        if(!(form.getFullName().equals(""))){
    		System.out.println(form.getFullName()+" , "+user.getFirstName()+" "+user.getLastName());
        	multipart.addFormField(form.getFullName(), user.getFirstName()+" "+user.getLastName());
        }
        
        // Getting And passing firstName to Form
        if(!(form.getFirstName().equals(""))){
    		System.out.println(form.getFirstName()+" , "+user.getFirstName());
        	multipart.addFormField(form.getFirstName(), user.getFirstName());
        }
        
        // Getting And passing lastName to Form
        if(!(form.getLastName().equals(""))){
    		System.out.println(form.getLastName()+" , "+user.getLastName());
        	multipart.addFormField(form.getLastName(), user.getLastName());
        }
        
        // Getting And passing emailId to Form
        if(!form.getEmailId().equals("")){
    		System.out.println(form.getEmailId()+" , "+user.getEmailId());
        	multipart.addFormField(form.getEmailId(), user.getEmailId());
        }
        
        // Getting And passing mobileNumber to Form
        if(!form.getMobileNumber().equals("")){
    		System.out.println(form.getMobileNumber()+" , "+user.getMobileNumber());
        	multipart.addFormField(form.getMobileNumber(), user.getMobileNumber());
        }
        
        // Getting And passing dateOfBirth to Form, Splitting with date Format(dateParameter~|~format)
        if(!form.getDateOfBirth().equals("")){
        	String dateOfBirthField = form.getDateOfBirth();
        	String dobFormat = dateOfBirthField.split("\\~\\|\\~")[1];
        	String dateOfBirthParameter = dateOfBirthField.split("\\~\\|\\~")[0];
        	String dateOfBirthValue = user.getDateOfBirth();
        	if(!dobFormat.equals("dd/MM/yyyy")){
        		dateOfBirthValue = new SimpleDateFormat(dobFormat).format(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthValue));
        	}
    		System.out.println(dateOfBirthParameter+" , "+dateOfBirthValue);
        	multipart.addFormField(dateOfBirthParameter, dateOfBirthValue);
        }
        
        // Getting And passing country to Form
        if(!form.getCountry().equals("")){
    		System.out.println(form.getCountry()+" , "+user.getCountry());
        	multipart.addFormField(form.getCountry(), user.getCountry());
        }
        
        // Getting And passing state to Form
        if(!form.getState().equals("")){
    		System.out.println(form.getState()+" , "+user.getState());
        	multipart.addFormField(form.getState(), user.getState());
        }
        
        // Getting And passing city to Form
        if(!form.getCity().equals("")){
        	String city = form.getCity();
        	String input = user.getCity();
        	if(city.contains("~$~")){
        		city = city.replace("~$~", "");  
        		input = selectTagValues(form, user, city , "City");
        	}
    		System.out.println(city+" , "+input);
        	multipart.addFormField(city, input);
        }
        
        // Getting And passing address to Form
        if(!form.getAddress().equals("")){
    		System.out.println(form.getAddress()+" , "+user.getAddress());
        	multipart.addFormField(form.getAddress(), user.getAddress());
        }
        
        // Getting And passing qualification to Form, if two field having same qualification then splitting(qualification~:~highestqualification)
        if(!form.getQualification().equals("")){
        	String qualifications = form.getQualification();
        	String[] split = null;
        	if(qualifications.contains("~:~")){     	
        		split	= qualifications.split("\\~\\:\\~");
            }else{
            	split = new String[]{qualifications};;
            }
        	for(String qualificationParameter : split){        
        		System.out.println(qualificationParameter+" , "+user.getQualification());
            	multipart.addFormField(qualificationParameter, user.getQualification());
        	}
        }
        
        // Getting And passing gender to Form
        if(!form.getGender().equals("")){
    		System.out.println(form.getGender()+" , "+user.getGender());
        	multipart.addFormField(form.getGender(), user.getGender());
        }
        
        // Getting And passing experience to Form
        if(!form.getExperience().equals("")){
        	String experience = form.getExperience();
        	String[] split = null;
        	if(experience.contains("~:~")){     	
        		split	= experience.split("\\~\\:\\~");
            }else{
            	split = new String[]{experience};;
            }
        	for(String experienceParameter : split){        
    		System.out.println(experienceParameter+" , "+user.getExperienceYear() +" Year "+user.getExperienceMonth()+" Month");
        	multipart.addFormField(experienceParameter, user.getExperienceYear() +" Year "+user.getExperienceMonth()+" Month");
        	}
        }
        
        // Getting And passing experienceMonth to Form
        if(!form.getExperienceMonth().equals("")){
    		System.out.println(form.getExperienceMonth()+" , "+user.getExperienceMonth());
        	multipart.addFormField(form.getExperienceMonth(), user.getExperienceMonth());
        }
        
        // Getting And passing experienceYear to Form
        if(!form.getExperienceYear().equals("")){
        	String experienceYear = form.getExperienceYear();
        	String[] split = null;
        	if(experienceYear.contains("~:~")){     	
        		split	= experienceYear.split("\\~\\:\\~");
            }else{
            	split = new String[]{experienceYear};
            }
        	for(String experienceYearParameter : split){        
        		System.out.println(experienceYearParameter+" , "+user.getExperienceYear());
        	multipart.addFormField(experienceYearParameter, user.getExperienceYear());
        	}
        }
        
        // Getting And passing skills to Form
        if(!form.getSkills().equals("")){
        	String skill = form.getSkills();
        	String input = user.getSkills();
        	if(skill.contains("~$~")){
        		skill = skill.replace("~$~", "");  
        		input = selectTagValues(form, user, skill, "Skills");
        	}
    		System.out.println(skill+" , "+input);
        	multipart.addFormField(skill, input);
        }

        // Getting And passing organization to Form
        if(!form.getCurrentOrganization().equals("")){
    		System.out.println(form.getCurrentOrganization()+" , "+user.getCurrentOrganization());
        	multipart.addFormField(form.getCurrentOrganization(), user.getCurrentOrganization());
        }
        
        // Getting And passing designation to Form
        if(!form.getCurrentDesignation().equals("")){
        	String designation = form.getCurrentDesignation();
        	String[] split = null;
        	if(designation.contains("~:~")){     	
        		split	= designation.split("\\~\\:\\~");
            }else{
            	split = new String[]{designation};;
            }
        	for(String designationParameter : split){        
    		System.out.println(designationParameter+" , "+user.getCurrentDesignation());
        	multipart.addFormField(designationParameter, user.getCurrentDesignation());
        	}
        }
        
        // Getting And passing currentSalary to Form
        if(!form.getCurrentSalary().equals("")){
    		System.out.println(form.getCurrentSalary()+" , "+user.getCurrentSalary());
        	multipart.addFormField(form.getCurrentSalary(), user.getCurrentSalary());
        }
        
        // Getting And passing expectedSalary to Form
        if(!form.getExpectedSalary().equals("")){
    		System.out.println(form.getExpectedSalary()+" , "+user.getExpectedSalary());
        	multipart.addFormField(form.getExpectedSalary(), user.getExpectedSalary());
        }
        
        // Getting And passing noticePeriod to Form
        if(!form.getNoticePeriod().equals("")){
        	String noticePeriod = form.getNoticePeriod();
        	String input = "";
        	if(noticePeriod.contains("~$~")){
        		noticePeriod = noticePeriod.replace("~$~", "");  
        		input = selectTagValues(form, user, noticePeriod , "Notice Period");
        	}
    		System.out.println(noticePeriod+" , "+input);
        	multipart.addFormField(noticePeriod, input);
        }
        
        // Getting And passing submitId to Form
        if(!form.getSubmitId().equals("")){
    		System.out.println(form.getSubmitId().split("\\~\\|\\~")[0]+" , "+form.getSubmitId().split("\\~\\|\\~")[1]);
        	multipart.addFormField(form.getSubmitId().split("\\~\\|\\~")[0], form.getSubmitId().split("\\~\\|\\~")[1]);
        }
        
        // Getting And passing applyPost to Form
        if(!form.getApplyPost().equals("")){
    		System.out.println(form.getApplyPost().split("\\~\\|\\~")[0]+" , "+form.getApplyPost().split("\\~\\|\\~")[1]);

        	multipart.addFormField(form.getApplyPost().split("\\~\\|\\~")[0], form.getApplyPost().split("\\~\\|\\~")[1]);
        }
        
        // Getting and passing all other hiddenfieldInputs. '~:~' --> Seperate b/w two parameter, '~|~' --> Seperate parameter with value
        // Example  x~|~22~:~y~|~10~:~jobname~:~jobid
        if(!form.getHiddenInputFields().equals("")){
        	String hiddenFields = form.getHiddenInputFields();
        	String[] split = null;
        	if(hiddenFields.contains("~:~")){     	
        		split	= hiddenFields.split("\\~\\:\\~");
            }else{
            	split = new String[]{hiddenFields};;
            }
        	if(doc == null){
        	Response conn = Jsoup.connect(form.getFormfillUrl()).timeout(30000).execute();
    		doc = conn.parse();	
        	}
        	for(String hiddenParameter : split){
        		String hiddenValue = "";
        		if(hiddenParameter.contains("~|~")){
        			hiddenValue = hiddenParameter.split("\\~\\|\\~")[1];
        			hiddenParameter = hiddenParameter.split("\\~\\|\\~")[0];
        		}else{
        			try{
        			if(!doc.select("[name = "+hiddenParameter+"]").first().tagName().equals("select")){
        			hiddenValue = doc.select("[name = "+hiddenParameter+"]").attr("value");
        			if(hiddenValue.equals("")){
        				hiddenValue = doc.select("[name = "+hiddenParameter+"]").text();
        			}
        			}else{
        				hiddenValue = "";
        			}
        			}catch(Exception e){
        				hiddenValue = "";
        			}
        		}
        		System.out.println(hiddenParameter+" , "+hiddenValue);
            	multipart.addFormField(hiddenParameter, hiddenValue);
            	
        	}
        	
        }
        
        // Getting And passing resumeUploaderId to Form
        if(!form.getResumeUploaderId().equals("")){
        	System.out.println(form.getResumeUploaderId() +" , "+ uploadFile);
        	multipart.addFilePart(form.getResumeUploaderId(), uploadFile);
        }
        

        List<String> response = multipart.finish(); // Returning response as list
         
        System.out.println("SERVER REPLIED:");
       
        for (String line : response) {
        	serverReply.append(line);
        }
        
		}catch(Exception e){
			System.out.println(e);
		}
		return serverReply.toString();
	}
	
	
	
	public static String selectTagValues(FormDetails form, UserDetails user, String parameter, String fieldName){
    	String allOption[] = null;
		StringBuffer splitOption = new StringBuffer();
		String input = "";
		try{
		if(doc == null){
    		Response conn = Jsoup.connect(form.getFormfillUrl()).timeout(30000).execute();
    		doc = conn.parse();	
    		}
    		Elements selectOption = doc.select("[name = "+parameter+"]").select("option");
    		for(Element option : selectOption){
    			if(!option.attr("value").equals("")){
    			splitOption.append(option.attr("value")+"~||~");
    			}
    		}
    		allOption = splitOption.toString().split("\\~\\|\\|\\~");
    		input = (String) JOptionPane.showInputDialog(null, fieldName,
    		        "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
    		                                                                        // default
    		                                                                        // icon
    		        allOption, // Array of choices
    		        allOption[0]); // Initial choice
		}catch(Exception e){
			System.out.println(e);
		}
		return input;
	}
	
	
}
