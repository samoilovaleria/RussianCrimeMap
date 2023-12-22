package server;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalServer {
    private static final String HTML_FILE_PATH = "src/main/html/main_page.html";
    private static final String CSS_FILE_PATH = "src/main/css/style.css";
    private static final String IMAGES_FOLDER_PATH = "src/main/resources/images";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
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
}