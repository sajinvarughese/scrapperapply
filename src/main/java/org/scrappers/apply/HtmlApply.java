package org.scrappers.apply;

import java.io.IOException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlApply {

	// Read Form Values
		public void readformvalues() throws IOException{
			Document descriptionDocument = Jsoup.connect("http://apply.naukri.com/ims/interceptAPI")
					.timeout(30000)
					.data("Sug_city", "Kottayam")
					.data("agree", "on")
					.data("appid", "128")
					.data("callback", "applyRev.processResponse" )
					.data("color", "red")
					.data("crossdomain", "0")
					.data("domain", "careers.ivenus.in")
					.data("email", "sajinvarughese.sv@gmail.com")
					.data("expMonths", "0")
					.data("expYears", "0")
					.data("farea", "-1" )
					.data("filekey", "U560289f3241db" )
					.data("flowtype", "save" )
					.data("icp", "careerSite" )
					.data("industry", "-1" )
					.data("jobid", "090915005668" )
					.data("logstr", "careersite" )
					.data("mobileNumber", "9447037214" )
					.data("name", "sajinvarughese" )
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
//			System.out.println(descriptionDocument.text());
			JSONObject json = new JSONObject(descriptionDocument.text());
			JSONObject obj = json.getJSONObject("data");
			String submiturl = obj.getString("submitURL");
			System.out.println(submiturl);
			
			Document doc = Jsoup.connect(submiturl).timeout(30000).get();
			System.out.println(doc.text());
			
		}
	
	public static void main(String[] args) throws IOException {
		new HtmlApply().readformvalues();

	}
}
