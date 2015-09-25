package org.scrappers.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class NaukriSupport {

	/**
	 * Program to Return the name of ResumeUploadButton
	 * 
	 * @param domain
	 * @param jobId
	 * @return String
	 */
	public static String resumeUploaderName(String domain, String jobId){
		String uploadname = "";
		try{
		Document applyFormDoc = Jsoup.connect("http://apply.naukri.com/ims/interceptAPI")  //Loading Apply Page.
				.data("ApplyMode", "1")
				.data("appid", "128")
				.data("applytype", "single")
				.data("callback", "applyRev.processResponse")
				.data("color", "blue")
				.data("crossdomain", "0")
				.data("csite_flag", "1000")
				.data("domain", domain)
				.data("flowtype", "show")
				.data("jobid", jobId)
				.data("logstr", "careersite")
				.data("response", "embedded")
				.data("src", "cs")
				.data("strJobsarr", jobId)
				.data("showRegStatus", "")
				.data("Apply", "")
				.ignoreContentType(true).timeout(30000).post();
		
		String fullHtml = applyFormDoc.toString();
		String jsonData = fullHtml.substring(fullHtml.indexOf("{"),fullHtml.lastIndexOf("}")+1)
					.replace("data:", "\"data\":").replace("\n", ""); //Making a valid JsonString

		JSONObject json = new JSONObject(jsonData); 	// Convert to Json Data
		JSONObject obj = json.getJSONObject("data");
		String htmlText = obj.getString("html"); 		//Returning Only Html Content
		
		Document htmlDoc = Jsoup.parse(htmlText);
		uploadname = htmlDoc.select("input#atchRes").attr("name"); // getting name attribute of resume upload button.
		
		}catch(Exception e){
			System.out.println(e);
		}
		return uploadname;
	}
	
	
	
	/**
	 * Method To Upload the Local Resume to Naukri database
	 * 
	 * @param uploaderName
	 * @param filePath
	 * @return boolean
	 */
	public static boolean resumeUpload(String uploaderName, String filePath){
		boolean uploadFlag = false;
		String charset = "UTF-8";
        File uploadFile = new File(filePath);
        String requestURL = "http://files.naukri.com/saveFile.php";
 
        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
             
            // Adding Header Parameters
            multipart.addHeaderField("Accept-Encoding", "gzip, deflate");
            multipart.addHeaderField("Content-Type", "multipart/form-data; boundary=---------------------------1866402817982626520474774539");
            multipart.addHeaderField("Connection", "keep-alive");
            multipart.addHeaderField("Host", "files.naukri.com");
            multipart.addHeaderField("Referer", "http://apply.naukri.com/apply/processCSite?strJobsarr=090915005668&applytype=single&ApplyMode=1&Apply=&src=cs&logstr=careersite&csite_flag=1000&domain=careers.ivenus.in&color=blue");
            multipart.addHeaderField("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:40.0) Gecko/20100101 Firefox/40.0");

            // Adding Form Fields..
            multipart.addFormField("appId", "107");
            multipart.addFormField("uploadCallbackUrl", "http://apply.naukri.com/commonupload/commonUpload.php");
            multipart.addFormField("uploadCallback", "uploadCallback_1443008161924_0_8966660118503073");

            // Uploading File to the uploader field
            multipart.addFilePart(uploaderName, uploadFile); // addFilePart(fieldName, uploadFile);
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
            StringBuffer serverReply = new StringBuffer(); //String to Store Server Reply
           
            for (String line : response) {
            	serverReply.append(line);
            }
            System.out.println(serverReply);
            
            // Checking if File UPloaded is a Valid File or Not
            if(!(serverReply.substring(serverReply.indexOf("{"),serverReply.lastIndexOf("}")+1).contains("ERROR"))){
            	uploadFlag = true;
            }
            
            // if file Saved (Format OK) successfully, Uploading it to Naukri Server
            if(uploadFlag == true){
            	
            	String uploadUrl = Jsoup.parse(serverReply.toString()).select("iframe").attr("src");
//            	System.out.println(uploadUrl);
            	Document serverGetOutput = Jsoup.connect(uploadUrl).timeout(30000).get();
            	System.out.println("Server GetOutput :: "+ serverGetOutput);
            	
            }           
            
        } catch (IOException ex) {
            System.err.println(ex);
        }
		return uploadFlag;
	}
	
	/**
	 * Method to apply to job with user details
	 * @param domainName
	 * @param jobId
	 * @param fileUploaderName
	 * @param fullName
	 * @param emailId
	 * @param mobileNo
	 * @param currentLocation
	 * @param experienceYear
	 * @param experienceMonth
	 * @return String
	 */
	public static String applyJob(String domainName, String jobId, String fileId, String fullName, String emailId, String mobileNo, String currentLocation, String experienceYear, String experienceMonth ){
		String status = "";
		try{
		Document applyResult = Jsoup.connect("http://apply.naukri.com/ims/interceptAPI")
						.timeout(30000)
						.data("Sug_city", currentLocation)
						.data("agree", "on")
						.data("appid", "128")
						.data("callback", "applyRev.processResponse" )
						.data("color", "red")
						.data("crossdomain", "0")
						.data("domain", domainName)
						.data("email", emailId)
						.data("expMonths", experienceMonth)
						.data("expYears", experienceYear)
						.data("farea", "-1" )
						.data("filekey", fileId )
						.data("flowtype", "save" )
						.data("icp", "careerSite" )
						.data("industry", "-1" )
						.data("jobid", jobId )
						.data("logstr", "careersite" )
						.data("mobileNumber", mobileNo )
						.data("name", fullName )
						.data("refererUrl", "http://apply.naukri.com/apply/processCSite" )
						.data("response", "embedded" )
						.data("src", "cs" )
						.data("appStatus", "" )
						.data("applySrc", "" )
						.data("boomCode", "" )
						.data("btncolor", "" )
						.data("cb", "" )
						.data("closebtn", "" )
						.data("colorCode", "" )
						.data("empemail", "" )
						.data("fontcolor", "" )
						.data("https_apply", "" )
						.data("jquery", "" )
						.data("keySkills", "" )
						.data("questData", "" )
						.data("questionnaire", "" )
						.data("redUrl", "" )
						.data("regStatus", "" )
						.data("resId", "" )
						.data("sessionId", "" )
						.data("showEm", "" )
						.data("showRegForm", "" )
						.data("showRegStatus", "" )
						.data("showTnCStatus", "" )
						.data("unregAcpParams", "" )
						.data("unregId", "" )
						.data("unregType", "" )
						.data("uploadcv", "" )
						.data("xid", "" )
						.ignoreContentType(true).post();
		JSONObject json = new JSONObject(applyResult.text());
		JSONObject obj = json.getJSONObject("data");
		String submitUrl = obj.getString("submitURL");
		System.out.println(submitUrl);
				
		Document doc = Jsoup.connect(submitUrl).timeout(30000).get();
//		System.out.println(doc.text());
		status = doc.text();
		}catch(Exception e){
			
		}
		return status;
	}
	
	
}
