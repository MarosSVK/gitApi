package test;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.parser.*;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=25.05&longitude=15.1");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		if (con instanceof HttpURLConnection) {
		// Reason to use mozilla/5.0
		// https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/User-Agent
		// https://stackoverflow.com/questions/5125438/why-do-chrome-and-ie-put-mozilla-5-0-in-the-user-agent-they-send-to-the-server
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("'GET' request is sent to URL : " + url + "\nResponse Code: " + responseCode);
		if (responseCode == 200) {
		Logger.getLogger("'GET' Request is Succeeded Http Status Code: " + responseCode );
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
		}
		in.close();
		return;

	}

}
	}
}
