package com.javazuki.sample.javaee.response.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirected")
public class RedirectedServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("RedirectedServlet doGet() started");

    // リダイレクトなのでリクエスト属性は取得できないはず
    String redirectMessage = (String) request.getAttribute("redirectMessage");

    StringBuilder sb = new StringBuilder();
    sb.append("<html>");
    sb.append("<head><head>");
    sb.append("<body>");
    sb.append("<h1>Rediret Sample</h1>");
    sb.append("<p>Redireted.</p>");
    sb.append(String.format("<p>redirectMessage:[%s]<p>", redirectMessage));
    sb.append("</body>");
    sb.append("</html>");

    response.setContentType("text/html");
    response.getWriter()
            .print(sb);

    System.out.println("RedirectedServlet doGet() ended");
  }

}
