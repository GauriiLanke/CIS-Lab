import java.util.*;

public class HillCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- HILL CIPHER ALGORITHM ---");

        // Input key word
        System.out.print("Enter the key word (length must be a perfect square): ");
        String keyWord = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        int length = keyWord.length();
        int n = (int) Math.sqrt(length);

        if (n * n != length) {
            System.out.println("Error: Key length must be a perfect square (e.g., 4, 9, 16...)");
            sc.close();
            return;
        }

        // Convert key word to matrix
        int[][] keyMatrix = new int[n][n];
        int k = 0;
        System.out.println("\nKey Matrix (" + n + "x" + n + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                keyMatrix[i][j] = keyWord.charAt(k++) - 'A';
                System.out.print(keyMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Input plaintext
        System.out.print("\nEnter the Plaintext: ");
        String plaintext = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        // Pad plaintext
        int padding = n - (plaintext.length() % n);
        if (padding != n) {
            for (int i = 0; i < padding; i++) {
                plaintext += "X";
            }
        }

        System.out.println("\nProcessed Plaintext (padded if needed): " + plaintext);

        // Encrypt
        StringBuilder cipher = new StringBuilder();

        System.out.println("\nEncrypting Blocks:");
        for (int i = 0; i < plaintext.length(); i += n) {
            int[] block = new int[n];

            System.out.print("Block: ");
            for (int j = 0; j < n; j++) {
                block[j] = plaintext.charAt(i + j) - 'A';
                System.out.print(plaintext.charAt(i + j) + "(" + block[j] + ") ");
            }

            System.out.print("→ Cipher: ");
            for (int row = 0; row < n; row++) {
                int sum = 0;
                for (int col = 0; col < n; col++) {
                    sum += keyMatrix[row][col] * block[col];
                }
                int cipherVal = sum % 26;
                char cipherChar = (char) (cipherVal + 'A');
                cipher.append(cipherChar);
                System.out.print(cipherChar + "(" + cipherVal + ") ");
            }
            System.out.println();
        }

        // Output
        System.out.println("\nFinal Cipher Text: " + cipher.toString());
        sc.close();
    }
}
