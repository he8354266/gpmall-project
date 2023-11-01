package com.gmall.kafka.services;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description //TODO
 * @Date 2023/10/26 14:28
 * @Author hy
 **/
public class NioSocketServer extends Thread {
    ServerSocketChannel serverSocketChannel = null;
    Selector selector = null;
    SelectionKey selectionKey = null;

    public void initServer() throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        //设置非阻塞模式
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {
        while (true) {
            //堵塞
            try {
                int selectKey = selector.select();
                if (selectKey > 0) {
                    Set<SelectionKey> keySet = selector.selectedKeys();
                    Iterator<SelectionKey> iter = keySet.iterator();
                    while (iter.hasNext()) {
                        SelectionKey selectionKey = iter.next();
                        //清空 防重复
                        iter.remove();
                        //处理连接
                        if (selectionKey.isAcceptable()) {
                            accept(selectionKey);
                        }
                        if (selectionKey.isReadable()) {
                            read(selectionKey);
                        }
                        if(selectionKey.isWritable()){
                            //Todo 写事件
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void accept(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("conn is acceptable");
        //设置非阻塞连接
        socketChannel.configureBlocking(false);
        //将当前channel交给selector对象监管
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void read(SelectionKey selectionKey) throws IOException {
        try {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len = socketChannel.read(byteBuffer);
            if (len > 0) {
                byteBuffer.flip();
                byte[] byteArray = new byte[byteBuffer.limit()];
                byteBuffer.get(byteArray);
                System.out.println(new String(byteArray, 0, len));
                selectionKey.interestOps(SelectionKey.OP_READ);
            }
        } catch (Exception e) {
            serverSocketChannel.close();
            selectionKey.channel();
        }

    }

    public static void main(String[] args) throws IOException {
        NioSocketServer nioSocketServer = new NioSocketServer();
        nioSocketServer.initServer();
        nioSocketServer.start();
    }
}
