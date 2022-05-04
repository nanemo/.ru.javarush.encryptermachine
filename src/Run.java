import java.util.Scanner;

public class Run {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cipher cipherCaller = new Cipher();
        boolean proses = true;

        while (proses) {
            System.out.println(Menu.getMenu());
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Encrypting started");
                    cipherCaller.cipher();
                    System.out.println("Encrypting finished");
                    break;
                case 2:
                    System.out.println("Decrypting started");
                    cipherCaller.deCoder();
                    System.out.println("Decrypting finished");
                    break;
                case 3:
                    System.out.println("Analysing started");
                    cipherCaller.bruteForce();
                    break;
                case 4:
                    System.out.println("System closed");
                    proses = false;
                    break;
                default:
                    System.out.println("Choose correct function");
                    break;
            }
        }
    }
}
