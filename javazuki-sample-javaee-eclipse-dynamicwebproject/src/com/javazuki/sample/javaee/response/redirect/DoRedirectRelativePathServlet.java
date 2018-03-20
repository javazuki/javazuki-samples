package com.javazuki.sample.javaee.response.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doRedirectWithRelativePath")
public class DoRedirectRelativePathServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("DoRedirectServlet doGet() started");

    // リダイレクトするので無意味だが、確認のため設定する。
    request.setAttribute("redirectMessage", "Hello Redirect");

    // sendRedirectでリダイレクトすると302となる
    // 他のステータスでリダイレクトしたい場合は、setStatus() + setHeader()でLocationを設定する
    // locationの指定は別サーバーならドメインも含めURLを記述する
    // 同一サーバー内であれば相対パスも可能
    response.sendRedirect("./redirected");
    System.out.println("response.getStatus()           : " + response.getStatus());
    System.out.println("response.getHeader(\"Location\") : " + response.getHeader("Location"));

    // 通常はすぐにreturnする
    System.out.println("DoRedirectServlet doGet() ended");
  }

}
