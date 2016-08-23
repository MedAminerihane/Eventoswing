/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technique;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 *
 * @author IDRISS
 */
public class GoogleMap {

    public GoogleMap() {
    }
    
    
    
    private static final String URL_UNRESERVED =  
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +  
        "abcdefghijklmnopqrstuvwxyz" + 
        "0123456789-_.~";

        private static final char[] HEX = "0123456789ABCDEF".toCharArray();
                        String destinationFile="";


    public String ConstructMap(String adr, int x){
        
        
        

        try {
            String imageUrl = "http://maps.googleapis.com/maps/api/staticmap?center="+ urlEncode(adr) +"&zoom="+x+"&size=490x310&maptype=roadmap&markers=color:red%7C"+ urlEncode(adr);
            destinationFile = "image"+adr+x+".jpg";
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);
            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(destinationFile);
        return destinationFile;

        
        
    
    }
    
    

    
    
    
  
    
    private static String urlEncode(String str) { 
        StringBuffer buf = new StringBuffer(); 
        byte[] bytes = null; 
        try { 
            ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
            DataOutputStream dos = new DataOutputStream(bos); 
            dos.writeUTF(str); 
            bytes = bos.toByteArray(); 
        } catch (IOException e) { 
            // ignore 
        } 
        for (int i = 2; i < bytes.length; i++) { 
            byte b = bytes[i]; 
            if (URL_UNRESERVED.indexOf(b) >= 0) { 
                buf.append((char) b); 
            } else { 
                buf.append('%').append(HEX[(b >> 4) & 0x0f]).append(HEX[b & 0x0f]); 
            } 
        } 
        return buf.toString(); 
    }
    
}
