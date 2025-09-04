// KeywordCipher Algorithm 

import java.util.*;

public class KeywordCipher {
    // create cipher alphabet based on keyword
    public static String generateCipherAlphabet(String key) {
        key = key.toUpperCase();
        StringBuilder cipherAlphabet = new StringBuilder();
        // Add keyword characters 
        for (char ch : key.toCharArray()) {
            if (cipherAlphabet.indexOf(String.valueOf(ch)) == -1 && Character.isLetter(ch)) {
                cipherAlphabet.append(ch);
            }
        }
        // Add remaining alphabets
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (cipherAlphabet.indexOf(String.valueOf(ch)) == -1) {
                cipherAlphabet.append(ch);
            }
        }
        return cipherAlphabet.toString();
    }

    public static String encryption(String plainText, String key) {
        String cipherAlphabet = generateCipherAlphabet(key);
        String normalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        plainText = plainText.toUpperCase();
        StringBuilder cipherText = new StringBuilder();
        for (char ch : plainText.toCharArray()) {
            if (Character.isLetter(ch)) {
                int index = normalAlphabet.indexOf(ch);
                cipherText.append(cipherAlphabet.charAt(index));
            } else {
                cipherText.append(ch); 
            }
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nKEYWORD CIPHER ALGORITHM");
        System.out.print("Enter the Plaintext: ");
        String PT = sc.nextLine();
        System.out.print("Enter the keyword: ");
        String Key = sc.nextLine();
        String CT = encryption(PT, Key);
        System.out.println("Cipher Text: " + CT);
        sc.close();
    }
}
