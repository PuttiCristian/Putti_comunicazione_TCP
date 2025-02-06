/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcomunication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class Client {
    String nome;
    String colore;
    Socket socket;
    
    public Client(String nome){
    this.nome = nome;
    }
            
    public void connetti(String nomeServer, int porta){
        try {
            socket = new Socket(nomeServer, porta);
            System.out.println("1) CONNESSIONE AVVENUTA CON IL SERVER");
        } catch(ConnectException ex){
            System.out.println("errore connessione Server");
        } catch(UnknownHostException ex){
            System.out.println("errore risoluzione del nome");
        }catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRORE NELLA CONNESSIONE");
        }
  }
    public void leggi() {
       InputStream i;
        try {
            i = socket.getInputStream();
            i.read();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void scrivi() {
         try {
             OutputStream o = socket.getOutputStream();
             o.write(1);
             o.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chiudi() {
       if(socket != null) 
           try {
               socket.close();
               System.out.println("4) chiusura della connessione con il server");
       } catch (IOException ex) {
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
