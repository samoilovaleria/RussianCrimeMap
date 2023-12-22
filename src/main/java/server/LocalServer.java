package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import handlers.ColorHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.*;

public class LocalServer {
    private static final String HTML_FILE_PATH = "src/main/html/main_page.html";
    private static final String CSS_FILE_PATH = "src/main/css/";
    private static final String JS_FILE_PATH = "src/main/js/";
    private static final String RESOURCES_DIR = "src/main/resources/";
    private static final String IMAGES_FOLDER_PATH = "src/main/resources/images/";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/static", new StaticFileHandler());
        server.createContext("/api", new ApiHandler());
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on http://localhost:8000");
    }

    static class MyHandler implements HttpHandler {
        public void handle(com.sun.net.httpserver.HttpExchange httpExchange) throws IOException {
            String requestPath = httpExchange.getRequestURI().getPath();
            Path filePath;
            if (requestPath.equals("/")) {
                filePath = Paths.get(HTML_FILE_PATH);
            } else if (requestPath.contains("/style.css")) {
                filePath = Paths.get(CSS_FILE_PATH);
            } else if (requestPath.contains("/images/")) {
                String imageName = requestPath.substring(requestPath.lastIndexOf("/") + 1);
                filePath = Paths.get(IMAGES_FOLDER_PATH, imageName);
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


    static class StaticFileHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String filePath = exchange.getRequestURI().getPath();
            File file = getFile(filePath);

            if (file == null) {
                String response = "Error 404 File not found.";
                exchange.sendResponseHeaders(404, response.length());
                OutputStream output = exchange.getResponseBody();
                output.write(response.getBytes());
                output.flush();
                output.close();
            } else {
                exchange.sendResponseHeaders(200, 0);
                OutputStream output = exchange.getResponseBody();
                FileInputStream fs = new FileInputStream(file);
                final byte[] buffer = new byte[0x10000];
                int count = 0;
                while ((count = fs.read(buffer)) >= 0) {
                    output.write(buffer, 0, count);
                }
                output.flush();
                output.close();
                fs.close();
            }
        }

        private File getFile(String filePath) {
            String fileName = filePath.replace("/static/", "");
            File file = new File(RESOURCES_DIR + fileName);
            if (file.exists() && !file.isDirectory()) {
                return file;
            }
            return null;
        }
    }

    static class ApiHandler implements HttpHandler {
        private static final String HEADER_CONTENT_TYPE = "Content-Type";
        private static final Charset CHARSET = StandardCharsets.UTF_8;
        private static final int STATUS_OK = 200;

        public void handle(com.sun.net.httpserver.HttpExchange httpExchange) throws IOException {
            String requestPath = httpExchange.getRequestURI().getPath();
            final Headers headers = httpExchange.getResponseHeaders();


            String responseBody;
            if (requestPath.contains("colors")) {
                ColorHandler colorHandler = new ColorHandler();
                Gson gson = new Gson();
                responseBody = gson.toJson(colorHandler.getGroups());
            } else {
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