/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjava;

import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Test1 {
    public static void main(String [] args){
        JFileChooser jFileChooser = new JFileChooser();
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
           System.out.println(jFileChooser.getSelectedFile());
               try {
                    File file = new File(jFileChooser.getSelectedFile().toString());
                    String fileName = getRandomString()+"-"+System.currentTimeMillis()+"."+jFileChooser.getSelectedFile().getName().split("\\.")[1];
                    File des = new File("C:\\img\\"+fileName);
                    File checkPath = new File(System.getProperty("user.dir")+"\\images");
                    boolean createDirectoryExists = true;
                    if(!checkPath.exists()){
                       createDirectoryExists  = checkPath.mkdirs();
                    }
                    if(createDirectoryExists){
                        Path to = Paths.get(System.getProperty("user.dir")+"\\images\\"+fileName);
                        //System.out.println(System.getProperty("user.dir"));
                        //System.out.println(Paths.get("").toAbsolutePath().toString());
                        Path p = Files.copy(file.toPath(),to, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println(p.isAbsolute());
                    }
               } catch (IOException ex) {
                   Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
    }
    private static String getRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
