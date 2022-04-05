/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketjava;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enric
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket socket;
        try {
            //socket=new Socket("unobravo.com",80);
            socket=new Socket(InetAddress.getLocalHost(),2000);
            //socket=new Socket("127.0.0.1",2000);

            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(br.readLine());
            System.out.println("Connessione Avvenuta\n");
            System.out.println("Socket" + socket);
            
            br.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
