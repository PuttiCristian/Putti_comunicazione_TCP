/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcomunication;

/**
 *
 * @author cristian
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Server s = new Server(2006);
       s.attendi();
       s.chiudi();
    }
    
}
