package org.scrappers.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test2 {

	public static void main(String[] args) {
		String url = "http://www.oberoirealty.com/site/career";
		File file = new File("/home/worklyf/Downloads/DOWNLOADS DUMP SEP 9/skill MODIFIED.docx");
try{
		MultipartEntity entity = new MultipartEntity();
		entity.addPart("authenticity_token", new StringBody("APw60ITJnf8CR9vd+YPPeXa3/+aRWXmSK1UlxeJ7S4e="));
		entity.addPart("career[first_name]", new StringBody("Sajin"));
		entity.addPart("career[last_name]", new StringBody("Varughese"));
		entity.addPart("career[job_id]", new StringBody("3"));
		entity.addPart("career[gender]", new StringBody("Male"));
		entity.addPart("career[mobile]", new StringBody("9447037214"));
		entity.addPart("career[phone]", new StringBody(""));
		entity.addPart("career[email]", new StringBody("sajinvarughese@gmail.com"));
		entity.addPart("career[area_of_interest]", new StringBody("Jsp, Java , Mysql"));
		entity.addPart("career[address]", new StringBody("paratholil House, Nellimala P O, Thiruvalla"));
		entity.addPart("utf8", new StringBody(""));
		
		entity.addPart("career[resume]", new InputStreamBody(new FileInputStream(file), file.getName()));

		HttpPost post = new HttpPost(url);
		post.setEntity(entity);

		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(post);
		String html = EntityUtils.toString(response.getEntity());

		Document document = Jsoup.parse(html, url);
		System.out.println(document);
	}catch(Exception e){
		System.out.println(e);
	}
	}
}
