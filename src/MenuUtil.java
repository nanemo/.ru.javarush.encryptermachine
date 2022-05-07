import java.util.Scanner;

import static java.lang.System.*;

public class MenuUtil {
    Scanner scanner = new Scanner(System.in);
    Cipher cipherCaller = new Cipher();
    boolean proses = true;

    public void menu(){
        while (proses) {
            out.println(Menu.getShowMenu());
            switch (scanner.nextInt()) {
                case 1:
                    out.println("Encrypting started");
                    cipherCaller.cipher();
                    out.println("Encrypting finished");
                    break;
                case 2:
                    out.println("Decrypting started");
                    cipherCaller.deCoder();
                    out.println("Decrypting finished");
                    break;
                case 3:
                    out.println("Analysing started");
                    cipherCaller.bruteForce();
                    break;
                case 4:
                    out.println("System closed");
                    proses = false;
                    break;
                default:
                    out.println("Choose correct function");
                    break;
            }
        }
    }
}
