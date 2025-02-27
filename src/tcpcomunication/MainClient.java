/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcomunication;

/**
 *
 * @author Cristian
 */
public class MainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Client c = new Client("c1","localhost", 50005);
            Thread t1 = new Thread(c);
            t1.start();
    }
    
}
