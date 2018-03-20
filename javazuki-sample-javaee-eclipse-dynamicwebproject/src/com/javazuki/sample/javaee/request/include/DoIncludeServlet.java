package com.javazuki.sample.javaee.request.include;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doInclude")
public class DoIncludeServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("DoIncludeServlet doGet() called");

    // include先でリクエスト属性が表示されるか確認するために設定
    request.setAttribute("includeMessage", "Hello Include From DoIncludeServlet");

    StringBuilder sb = new StringBuilder();
    sb.append("<html>");
    sb.append("<head><head>");
    sb.append("<body>");
    sb.append("<h1>Include Sample</h1>");
    sb.append("<p>Hello Include. In DoIncludeServlet</p>");

    response.getWriter()
            .print(sb);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/included");
    requestDispatcher.include(request, response);

    sb = new StringBuilder();
    sb.append("</html>");
    response.getWriter()
            .print(sb);

    System.out.println("DoIncludeServlet doGet() ended");
  }

}
