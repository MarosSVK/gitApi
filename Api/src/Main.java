
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.parser.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Maven dependency for JSON-simple:
            <dependency>
                <groupId>com.googlecode.json-simple</groupId>
                <artifactId>json-simple</artifactId>
                <version>1.1.1</version>
            </dependency>
         */

        try {
            //Public API:
            //https://www.metaweather.com/api/location/search/?query=<CITY>
            //https://www.metaweather.com/api/location/44418/

            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=25.05&longitude=15.1");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);


                //JSON simple library Setup with Maven is used to convert strings to JSON
                JsonParser parse = new JsonParser();
                JsonElement dataObject = (JsonElement) parse.parse(String.valueOf(informationString));
                



                //Get the first JSON object in the JSON array
                System.out.println(dataObject);

                JsonObject countryData = extracted(dataObject);
                jsonObject = JsonParser.parseString​(dataObject).getAsJsonObject();

                System.out.println(countryData.get("woeid"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private static JsonObject extracted(JsonElement dataObject) {
		JsonObject countryData = (JsonObject) dataObject;
		return countryData;
	}

}