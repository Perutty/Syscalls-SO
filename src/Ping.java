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

public class Ping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
        System.out.println("¿Quieres asignar el número de PINGS? (1) Sí, (2) NO, por defecto");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        
        if(n==1){
            System.out.println("Digite el número de PINGS que desea: ");
            Integer n2 = scanner.nextInt();
            pingsARealizar(n2);
        }
        else if(n==2){
            pingPorDefecto();
        }
        scanner.close();
    }
    
    public static void pingsARealizar(Integer n) throws FileNotFoundException, IOException {
            
            FileOutputStream salida = new FileOutputStream("src/datos/ping.txt");
            File fileName = new File("src/datos/ping.txt");
            
            String comando[]={"cmd.exe","/c", "ping", "-n", ""+n, "www.google.com"};
            String comando2[]={"notepad.exe",fileName.getAbsolutePath()};
            Process proceso=Runtime.getRuntime().exec(comando);
            
            BufferedReader is = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String line;
            String msg="";
            // reading the output
            
            if(is.readLine().isEmpty()){
            while ((line = is.readLine()) != null){
                    msg+=line+"\n";
                }
            }else{
                  msg="No hay conexión a internet";
            }
             
            int codigo=1;
            try {
                codigo = proceso.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
            }
            msg+="Codigo: "+codigo;
            System.out.write(msg.getBytes(),0,msg.length());
            System.setOut(new PrintStream (salida));
            System.out.println(msg);
            
            salida.close();
            Process proceso2=Runtime.getRuntime().exec(comando2);
}
    
    public static void pingPorDefecto() throws FileNotFoundException, IOException{
        
            FileOutputStream salida = new FileOutputStream("src/datos/ping.txt");
            File fileName = new File("src/datos/ping.txt");
            
            System.setOut(new PrintStream (salida));
            /**PrintStream inicial=System.out;
            System.setOut(inicial);**/

            String comando[]={"cmd.exe","/c", "ping", "www.google.com"};
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
