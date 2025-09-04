// VigenereCipher Algorithm

import java.util.*;

public class VigenereCipher {
    public static String encryption(String plainText, String key) {
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();
        // Repeat key to match the length of plaintext
        StringBuilder keyRepeated = new StringBuilder();
        for (int i = 0, j = 0; i < plainText.length(); i++) {
            if (Character.isLetter(plainText.charAt(i))) {
                keyRepeated.append(key.charAt(j));
                j = (j + 1) % key.length();
            } else {
                keyRepeated.append(plainText.charAt(i)); 
            }
        }

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char p = plainText.charAt(i);
            char k = keyRepeated.charAt(i);
            if (Character.isLetter(p)) {
                int pIndex = p - 'A';
                int kIndex = k - 'A';
                int cIndex = (pIndex + kIndex) % 26;
                cipherText.append((char) ('A' + cIndex));
            } else {
                cipherText.append(p); 
            }
        }
        return cipherText.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nVIGENERE CIPHER ALGORITHM");
        System.out.print("Enter the Plaintext: ");
        String PT = sc.nextLine();
        System.out.print("Enter the keyword: ");
        String Key = sc.nextLine();
        String CT = encryption(PT, Key);
        System.out.println("Cipher Text: " + CT);
        sc.close();
    }
}
