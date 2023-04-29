package alogrithm_chiper;
import java.util.*;

public class Alogrithm_chiper {
    

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose a cipher type: Caesar (C) or Vigenere (V) or Substitution(S) or PlayfairCipher(P) : ");
        String cipherType = scanner.nextLine().toUpperCase();
        
        Abstract cipher = null;
        while (cipher == null) {
        
        
        switch (cipherType) {
            case "C":
                cipher = new CaesarCipher();
                break;
                  
            case "V":
                cipher = new VigenereCipher();
                break;
            case "S":
                cipher = new VigenereCipher();
                break;
                
            case "P":
                cipher = new VigenereCipher();
                break;
                
            default:
                System.out.println("Invalid cipher type! \n Choose a cipher type: Caesar (C) or Vigenere (V) or Substitution(S) or PlayfairCipher(P) :");
                cipherType = scanner.nextLine().toUpperCase();
                
        }
        }
    
        System.out.println("Please, enter a message:");
        String message = scanner.nextLine();

        System.out.println("Enter a key:");
        String key = scanner.nextLine();
        
        String encryptedMessage = cipher.encrypt(message, key);
        String decryptedMessage = cipher.decrypt(encryptedMessage, key);
        
        System.out.println("Encrypted message: " + encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}