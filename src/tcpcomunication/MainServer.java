/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcomunication;
import java.util.Scanner;
/**
 *
 * @author cristian
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Server s = new Server(50005);
       while(true) {
           s.attendi();
           s.leggi();
           s.scrivi();
           s.chiudi();
           // s.termina();
       }
    }
    
}
