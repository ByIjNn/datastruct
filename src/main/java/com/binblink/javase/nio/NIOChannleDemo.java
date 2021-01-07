package com.binblink.javase.nio;

import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @Description
 * @Author binblink
 * @Date 2020/12/4 10:32
 */
public class NIOChannleDemo {

    @Test
    public void test1() throws IOException {

        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\35338\\Desktop\\临时记事.txt",
                "r");

        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        int b = fileChannel.read(byteBuffer);

        while (b != -1) {
            //显示读取到缓存中的数据长度
//            System.out.print(b);
            //切换 position 的位置 为下一步读数据做准备
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                //1byte 1byte读 无法显示中文 会乱码
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear(); // 清楚所有的数据
//            byteBuffer.compact(); //只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
            b = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
    }

    @Test
    public void test2() throws IOException {

        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\35338\\Desktop\\临时记事.txt",
                "r");
        Charset charset = Charset.forName("utf-8");
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        int b = fileChannel.read(byteBuffer);

        while (b != -1) {
            byteBuffer.flip();
            CharBuffer charBuffer = charset.decode(byteBuffer);
            System.out.println(charBuffer.toString());
            byteBuffer.compact();
            b = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
    }


}
