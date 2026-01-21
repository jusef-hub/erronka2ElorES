package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import modelo.UserDTO;

public class Bidalketak {

    private static final String LOGIN_URL = "http://localhost:8080/api/login";

    public UserDTO login(String user, String pass) {
        try {
            URL url = new URL(LOGIN_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInput = String.format(
                "{\"username\":\"%s\",\"password\":\"%s\"}",
                user, pass
            );

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonInput.getBytes("UTF-8"));
                os.flush();
            }

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8")
                );
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }

                Gson gson = new Gson();
                return gson.fromJson(response.toString(), UserDTO.class);
            }

            if (responseCode == 401) {
                return null;
            }

            System.out.println("Error login: HTTP " + responseCode);
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
