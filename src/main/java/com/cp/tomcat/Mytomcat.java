package com.cp.tomcat;

import com.cp.http.SocketProcess;
import com.cp.utils.UtilsXml;
import org.dom4j.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

/**
 * Description: Mytomcat
 *
 * @author chenpeng
 * @date 2019/1/28 11:48
 */
public class Mytomcat {
    private static final int port = 8099;
    public static final HashMap<String, Object> servletMapping = new HashMap<String, Object>();
    public static final HashMap<String, Object> servlet = new HashMap<String, Object>();

    private void init(){
        InputStream io = null;
        String basePath;

        try {
            System.out.println("加载配置文件开始。。。");
            UtilsXml xml = new UtilsXml(UtilsXml.class.getResource("/") + "web.xml");
            System.out.println("配置文件路径："+ UtilsXml.class.getResource("/")+ "web.xml");

            //容器实际就是一个map，将所有对象存储到容器中，并且创造对象
            List<Element> list = xml.getNodes("servlet");
            for(Element element : list){
                servlet.put(element.element("servlet-name").getText(),Class.forName(element.element("servlet-class").getText()).newInstance());
            }

            //映射关系创建
            List<Element> list2 = xml.getNodes("servlet-mapping");
            for(Element element: list2){
                servletMapping.put(element.element("url-pattern").getText(),element.element("servlet-name").getText());
            }

            System.out.println("加载配置文件结束");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(io != null){
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("myTomcat 服务已启动，地址：localhost ,端口：" + port);
            this.init();
            do{
                Socket socket = serverSocket.accept();
                System.out.println(socket);
                //处理任务
                Thread socketProcessThread = new SocketProcess(socket);
                socketProcessThread.start();
            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Mytomcat mytomcat = new Mytomcat();
        mytomcat.start();
    }


}
