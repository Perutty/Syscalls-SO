/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bp_rm
 */
public class Arbol {

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        
        String mensaje = "Comando tree: ";
        System.out.write(mensaje.getBytes(),0,mensaje.length());
        

        FileOutputStream salida = new FileOutputStream("src/datos/arbol.txt");
        File fileName = new File("src/datos/arbol.txt");
        System.setOut(new PrintStream (salida));
        
        System.out.write(mensaje.getBytes(),0,mensaje.length());
        
        String comando[]={"cmd.exe","/c", "chcp", "65001", "&&","tree", "C:\\Users\\bp_rm\\eclipse"};
        String comando2[]={"notepad.exe",fileName.getAbsolutePath()};
        Process proceso=Runtime.getRuntime().exec(comando);
        Process proceso2=Runtime.getRuntime().exec(comando2);
        
        BufferedReader is = new BufferedReader(new InputStreamReader(proceso.getInputStream(), "UTF-8"));
        String line;
        String msg="";
        // reading the output
        while ((line = is.readLine()) != null) {
            msg+=line+"\n";
            
        }
            System.out.println(msg);
        
        
        int codigo=1;
        try {
            codigo = proceso.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Código:"+codigo);
        
        salida.close();
    }
    
}
