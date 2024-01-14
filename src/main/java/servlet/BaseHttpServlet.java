package servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class BaseHttpServlet extends HttpServlet {

    long getDelayParam(HttpServletRequest req) {
        String delay = req.getParameter("delay");
        if (delay != null && !delay.isEmpty()) {
            return Long.parseLong(delay);
        }
        return 0;
    }

    /**
     * this method simulates blocking IO operation
     */
    void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
