package org.scrappers.naukri;

import org.scrapper.util.NaukriSupport;

public class NaukriApply {
	public static final String LOCAL_RESUME_PATH = "/home/worklyf/Downloads/DOWNLOADS DUMP SEP 9/poc.docx";
	
	public static void applyJob(String jobUrl){
		String domainName = jobUrl.substring(jobUrl.indexOf("//")+2, jobUrl.indexOf("/",jobUrl.indexOf("//")+2)); //Taking domain name from description page url

		String jobId = jobUrl.substring(jobUrl.lastIndexOf("-")+1);  									// Taking jobid from description page url
		
		String fileUploaderName = NaukriSupport.resumeUploaderName(domainName,jobId); 					// getting the Name of the field to upload resume

		boolean uploadFlag = NaukriSupport.resumeUpload(fileUploaderName, LOCAL_RESUME_PATH);   		// uploading resume to naukri server. returns true if success
		
		String fileId = fileUploaderName.substring(fileUploaderName.indexOf("["), fileUploaderName.lastIndexOf("]")+1); // taking only fileId to post user details for job application
		
		// check if resume successfully uploaded
		if(uploadFlag == true){
			
			// Write Logic to take user data from DB
			String fullName = "Sajin Varughese";
			String emailId = "sajinvarughese@gmail.com";
			String mobileNo = "9447037214";
			String currentLocation = "Kochi";
			String experienceYear = "2";
			String experienceMonth = "0";
			// End---
			
			
			String status = NaukriSupport.applyJob(domainName, jobId, fileId, fullName, emailId, mobileNo, currentLocation, experienceYear, experienceMonth);
			
			System.out.println(status);
			
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		String naukriurl = "http://careers.ivenus.in/job-listings-Sales-Expert-Apple-Authorised-Reseller-Venus-Data-Products-Bhavnagar-Gandhidham-0-to-4-years-170815002314";

		applyJob(naukriurl);
		
	}
	
	
}
