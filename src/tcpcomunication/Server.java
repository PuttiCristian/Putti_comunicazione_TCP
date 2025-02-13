/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcomunication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian
 */
public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;
    InputStream is;
    OutputStream os;
    PrintWriter streamOut = null;
    Scanner streamIn = null;
    String messaggioIn;
    String messaggioOut;

    
    public Server(int porta){
        this.porta=porta;
        try{
            serverSocket = new ServerSocket(porta);
            System.out.println("1) SERVER IN ASCOLTO");
        } catch(SecurityException ex) {
            System.out.println("periferica non accessibile");
        }catch(BindException ex) {
            System.out.println("porta occupata");
        } catch(IllegalArgumentException ex) {
             System.out.println("numero di porta non valido");
        }
        catch(IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRORE DEL SERVER NELLA FASE DI BINDING");
        }
    }
    
        public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("2) CONNESSIONE CON IL CLIENT AVVENUTA E DATA SOCKET CREATO");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("PROBLEMI DI CONNESSIONE CON IL CLIENT");
        }
        return clientSocket;
        }
        
        public void leggi() {
           System.out.println("leggo il messaggio del client");
           messaggioIn=streamIn.next();
           System.out.println("messaggio del client"+ messaggioIn);
           System.out.println("-----");

        
        }
        
        public void scrivi() {
            try {
                os=clientSocket.getOutputStream();
                streamOut=new PrintWriter(os);
                is= clientSocket.getInputStream();
                streamIn=new Scanner(is);
                System.out.println("mando il messaggio al client");
                messaggioOut="ciao";
                streamOut.println(messaggioOut);
                streamOut.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        public void chiudi() {
        try {
            clientSocket.close();
            System.out.println("5) chiusura comunicazione");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void termina() {
        try {
            serverSocket.close();
            System.out.println("6) chiusura Server");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }