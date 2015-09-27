package org.scrappers.util;

import java.io.File;
import java.util.List;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TestRunner {
	 public static void main(String[] args) {
	        String charset = "UTF-8";
	        File uploadFile1 = new File("/home/worklyf/Downloads/DOWNLOADS DUMP SEP 9/skill MODIFIED.docx");
//	        File uploadFile2 = new File("e:/Test/PIC2.JPG");
	        String requestURL = "http://www.citiustech.com/aboutus/applynow.aspx?j=RBBcjQ2ZZx8%3d";
	 
	        try {
//	        	
//	        	Document doc = Jsoup.connect("http://www.bostonanalytics.com/careers-apply-form.php")
//	        					.data("fullname","sajin varughese")
//	        					.data("email","sajinvarughese@gmail.com")
//	        					.data("phone","9447037214")
//	        					.data("position","Other Positions")
//	        					.data("otherpositions","software developer")
//	        					.data("experience","2")
//	        					.data("location","")
//	        					.data("domain","")
//	        					.data("scdomain","")
//	        					.data("resume","")
//	        					.data("comments","")
//	        					.data("apply.x","76")
//	        					.data("apply.y","1").timeout(30000).post();
//	        	
//	        	System.out.println(doc);
	            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
	             
	            multipart.addHeaderField("Accept-Encoding", "gzip, deflate");
	            multipart.addHeaderField("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	            multipart.addHeaderField("Content-Type", "multipart/form-data; boundary=---------------------------11637518762389726971393790151");
	            multipart.addHeaderField("Connection", "keep-alive");
	            multipart.addHeaderField("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:40.0) Gecko/20100101 Firefox/40.0");
	            
//	            multipart.addFormField("utf8", "");
	            multipart.addFormField("__EVENTTARGET", "");
	            multipart.addFormField("__EVENTARGUMENT", "");
	            multipart.addFormField("__VIEWSTATE", "/wEPDwULLTEyNzY1MzU5NzYPZBYCAgMPFgIeB2VuY3R5cGUFE211bHRpcGFydC9mb3JtLWRhdGEWBAIBDxYCHgRUZXh0BTRTb2x1dGlvbiBBcmNoaXRlY3QgLSBNaWNyb3NvZnQgRGF0YWJhc2UgVGVjaG5vbG9naWVzZAIDDw9kFgIeCW9ua2V5ZG93bgVBamF2YXNjcmlwdDogcmV0dXJuIFdlYkZvcm1fRmlyZURlZmF1bHRCdXR0b24gKGV2ZW50LCAnYnRuc3VibWl0JylkZLjV7jxLFHXstXpycMvwtXQtkE2be5TA86Ttd2ImYX9Q");
	            multipart.addFormField("__VIEWSTATEGENERATOR", "6A4910E6");
	            multipart.addFormField("_recipients", "kamlesh.bhosale@citiustech.com");
	            multipart.addFormField("_mailSubject", "");
	            multipart.addFormField("_heading", "");
	            multipart.addFormField("First_Name", "Sajin");
	            multipart.addFormField("Last_Name", "Varughese");
	            multipart.addFormField("Email", "sajinvarughese@gmail.com");
	            multipart.addFormField("Phone", "9447037214");
	            multipart.addFormField("Current_Company", "UMN");
	            multipart.addFormField("Current_Designation", "Software Developer");
	            multipart.addFormField("Work_Experience", "2 year 0 month");
	            multipart.addFormField("Position_Applying_for", "Solution Architect - Microsoft Database Technologies");
	            multipart.addFormField("Location_Preference", "Kochi");


//	            multipart.addFormField("apply.y", "1");

	            multipart.addFilePart("Upload_Resume", uploadFile1);
//	            multipart.addFilePart("fileUpload", uploadFile2);
	 
	            List<String> response = multipart.finish();
	             
	            System.out.println("SERVER REPLIED:");
	             
	            for (String line : response) {
	                System.out.println(line);
	            }
	        	
	         
	            
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }
	 }
}
