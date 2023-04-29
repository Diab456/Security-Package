package alogrithm_chiper;

public abstract class Abstract {
    
    protected static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public abstract String encrypt(String message, String key);
    public abstract String decrypt(String message, String key);  
}
