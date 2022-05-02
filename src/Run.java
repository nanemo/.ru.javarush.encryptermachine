import java.util.Scanner;

public class Run {

    public static String srcAddress;
    public static String cipherAddress;
    public static String dstAddress;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cipher cipherCaller = new Cipher();

        System.out.println("Please enter source address:");
        srcAddress = scanner.nextLine();
        System.out.println("Please enter address for ciphing:");
        cipherAddress = scanner.nextLine();
        System.out.println("Please enter destination address:");
        dstAddress = scanner.nextLine();

        System.out.println("Please enter key:");
        int key = scanner.nextInt();

        boolean proses = true;

        while (proses) {
            System.out.println(Menu.getMenu());
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Шифровка начелось");
                    cipherCaller.cipher(srcAddress, cipherAddress, key);
                    break;
                case 2:
                    System.out.println("Расшифровка начелось");
                    cipherCaller.deCoder(cipherAddress, dstAddress, key);
                    break;
                case 3:
                    System.out.println("Взлом шифра начелось");
                    cipherCaller.bruteForce(cipherAddress, dstAddress, key);
                    break;
                case 4:
                    System.out.println("Система выключена");
                    proses = false;
                    break;
                default:
                    System.out.println("Выберите правилный вариант");
                    break;
            }
        }
    }
}
