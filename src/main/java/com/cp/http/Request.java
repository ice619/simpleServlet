package com.cp.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Description: request
 *
 * @author chenpeng
 * @date 2019/1/28 11:18
 */
public class Request {

    private String method;
    private String url;

    public Request(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String[] methodAndUrl = bufferedReader.readLine().split(" ");
        this.method = methodAndUrl[0];
        this.url = methodAndUrl[1];

        System.out.println(method);
        System.out.println(url);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
