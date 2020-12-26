package com.javazuki.sample.javaee.request.include;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/included")
public class IncludedServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("IncludedServlet doGet() called");

    //リクエスト属性に設定した情報が取得（表示）できるはず
    String includeMessage = (String) request.getAttribute("includeMessage");

    StringBuilder sb = new StringBuilder();
    sb.append("<p>Hello Include. In IncludedServlet</p>");
    sb.append(String.format("<p>includeMessage:[%s]<p>", includeMessage));
    response.getWriter()
            .print(sb);

    System.out.println("IncludedServlet doGet() ended");
  }

}
