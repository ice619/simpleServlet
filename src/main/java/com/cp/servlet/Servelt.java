package com.cp.servlet;

import com.cp.http.Request;
import com.cp.http.Response;

/**
 * Description: Servelt
 *
 * @author chenpeng
 * @date 2019/1/28 11:41
 */
public abstract class Servelt {

    public void service(Request request, Response response) {
        if ("get".equalsIgnoreCase(request.getMethod())) {
            this.doGet(request,response);
        } else {
            this.doPost(request,response);

        }
    }

    public abstract void doGet(Request request, Response response);
    public abstract void doPost(Request request, Response response);
}
