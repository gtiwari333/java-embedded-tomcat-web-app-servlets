package servlet;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mjson.Json;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "JsonServlet", urlPatterns = {"/json"})
public class JsonServlet extends BaseHttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        sleep(getDelayParam(req));

        try (ServletOutputStream out = resp.getOutputStream()) {

            String json = Json.object()
                    .set("time", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE))
                    .toString();

            resp.setHeader("Content-Type", "application/json");
            out.write(json.getBytes());
        }
    }
}
