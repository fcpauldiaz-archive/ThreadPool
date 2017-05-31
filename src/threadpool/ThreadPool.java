/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



/**
 *
 * @author SDX
 */
public class ThreadPool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int cantThreads = 3;
        File file = new File("threads.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String text = null;
        String archivo = "";
        while ((text = reader.readLine()) != null) {
            archivo += text;
        }
        archivo = archivo.substring(archivo.indexOf("=")+1).trim();
        
        cantThreads = Integer.parseInt(archivo);
        MultiThreadedServer server = new MultiThreadedServer(2407, cantThreads);
        new Thread(server).start();

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
