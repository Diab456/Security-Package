package alogrithm_chiper;

public class SubstitutionCipher extends Abstract {
    private static final String key = "defghijklmnopqrstuvwxyzabc"; 
    
    
    @Override
    public String encrypt(String message, String key) {
        StringBuilder cipherText = new StringBuilder();
        
      // This is a for loop that iterates through each character in the "message" string
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            
           // The "ALPHABET" string is used to get the index of the current character in the alphabet
            int index = ALPHABET.indexOf(Character.toLowerCase(c));
            // If the index of the character is not equal to -1 (meaning it is a valid character), the substitution character is retrieved from the key
            if (index != -1){
                char substitutionChar = key.charAt(index % key.length());
                
                // If the current character is uppercase, the substitution character is also made uppercase
                if (Character.isUpperCase(c)){
                    substitutionChar = Character.toUpperCase(substitutionChar);
                }
                // The substitution character is added to the cipher text
                cipherText.append(substitutionChar);
                
            } else {
                cipherText.append(c);
            } 
        }
        return cipherText.toString();
    }

    @Override
    public String decrypt(String message, String key) {
        StringBuilder plainText = new StringBuilder();
        
        // This is a for loop that iterates through each character in the "message" string
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            
            // The index of the current character in the key is retrieved
            int index = key.indexOf(Character.toLowerCase(c));
            
            // If the index of the character is not equal to -1 (meaning it is a valid character), the plain character is retrieved from the alphabet
            if (index != -1){
                char plainChar = ALPHABET.charAt(index);
                
                // If the current character is uppercase, the plain character is also made uppercase
                if (Character.isUpperCase(c)) {
                    plainChar = Character.toUpperCase(plainChar);
                }       
                // The plain character is added to the plain text
                plainText.append(plainChar);
                
            } else {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }
}

    