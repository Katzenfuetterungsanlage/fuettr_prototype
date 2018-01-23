/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian
 */
public class HashPassword
{

    public static String get_SHA_512_SecurePassword(String passwordToHash, String salt)
    {
        String generatedPassword = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0;
                    i < bytes.length;
                    i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException ex)
        {
            Logger.getLogger(HashPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generatedPassword;
    }
    
    public static void main(String[] args)
    {
        String password = "enter";
        System.out.println("Password: " + password);
        
        String password_hash = get_SHA_512_SecurePassword(password, "");
        
        System.out.println("hashed password: " + password_hash);
    }
}
