package toy.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class info {

	public static void main(String[] args) {
		String token = "AAAAPNLtfxk2jZAw1nLGDmPeYRk0ULUOf6ixbW05tre9Ff8UQ8DNnOzajec7kfGG7mviOa3eGWTJnBOVTbGEwzOYfJ8";// 네이버

		String header = "Bearer " + token; // Bearer 다음에 공백 추가
		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
