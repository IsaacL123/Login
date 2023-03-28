
package Login;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.swing.JOptionPane;





public class Seguridad {
    
  public String encriptar(String pass){
      String str = null;
      try{
           MessageDigest md = MessageDigest.getInstance("MD5");
          md.update(pass.getBytes(), 0, pass.length());
               
          str = new BigInteger(1, md.digest()).toString(16);
          
          return str;    
      }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Algo salio mal");
      }
      return null;
  }
  
}