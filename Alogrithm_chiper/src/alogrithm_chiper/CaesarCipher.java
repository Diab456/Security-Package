package alogrithm_chiper;

import static alogrithm_chiper.VigenereCipher.ALPHABET;

public class CaesarCipher extends Abstract{
    //private static final int SHIFT = 3;

    @Override
    public String encrypt(String message, String key ) {
        int SHIFT = Integer.parseInt(key);

        StringBuilder encryptedMessage = new StringBuilder();
        message = message.toUpperCase();
        
        for (int i = 0; i < message.length(); i++){
            char c = message.charAt(i);
            
            if (Character.isLetter(c)) {
                int plaintextIndex = ALPHABET.indexOf(c);
                int encryptedMessageIndex = (plaintextIndex + SHIFT) % ALPHABET.length();
                encryptedMessage.append(ALPHABET.charAt(encryptedMessageIndex));
                
            }else {
                encryptedMessage.append(c);

            }

        }
        return encryptedMessage.toString();
    }
    

    @Override
    public String decrypt(String message, String key) {
         int SHIFT = Integer.parseInt(key);
        StringBuilder decryptedMessage = new StringBuilder();
        message = message.toUpperCase();
        
        for (int i = 0; i < message.length(); i++){
            char c = message.charAt(i);
            
            if (Character.isLetter(c)){
                int encryptedMessageIndex = ALPHABET.indexOf(c);
                int plaintextIndex = (encryptedMessageIndex - SHIFT + ALPHABET.length()) % ALPHABET.length();
                decryptedMessage.append(ALPHABET.charAt(plaintextIndex));

            }else{
                decryptedMessage.append(c);

            }

        }
        return decryptedMessage.toString();

    
    }
    
}



