package com.javazuki.sample.javaee.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/aaa/bbb/*" })
public class DisplayURIInfoServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // http://localhost:8080/javazuki-sample-javaee/aaa/bbb/ccc.html?d=e&f=g でアクセスするとQueryStringまで表示される

    System.out.println("DisplayURIInfoServlet doGet() called");
    System.out.println();

    System.out.println("request.getRequestURL()  : " + request.getRequestURL());
    System.out.println("request.getRequestURI()  : " + request.getRequestURI());
    System.out.println("request.getContextPath() : " + request.getContextPath());
    System.out.println("request.getServletPath() : " + request.getServletPath());
    System.out.println("request.getPathInfo()    : " + request.getPathInfo());
    System.out.println("request.getQueryString() : " + request.getQueryString());

    System.out.println();
    System.out.println("DisplayURIInfoServlet doGet() called");
  }

}
