package servlet;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;


@WebServlet(name = "TimeServlet", urlPatterns = {"/time"})
public class TimeServlet extends BaseHttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        sleep(getDelayParam(req));
        try (ServletOutputStream out = resp.getOutputStream()) {
            out.write(("Server Time: " + LocalDateTime.now()).getBytes());
        }
    }
}
