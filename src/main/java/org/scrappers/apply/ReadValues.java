package org.scrappers.apply;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ReadValues {
	
	// Read Form Values
	public void readformvalues(String pageNo){
		try{
		File file = new File("/home/worklyf/testfiles.txt");
		Scanner sc = new Scanner(file);
		StringBuffer str = new StringBuffer();
		while(sc.hasNextLine()){
			str.append(sc.nextLine());
		}
		URLConnection conn = new URL("http://files.naukri.com/saveFile.php?").openConnection();
		conn.setDoOutput(true);
		conn.addRequestProperty("Content-Type", "multipart/form-data");
		conn.addRequestProperty("Cache-Control", "text/html; charset=UTF-8");
		conn.addRequestProperty("Connection", "keep-alive");
		conn.addRequestProperty("Content-Encoding", "gzip, deflate");
		conn.addRequestProperty("Content-Length", "324");
		conn.addRequestProperty("Date", "Tue, 22 Sep 2015 18:26:45 GMT");
		conn.addRequestProperty("Expires", "-1");
		conn.addRequestProperty("Pragma", "	no-cache");

		byte[] outputInBytes = str.toString().getBytes("UTF-8");  //byte array with raw data
		OutputStream os = conn.getOutputStream();
		os.write( outputInBytes );  
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder response = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		Document doc = Jsoup.parse(response.toString());
//		JSONObject json = new JSONObject(doc.text());
		System.out.println(doc.html());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		new ReadValues().readformvalues("1");
	}
}
