package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import handlers.ColorHandler;
import handlers.FeedbackHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import com.google.gson.*;

public class LocalServer {
	private static final String HTML_FILE_PATH = "src/main/html/main_page.html";
	private static final String CSS_FILE_PATH = "src/main/resources/css/";
	private static final String JS_FILE_PATH = "src/main/resources/js/";
	private static final String IMAGES_FOLDER_PATH = "src/main/resources/img/";
	private static final String FONTS_FOLDER_PATH = "src/main/resources/fonts/";
	private static final String GSAP_FOLDER_PATH = "src/main/resources/libs/gsap/";
	private static ColorHandler colorHandler;

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

		server.createContext("/api", new ApiHandler());
		server.createContext("/", new MyHandler());
		server.setExecutor(null);
		server.start();
		System.out.println("Server started on http://localhost:8000");

		try {
			colorHandler = new ColorHandler();
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	static class MyHandler implements HttpHandler {
		public void handle(HttpExchange httpExchange) throws IOException {
			String requestPath = httpExchange.getRequestURI().getPath();
			Path filePath = null;
			if (requestPath.equals("/")) {
				filePath = Paths.get(HTML_FILE_PATH);
			} else if (requestPath.contains("css")) {
				String cssName = requestPath.substring(requestPath.lastIndexOf("/") + 1);
				filePath = Paths.get(CSS_FILE_PATH, cssName);
			} else if (requestPath.contains("/img/")) {
				String imageName = requestPath.substring(requestPath.lastIndexOf("/") + 1);
				filePath = Paths.get(IMAGES_FOLDER_PATH, imageName);
			} else if (requestPath.contains("/gsap/")) {
				String libName = requestPath.substring(requestPath.lastIndexOf("/") + 1);
				filePath = Paths.get(GSAP_FOLDER_PATH, libName);
			} else if (requestPath.contains("/fonts/")) {
				String fontName = requestPath.substring(requestPath.lastIndexOf("/") + 1);
				filePath = Paths.get(FONTS_FOLDER_PATH, fontName);
			} else if (requestPath.contains("js")) {
				String jsName = requestPath.substring(requestPath.lastIndexOf("/") + 1);
				filePath = Paths.get(JS_FILE_PATH, jsName);
			} else if (requestPath.equals("/feedback") && httpExchange.getRequestMethod().equalsIgnoreCase("POST")) {
				InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();

				String formData = sb.toString();
				String decodedFormData = URLDecoder.decode(formData, "UTF-8");
				String[] formDataArray = decodedFormData.split("&");
				String name = "";
				String city = "";
				String message = "";

				for (String item : formDataArray) {
					String[] keyValue = item.split("=");
					String key = keyValue[0];
					String value = keyValue[1];

					if (key.equals("name")) {
						name = value;
					} else if (key.equals("city")) {
						city = value;
					} else if (key.equals("message")) {
						message = value;
					}
				}

				System.out.println(name + " " + city + " " + message);

				FeedbackHandler feedbackHandler = new FeedbackHandler();
				feedbackHandler.saveFeedback(name, city, message);

				String redirectScript = "<script>location.replace(document.referrer);</script>";
				byte[] redirectScriptBytes = redirectScript.getBytes(StandardCharsets.UTF_8);

				httpExchange.sendResponseHeaders(200, redirectScriptBytes.length);
				OutputStream os = httpExchange.getResponseBody();
				os.write(redirectScriptBytes);
				os.close();
			} else {
				return;
			}
			byte[] fileData = Files.readAllBytes(filePath);
			httpExchange.sendResponseHeaders(200, fileData.length);
			OutputStream os = httpExchange.getResponseBody();
			os.write(fileData);
			os.close();
		}
	}

	static class ApiHandler implements HttpHandler {
		private static final String HEADER_CONTENT_TYPE = "Content-Type";
		private static final Charset CHARSET = StandardCharsets.UTF_8;
		private static final int STATUS_OK = 200;

		public void handle(HttpExchange httpExchange) throws IOException {
			String requestPath = httpExchange.getRequestURI().getPath();
			final Headers headers = httpExchange.getResponseHeaders();

			String responseBody = null;

			if (requestPath.contains("all_colors")) {
				Gson gson = new Gson();
				if (requestPath.contains("2022")) responseBody = gson.toJson(colorHandler.getGroups_2022());
				else if (requestPath.contains("2021")) responseBody = gson.toJson(colorHandler.getGroups_2021());
				else if (requestPath.contains("2020")) responseBody = gson.toJson(colorHandler.getGroups_2020());
				else if (requestPath.contains("2019")) responseBody = gson.toJson(colorHandler.getGroups_2019());
				else if (requestPath.contains("2018")) responseBody = gson.toJson(colorHandler.getGroups_2018());
				else if (requestPath.contains("2017")) responseBody = gson.toJson(colorHandler.getGroups_2017());
				else if (requestPath.contains("2016")) responseBody = gson.toJson(colorHandler.getGroups_2016());
				else if (requestPath.contains("2015")) responseBody = gson.toJson(colorHandler.getGroups_2015());
				else if (requestPath.contains("2014")) responseBody = gson.toJson(colorHandler.getGroups_2014());
				else if (requestPath.contains("2013")) responseBody = gson.toJson(colorHandler.getGroups_2013());
				else if (requestPath.contains("2012")) responseBody = gson.toJson(colorHandler.getGroups_2012());
				else if (requestPath.contains("2011")) responseBody = gson.toJson(colorHandler.getGroups_2011());
			}

			else if (requestPath.contains("people_colors")) {
				Gson gson = new Gson();
				if (requestPath.contains("2022")) responseBody = gson.toJson(colorHandler.getPeople_groups_2022());
				else if (requestPath.contains("2021")) responseBody = gson.toJson(colorHandler.getPeople_groups_2021());
				else if (requestPath.contains("2020")) responseBody = gson.toJson(colorHandler.getPeople_groups_2020());
				else if (requestPath.contains("2019")) responseBody = gson.toJson(colorHandler.getPeople_groups_2019());
				else if (requestPath.contains("2018")) responseBody = gson.toJson(colorHandler.getPeople_groups_2018());
				else if (requestPath.contains("2017")) responseBody = gson.toJson(colorHandler.getPeople_groups_2017());
				else if (requestPath.contains("2016")) responseBody = gson.toJson(colorHandler.getPeople_groups_2016());
				else if (requestPath.contains("2015")) responseBody = gson.toJson(colorHandler.getPeople_groups_2015());
				else if (requestPath.contains("2014")) responseBody = gson.toJson(colorHandler.getPeople_groups_2014());
				else if (requestPath.contains("2013")) responseBody = gson.toJson(colorHandler.getPeople_groups_2013());
				else if (requestPath.contains("2012")) responseBody = gson.toJson(colorHandler.getPeople_groups_2012());
				else if (requestPath.contains("2011")) responseBody = gson.toJson(colorHandler.getPeople_groups_2011());
			}

			else if (requestPath.contains("all_values")) {
				Gson gson = new Gson();
				if (requestPath.contains("2022")) responseBody = gson.toJson(colorHandler.getColors_2022());
				else if (requestPath.contains("2021")) responseBody = gson.toJson(colorHandler.getColors_2021());
				else if (requestPath.contains("2020")) responseBody = gson.toJson(colorHandler.getColors_2020());
				else if (requestPath.contains("2019")) responseBody = gson.toJson(colorHandler.getColors_2019());
				else if (requestPath.contains("2018")) responseBody = gson.toJson(colorHandler.getColors_2018());
				else if (requestPath.contains("2017")) responseBody = gson.toJson(colorHandler.getColors_2017());
				else if (requestPath.contains("2016")) responseBody = gson.toJson(colorHandler.getColors_2016());
				else if (requestPath.contains("2015")) responseBody = gson.toJson(colorHandler.getColors_2015());
				else if (requestPath.contains("2014")) responseBody = gson.toJson(colorHandler.getColors_2014());
				else if (requestPath.contains("2013")) responseBody = gson.toJson(colorHandler.getColors_2013());
				else if (requestPath.contains("2012")) responseBody = gson.toJson(colorHandler.getColors_2012());
				else if (requestPath.contains("2011")) responseBody = gson.toJson(colorHandler.getColors_2011());
			}

			else if (requestPath.contains("people_values")) {
				Gson gson = new Gson();
				if (requestPath.contains("2022")) responseBody = gson.toJson(colorHandler.getPeople_2022());
				else if (requestPath.contains("2021")) responseBody = gson.toJson(colorHandler.getPeople_2021());
				else if (requestPath.contains("2020")) responseBody = gson.toJson(colorHandler.getPeople_2020());
				else if (requestPath.contains("2019")) responseBody = gson.toJson(colorHandler.getPeople_2019());
				else if (requestPath.contains("2018")) responseBody = gson.toJson(colorHandler.getPeople_2018());
				else if (requestPath.contains("2017")) responseBody = gson.toJson(colorHandler.getPeople_2017());
				else if (requestPath.contains("2016")) responseBody = gson.toJson(colorHandler.getPeople_2016());
				else if (requestPath.contains("2015")) responseBody = gson.toJson(colorHandler.getPeople_2015());
				else if (requestPath.contains("2014")) responseBody = gson.toJson(colorHandler.getPeople_2014());
				else if (requestPath.contains("2013")) responseBody = gson.toJson(colorHandler.getPeople_2013());
				else if (requestPath.contains("2012")) responseBody = gson.toJson(colorHandler.getPeople_2012());
				else if (requestPath.contains("2011")) responseBody = gson.toJson(colorHandler.getPeople_2011());
			}

			else {
				return;
			}

			final byte[] rawResponseBody = responseBody.getBytes(CHARSET);
			headers.set(HEADER_CONTENT_TYPE, "application/json; charset=UTF-8");
			httpExchange.sendResponseHeaders(STATUS_OK, rawResponseBody.length);
			OutputStream os = httpExchange.getResponseBody();
			os.write(rawResponseBody);
			os.close();
		}
	}
}