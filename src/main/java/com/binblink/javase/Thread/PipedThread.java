package com.binblink.javase.Thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author:binblink
 * @Description
 * @Date: Create on  2018/10/15 0:18
 * @Modified By:
 * @Version:1.0.0
 **/
public class PipedThread {


    public static void main(String[] args) throws IOException {

        PipedReader preader = new PipedReader();
        PipedWriter pwriter = new PipedWriter();

        preader.connect(pwriter);

        Thread t1 = new Thread(new Print(preader), "readerThread");

        t1.start();
        int recevie  = 0;

        try{
            while((recevie = System.in.read()) != -1){
                pwriter.write(recevie);
            }
        }finally {
            pwriter.close();
        }


    }

    static class Print implements Runnable {

        private PipedReader reader;

        public Print(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int recevie = 0;

            try {
                while ((recevie = reader.read()) != -1) {

                    System.out.print((char) recevie);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
