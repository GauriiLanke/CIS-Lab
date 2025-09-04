// AtbashCipher Algorithm

import java.util.*;
public class AtbashCipher{
    String encryption(String PT){
        String CT="";
        for (int i = 0; i < PT.length(); i++) {
            char ch = PT.charAt(i);

            if (Character.isUpperCase(ch)) {
                ch = (char) ('A' + ('Z' - ch));
            } else if (Character.isLowerCase(ch)) {
                ch = (char) ('a' + ('z' - ch));
            }
            CT += ch; 
        }
        return CT;
    }
    public static void main(String args[]){
        AtbashCipher a=new AtbashCipher();
        System.out.println("\nATBASH CIPHER ALGORITHM");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the PlainText: ");
        String PT=sc.nextLine();
        System.out.println("Encrpted Text: "+a.encryption(PT));
        sc.close();
    }
}