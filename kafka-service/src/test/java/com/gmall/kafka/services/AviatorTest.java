package com.gmall.kafka.services;


import com.gmall.kafka.bootstrap.KafkaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author reno
 * @data 2023/3/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
public class AviatorTest {

    private static ExecutorService executors = Executors.newFixedThreadPool(10);

    @Test
    public void test001() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(1009));
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("welcome new connect");
                executors.execute(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            InputStream inputStream = null;
                            try {
                                inputStream = socket.getInputStream();
                                byte[] result = new byte[1024];
                                int len = inputStream.read(result);
                                if (len != -1) {
                                    System.out.println("[response] " + new String(result, 0, len));
                                    OutputStream outputStream = socket.getOutputStream();
                                    outputStream.write("response data".getBytes());
                                    outputStream.flush();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
