# SecurityPackage
Provides secure encryption and decryption algorithms using four classical encryption algorithms: Caesar cipher, Vigenère cipher, Substitution cipher, and Playfair cipher. The library is designed with clean code principles in mind and follows object-oriented programming (OOP) best practices. 

The project consists of an abstract Cipher class that serves as the base class for all four ciphers, and a main class that demonstrates the use of the ciphers. The "Cipher" abstract class contains common methods and properties that are shared by all ciphers, such as the ability to set and get the key, encrypt and decrypt a message, and validate the key. Each of the four ciphers extends this abstract class and implements its own encryption and decryption algorithm. The ciphers are designed to be flexible and customizable, allowing users to choose their own keys and message inputs.

The Caesar cipher is a simple substitution cipher in which each letter in the plaintext is shifted a certain number of positions down the alphabet. For example, with a shift of 3, A would be replaced by D, B would become E, and so on.

The Vigenère cipher is a more complex polyalphabetic cipher in which a series of interwoven Caesar ciphers are used, each with a different shift value determined by a keyword.


The Substitution cipher is a type of cipher in which each letter in the plaintext is replaced by another letter or symbol. The encryption key is a table of substitutions that maps each letter in the alphabet to a corresponding replacement.

The Playfair cipher is a polygraphic substitution cipher that encrypts pairs of letters instead of individual letters. It uses a 5x5 grid of letters to perform the encryption, and the plaintext is processed in pairs of letters, with each pair forming a "digraph".

The main class provides a simple command-line interface that allows users to input their message and key, select a cipher, and encrypt or decrypt their message. The main class also includes test cases that validate the correctness of the encryption and decryption algorithms.

