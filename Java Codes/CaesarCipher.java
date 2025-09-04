// CaesarCipher Algorithm

import java.util.*;
public class CaesarCipher {
    String encryption(String PT,int key){
        String CT="";
        for (int i = 0; i < PT.length(); i++) {
            char ch = PT.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = (char) (((ch - 'A' + key) % 26) + 'A');
            } else if (Character.isLowerCase(ch)) {
                ch = (char) (((ch - 'a' + key) % 26) + 'a');
            }
            CT += ch;
        }
        return CT;
    }
    String decryption(String CT,int key){
        String PT="";
        for (int i = 0; i < CT.length(); i++) {
            char ch = CT.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = (char) (((ch - 'A' - key + 26) % 26) + 'A');
            } else if (Character.isLowerCase(ch)) {
                ch = (char) (((ch - 'a' - key + 26) % 26) + 'a');
            }
            PT += ch;
        }
        return PT;
    }

    public static void main(String args[]){
        CaesarCipher c=new CaesarCipher();
        Scanner s = new Scanner(System.in);
        System.out.println("\nCAESAR CIPHER ALGORITHM");
        System.out.println("Enter the Plaintext: ");
        String PT=s.nextLine();
        System.out.println("Enter the Key: ");
        int key=s.nextInt();
        System.out.println("Encrypted Text: "+ c.encryption(PT, key)); 
        System.out.println("Decrypted Text: " + c.decryption(c.encryption(PT, key), key));
        s.close();
    }
}
