package org.scrappers.othercompanies;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.scrappers.util.MultipartUtility;

public class Eventurers {
	
	public static void applyJob() throws IOException{
	
		String filePath = "/home/worklyf/Downloads/DOWNLOADS DUMP SEP 9/skill MODIFIED.docx";
		String charset = "UTF-8";
        File uploadFile = new File(filePath);
        String requestURL = "http://www.vgn.in/job/project-incharge-construction";
 
        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
             
            // Adding Header Parameters
            multipart.addHeaderField("Accept-Encoding", "gzip, deflate");
            multipart.addHeaderField("Content-Type", "multipart/form-data; boundary=---------------------------1866402817982626520474774539");
            multipart.addHeaderField("Connection", "keep-alive");
            multipart.addHeaderField("Host", "www.eventurers.com");
            multipart.addHeaderField("Referer", "http://www.eventurers.com/contact/careers/career-form/?pos=PPM");
            multipart.addHeaderField("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:40.0) Gecko/20100101 Firefox/40.0");

            // Adding Form Fields..
            multipart.addFormField("user_fname", "Vijin Varughese");
            multipart.addFormField("user_email", "sajinvarughese@gmail.com");
            multipart.addFormField("user_dob", "16/06/1989");
            multipart.addFormField("user_phn", "9447037214");
            multipart.addFormField("user_cty", "Kochi");
            multipart.addFormField("user_country", "India");
            multipart.addFormField("user_rgn", "Kerala");
//            multipart.addFormField("academic12th", "77.33");
//            multipart.addFormField("degree", "62.44");
            multipart.addFormField("user_exp", "2");
//            multipart.addFormField("cemployer", "UMN");
//            multipart.addFormField("cposttitle", "Software Developer");
            multipart.addFormField("user_slry", "30000");
//            multipart.addFormField("psalary", "50000");
//            multipart.addFormField("sec-code", "");
            multipart.addFormField("btnsubform", "Submit Application");

            
            // Uploading File to the uploader field
            multipart.addFilePart("myfile", uploadFile); // addFilePart(fieldName, uploadFile);
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
            StringBuffer serverReply = new StringBuffer(); //String to Store Server Reply
           
            for (String line : response) {
            	serverReply.append(line);
            }
            System.out.println(serverReply);
            Document returndoc = Jsoup.parse(serverReply.toString());
            
//            // Checking if File UPloaded is a Valid File or Not
//            if(!(serverReply.substring(serverReply.indexOf("{"),serverReply.lastIndexOf("}")+1).contains("ERROR"))){
//            	uploadFlag = true;
//            }
//            
//            // if file Saved (Format OK) successfully, Uploading it to Naukri Server
//            if(uploadFlag == true){
//            	
//            	String uploadUrl = Jsoup.parse(serverReply.toString()).select("iframe").attr("src");
////            	System.out.println(uploadUrl);
//            	Document serverGetOutput = Jsoup.connect(uploadUrl).timeout(30000).get();
//            	System.out.println("Server GetOutput :: "+ serverGetOutput);
//            	
//            }           
//            
        } catch (IOException ex) {
            System.err.println(ex);
        }
		
	}
	
	public static void main(String[] args) throws IOException {
		applyJob();
	}
}
