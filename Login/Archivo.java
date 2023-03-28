
package Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Archivo {
  
    FileWriter fichero;
    FileReader archivo;
    BufferedReader lector;
    
    public void crear() throws IOException {
        try{
            fichero = new FileWriter("Direccion" + "\\BD.txt");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Archivo no Encontrado");
          
            
        }
    
    }
    
    public void escribir(String usr, String pwd) throws IOException{
        
        try{
            fichero.write(usr + ", ");
            fichero.write(pwd);
        
            fichero.close();
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Archivo no Encontrado");
            
        }
    
    }
    
    public void leer(String usr, String pwd){
        String str = null;
        String strP = usr + ", " + pwd;
        
        try{
            archivo = new FileReader("Direccion" + "\\BD.txt");
                if(archivo.ready()){
                    lector = new  BufferedReader(archivo);
                    while((str = lector.readLine()) != null){
                        if(str.contains(strP)){
                            JOptionPane.showMessageDialog(null,"Hola " + usr + " Bienvenido");
                        }else{
                            System.out.println("Usuario y/o Contraseña Incorectos");
                        
                        }
                    }
                }else{
                    System.out.println("No se puede leer");
                }
        }catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
       
   
    }
}

    
  

