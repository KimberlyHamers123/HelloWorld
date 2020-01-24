package kim.fullred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GreetingHelper {
    
    public String doGetRequest() {
        try {
            return doGetRequest(new URL("http://localhost:8083/greeting"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String doGetRequest(String name) {
        try {
            return doGetRequest(new URL(String.format("http://localhost:8083/greeting?name=%s", name)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String doGetRequest(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}

