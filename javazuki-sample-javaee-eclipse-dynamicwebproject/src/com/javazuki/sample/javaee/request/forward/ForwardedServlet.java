package com.javazuki.sample.javaee.request.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forwarded")
public class ForwardedServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("ForwardedServlet doGet() called");

    //リクエスト属性に設定した情報が取得（表示）できるはず
    String forwaredMessage = (String) request.getAttribute("forwaredMessage");

    StringBuilder sb = new StringBuilder();
    sb.append("<html>");
    sb.append("<head><head>");
    sb.append("<body>");
    sb.append("<h1>Forward Sample</h1>");
    sb.append("<p>Forwared .</p>");
    sb.append(String.format("<p>forwaredMessage:[%s]<p>", forwaredMessage));
    sb.append("</body>");
    sb.append("</html>");

    response.setContentType("text/html");
    response.getWriter()
            .print(sb);

    System.out.println("ForwardedServlet doGet() ended");
  }

}
