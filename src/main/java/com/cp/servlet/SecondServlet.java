package com.cp.servlet;

import com.cp.http.Request;
import com.cp.http.Response;

/**
 * Description: SecondServlet
 *
 * @author chenpeng
 * @date 2019/1/28 11:45
 */
public class SecondServlet extends Servelt {
    @Override
    public void doGet(Request request, Response response) {
        System.out.println("进入了我的第二个servlet");
        response.setWirte("进入了第二个servlet");

    }

    @Override
    public void doPost(Request request, Response response) {

    }
}
