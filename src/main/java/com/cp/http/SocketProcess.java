package com.cp.http;

import com.cp.servlet.Servelt;
import com.cp.tomcat.Mytomcat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Description: SocketProcess
 *
 * @author chenpeng
 * @date 2019/1/28 11:26
 */
public class SocketProcess extends Thread {
    protected Socket socket;

    public SocketProcess(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());

            //从映射中查找
            System.out.println(request.getUrl());
            String servelName = (String)Mytomcat.servletMapping.get(request.getUrl());
            System.out.println(servelName);

            if(servelName != null && servelName != ""){
                Servelt servelt = (Servelt) Mytomcat.servlet.get(servelName);
                if(servelt != null){
                    servelt.doGet(request,response);
                }else {
                    System.out.println("找不到对应servlet");
                }

            }else {
                System.out.println("找不到对应servletMapping");
            }

            String res = Response.responseHeader + response.getWirte();
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(res.getBytes("GBK"));
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
