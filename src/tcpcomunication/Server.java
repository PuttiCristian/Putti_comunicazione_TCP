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
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    
    public Server(int porta){
        this.porta=porta;
        try{
            serverSocket = new ServerSocket(porta);
            System.out.println(RED + "1) SERVER IN ASCOLTO" + RESET);
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
            System.out.println(RED + "2) CONNESSIONE CON IL CLIENT AVVENUTA E DATA SOCKET CREATO" + RESET);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("PROBLEMI DI CONNESSIONE CON IL CLIENT");
        }
        return clientSocket;
        }
        
        public void leggi() {
            try {
                os=clientSocket.getOutputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            streamOut=new PrintWriter(os);
            try {
                is= clientSocket.getInputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            streamIn=new Scanner(is);
           System.out.println(RED + "leggo il messaggio del client" + RESET);
           messaggioIn=streamIn.next();
           System.out.println(RED + "messaggio del client"+ messaggioIn + RESET);
           System.out.println(RED + "-----" + RESET);

        
        }
        
        public void scrivi() {
            try {
                os=clientSocket.getOutputStream();
                streamOut=new PrintWriter(os);
                is= clientSocket.getInputStream();
                streamIn=new Scanner(is);
                System.out.println(RED + "mando il messaggio al client" + RESET);
                messaggioOut="ciao\n\r";
                streamOut.println(RED + messaggioOut+ RESET);
                streamOut.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        public void chiudi() {
        try {
            clientSocket.close();
            System.out.println(RED + "5) chiusura comunicazione" + RESET);
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