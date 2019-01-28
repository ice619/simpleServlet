package com.cp.servlet;

import com.cp.http.Request;
import com.cp.http.Response;

/**
 * Description: MyfisrtServlet
 *
 * @author chenpeng
 * @date 2019/1/28 11:45
 */
public class MyfisrtServlet extends Servelt {
    @Override
    public void doGet(Request request, Response response) {
        System.out.println("进入了我的第一个servlet");
        response.setWirte("进入了第一个servlet");
    }

    @Override
    public void doPost(Request request, Response response) {

    }
}
