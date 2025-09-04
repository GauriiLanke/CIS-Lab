// AffineCipher Algorithm

import java.util.*;
public class AffineCipher {
    public static String affineEncrypt(String plaintext, int a, int b) {
        StringBuilder result = new StringBuilder();

        for (char ch : plaintext.toUpperCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                int P = ch - 'A';  
                int C = (a * P + b) % 26;  
                result.append((char) (C + 'A'));  
            } else {
                result.append(ch); 
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("\nAFFINE CIPHER ALGORITHM");
        System.out.println("Enter the Plaintext");
        String plaintext=sc.nextLine();
        System.out.println("Enter the value of a and b (prime no. from 1 to 26):");
        int a = sc.nextInt();
        int b = sc.nextInt();
        String ciphertext = affineEncrypt(plaintext, a, b);
        System.out.println("Affine Cipher Text: " + ciphertext);
        sc.close();
    }
}
