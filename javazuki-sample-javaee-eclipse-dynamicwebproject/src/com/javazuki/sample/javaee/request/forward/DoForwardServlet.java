package com.javazuki.sample.javaee.request.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/doForward"})
public class DoForwardServlet extends HttpServlet {

  @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("DoForwardServlet doGet() called");

    // forward先でリクエスト属性が表示されるか確認するために設定
    request.setAttribute("forwaredMessage", "Hello Forward From DoForwardServlet");

    // forward()前後に出力処理を書いても内容は無視（クリア）される。
    // flush()などした後にforward()すると例外になる。

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/forwarded");
    requestDispatcher.forward(request, response);

    // 呼び出しの都合上、制御自体は戻ってくるのでこのメッセージも出力される
    // ただし、通常はforward()後に処理は書かない
    System.out.println("DoForwardServlet doGet() ended");
  }

}
