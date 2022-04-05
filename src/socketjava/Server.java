/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketjava;

import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enric
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket serverSocket;
        String data=LocalDateTime.now().toString();
        try {
            serverSocket=new ServerSocket(2000);
            Socket socket=serverSocket.accept();
            serverSocket.close();
            
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("Benvenuto!\n");
            bw.flush();
            
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if("date".equals(br.readLine())) {
                Long tmStmp = System.currentTimeMillis();
                bw.write(tmStmp+"\n");
                bw.flush();
            }
             
            br.close();
            bw.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
