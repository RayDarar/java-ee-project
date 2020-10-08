package practice.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class ApiService {
  public static void returnJson(HttpServletResponse res, JSONObject o) throws IOException {
    PrintWriter out = res.getWriter();
    res.setContentType("application/json");
    res.setCharacterEncoding("UTF-8");
    out.print(o.toString());
    out.flush();
  }
}
