// PlayfairCipher Algorithm

import java.util.*;

public class PlayfairCipher {
    private static char[][] matrix = new char[5][5];
    private static void generateMatrix(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder();

        for (char c : key.toCharArray()) {
            if (sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J' && sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }

        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = sb.charAt(index++);
            }
        }

        System.out.println("\nPlayfair Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        // Prepare digraphs
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
            if (i + 1 < text.length()) {
                if (text.charAt(i) == text.charAt(i + 1)) {
                    sb.append('X');
                } else {
                    sb.append(text.charAt(++i));
                }
            }
        }
        if (sb.length() % 2 != 0) sb.append('X');

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < sb.length(); i += 2) {
            char a = sb.charAt(i);
            char b = sb.charAt(i + 1);
            encrypted.append(encryptPair(a, b));
        }
        return encrypted.toString();
    }

    private static String encryptPair(char a, char b) {
        int[] posA = findPosition(a);
        int[] posB = findPosition(b);

        if (posA[0] == posB[0]) { // Same row
            return "" + matrix[posA[0]][(posA[1] + 1) % 5] +
                       matrix[posB[0]][(posB[1] + 1) % 5];
        } else if (posA[1] == posB[1]) { // Same column
            return "" + matrix[(posA[0] + 1) % 5][posA[1]] +
                       matrix[(posB[0] + 1) % 5][posB[1]];
        } else { // Rectangle rule
            return "" + matrix[posA[0]][posB[1]] +
                       matrix[posB[0]][posA[1]];
        }
    }

    private static int[] findPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPLAYFAIR CIPHER ALGORITHM");
        System.out.print("\nEnter the plaintext: ");
        String plaintext = sc.nextLine();
        System.out.print("Enter the key: ");
        String key = sc.nextLine();
        generateMatrix(key); //Generate matrix
        String encryptedText = encrypt(plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
        sc.close();
    }
}