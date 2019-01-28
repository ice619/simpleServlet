package com.cp.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Description: Response
 *
 * @author chenpeng
 * @date 2019/1/28 11:25
 */
public class Response {
    public OutputStream outputStream;

    public String wirte;

    public static final String responseHeader="HTTP/1.1 200 \r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n";

    public Response(OutputStream outputStream) throws IOException {
        this.outputStream= outputStream;
    }

    public String getWirte() {
        return wirte;
    }

    public void setWirte(String wirte) {
        this.wirte = wirte;
    }
}
