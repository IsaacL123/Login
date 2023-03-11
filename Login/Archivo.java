
package Login;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Archivo {
    
     private static Scanner sc;
    
    public void crear(String usr,String pass){
          FileReader fr = null;
            try {
                String user, pwd;
                int nLineas = 0;
                int i =0;
                String [] usuarios = null;
                String linea;
                sc = new Scanner(new File("Direccion" + "Usurios.txt"));
                File f = new File("D:/Usuarios.txt");
                fr = new FileReader(f);
                BufferedReader br = new  BufferedReader(fr);
                
                        try {
                            while((linea = br.readLine())!= null){
                                    nLineas++;
                            }
                        } catch (IOException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                usuarios = new String[nLineas];
                
                while(sc.hasNextLine()){
                    usuarios[i++] = sc.nextLine();
       
                }
             
                user = usr;
                pwd = pass;
                        
                Archivo ar = new Archivo();
                ar.validar(usuarios, user, pwd);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    } 
    
    public void validar(String usuarios[], String usr, String pwd){
    
        boolean encontrado = false;
        String res;
        
        for(int i =0; i < usuarios.length; i++){
            if((usuarios[i].equalsIgnoreCase(usr) && usuarios[i+1].equals(pwd))){
                res = "Bienvenido " + usr;
                encontrado = true;
                JOptionPane.showMessageDialog(null, res,"Inicio de sesion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if(encontrado == false){
            res = "Usuario y/o contraseña incorectos";
            JOptionPane.showMessageDialog(null, res, "inicio de sesion", JOptionPane.ERROR_MESSAGE);   
        }
        }
    }
    

