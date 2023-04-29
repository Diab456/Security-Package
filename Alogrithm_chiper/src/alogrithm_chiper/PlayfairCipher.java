package alogrithm_chiper;

public class PlayfairCipher extends Abstract {
    // This constant string contains the letters used in the Playfair Cipher grid
    private static final String GRID_LETTERS = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    
    // This variable is a 2-dimensional array used to store the Playfair Cipher grid
    private char[][] grid;
    
    // This constructor takes a String "key" as input, generates a Playfair Cipher grid using that key, and assigns the generated grid to the "grid" variable
    public PlayfairCipher(String key){
        this.grid = generateGrid(key);
    }
    
    // This method generates a Playfair Cipher grid based on the input "key" and returns it as a 2-dimensional array of characters
    private char[][] generateGrid(String key){
        char[][] grid = new char[5][5];
        String keyWithoutJ = key.toUpperCase().replace("J", "I").replaceAll("[^A-Z]", "");
        String letters = keyWithoutJ + GRID_LETTERS;
        int index = 0;// Initialize a variable "index" to 0
        
       // Loop through the rows and columns of the grid and assign each cell a letter from the "letters" string in sequential order
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++) {
                grid[i][j] = letters.charAt(index++);

            }
        }
        return grid; // Return the generated grid
    }

    @Override
    public String encrypt(String message, String key) {
        String plaintext = message.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder ciphertext = new StringBuilder();
        
        // Loop through the plaintext two characters at a time and encrypt each pair
        for (int i = 0; i < plaintext.length(); i += 2) {
            
            // Assign the first character of the pair to variable "c1"
            char c1 = plaintext.charAt(i);
            
            // Assign the second character of the pair to variable "c2", or 'X' if there is no second character
            char c2 = (i < plaintext.length() - 1) ? plaintext.charAt(i + 1) : 'X';
            // Get the row and column indices of the cell containing character "c1"
            int[] pos1 = findPosition(c1); 
            // Get the row and column indices of the cell containing character "c2"
            int[] pos2 = findPosition(c2);
            
           // If the two characters are in the same row, append the characters to the ciphertext string by moving one position to the right in the same row
            if (pos1[0] == pos2[0]) {
                ciphertext.append(grid[pos1[0]][(pos1[1] + 1) % 5]);
                ciphertext.append(grid[pos2[0]][(pos2[1] + 1) % 5]);
                
                
            }else if (pos1[1] == pos2[1]) {
                ciphertext.append(grid[(pos1[0] + 1) % 5][pos1[1]]);
                ciphertext.append(grid[(pos2[0] + 1) % 5][pos2[1]]);
            
            
            }else {
                ciphertext.append(grid[pos1[0]][pos2[1]]);
                ciphertext.append(grid[pos2[0]][pos1[1]]);

            }
        }
        return ciphertext.toString();

    }

    @Override
    public String decrypt(String message, String key) {
        String ciphertext = message.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder plaintext = new StringBuilder();
        
        // Loop through the ciphertext in pairs of characters
        for (int i = 0; i < ciphertext.length(); i += 2) {
            
            // Get the two characters in the current pair
            char c1 = ciphertext.charAt(i);
            char c2 = ciphertext.charAt(i + 1);
            
            // Find the positions of the characters in a 5x5 grid
             int[] pos1 = findPosition(c1);
             int[] pos2 = findPosition(c2);
             
             // If the characters are in the same row, replace them with the characters to their left (wrapping around to the right side of the grid)
              if (pos1[0] == pos2[0]) {
                   plaintext.append(grid[pos1[0]][(pos1[1] + 4) % 5]);
                   plaintext.append(grid[pos2[0]][(pos2[1] + 4) % 5]);

             // If the characters are in the same column, replace them with the characters above them (wrapping around to the bottom of the grid)
              }else if (pos1[1] == pos2[1]) {
                  plaintext.append(grid[(pos1[0] + 4) % 5][pos1[1]]);
                  plaintext.append(grid[(pos2[0] + 4) % 5][pos2[1]]);
              
              // If the characters are neither in the same row nor column, replace them with the characters in the same row but opposite column
              }else {
                  plaintext.append(grid[pos1[0]][pos2[1]]);
                  plaintext.append(grid[pos2[0]][pos1[1]]);

              }

        }
        
        return plaintext.toString(); // Return the decrypted message as a string

    }
    private int[] findPosition(char c) {
        int[] pos = new int[2];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                
                if (grid[i][j] == c) {
                    
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;

    }
    
}
