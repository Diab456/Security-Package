package alogrithm_chiper;

public class VigenereCipher extends Abstract {
    //protected static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 

    @Override
    public String encrypt(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();
        message = message.toUpperCase();
        key = key.toUpperCase();
        int j = 0;
        
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            
            if (Character.isLetter(c)){
                int plaintextIndex = ALPHABET.indexOf(c);
                int keyIndex = ALPHABET.indexOf(key.charAt(j)); 
                int encryptedMessageIndex = (plaintextIndex + keyIndex) % ALPHABET.length();
                encryptedMessage.append(ALPHABET.charAt(encryptedMessageIndex));
                j = (j + 1) % key.length();

            }else{
                encryptedMessage.append(c);
 
            }
        }
        return encryptedMessage.toString();

    }

        
    

    @Override
    public String decrypt(String message, String key) {
        StringBuilder decryptedMessage = new StringBuilder();
        message = message.toUpperCase();
        key = key.toUpperCase();
        
        int j = 0;
        for (int i = 0; i < message.length(); i++){
            char c = message.charAt(i);
            
            if (Character.isLetter(c)){
                int encryptedMessageIndex = ALPHABET.indexOf(c);
                int keyIndex = ALPHABET.indexOf(key.charAt(j));
                int plaintextIndex = (encryptedMessageIndex - keyIndex + ALPHABET.length()) % ALPHABET.length();
                
                decryptedMessage.append(ALPHABET.charAt(plaintextIndex));
                j = (j + 1) % key.length();
            
            }else{
                decryptedMessage.append(c);

            }

        }
        return decryptedMessage.toString();

    }
   
}
