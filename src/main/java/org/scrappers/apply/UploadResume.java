package org.scrappers.apply;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.scrappers.util.MultipartUtility;
public class UploadResume {
	 public static void main(String[] args) {
	        String charset = "UTF-8";
	        File uploadFile1 = new File("/home/worklyf/Downloads/DOWNLOADS DUMP SEP 9/skill MODIFIED.docx");
//	        File uploadFile2 = new File("e:/Test/PIC2.JPG");
	        String requestURL = "http://files.naukri.com/saveFile.php";
	 
	        try {
	            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
	             
	            multipart.addHeaderField("Accept-Encoding", "gzip, deflate");
	            multipart.addHeaderField("Content-Type", "multipart/form-data; boundary=---------------------------1866402817982626520474774539");
	            multipart.addHeaderField("Connection", "keep-alive");
	            multipart.addHeaderField("Host", "files.naukri.com");
	            multipart.addHeaderField("Referer", "http://apply.naukri.com/apply/processCSite?strJobsarr=090915005668&applytype=single&ApplyMode=1&Apply=&src=cs&logstr=careersite&csite_flag=1000&domain=careers.ivenus.in&color=blue");
	            multipart.addHeaderField("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:40.0) Gecko/20100101 Firefox/40.0");

	            
	            multipart.addFormField("appId", "107");
	            multipart.addFormField("uploadCallbackUrl", "http://apply.naukri.com/commonupload/commonUpload.php");
	            multipart.addFormField("uploadCallback", "uploadCallback_1443008161924_0_8966660118503073");
    
	            multipart.addFilePart("F51f8e7e54e205[U56028e94675e1]", uploadFile1);
//	            multipart.addFilePart("fileUpload", uploadFile2);
	 
	            List<String> response = multipart.finish();
	             
	            System.out.println("SERVER REPLIED:");
	             
	            for (String line : response) {
	                System.out.println(line);
	            }
	        } catch (IOException ex) {
	            System.err.println(ex);
	        }
	    }
}
