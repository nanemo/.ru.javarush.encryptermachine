import java.util.Scanner;

public class Run {

    public static String srcAddress = "C:\\Users\\nnbak\\Desktop\\Test1.txt";
    public static String cipherAddress = "C:\\Users\\nnbak\\Desktop\\Test2.txt";
    public static String dstAddress = "C:\\Users\\nnbak\\Desktop\\Test3.txt";
    private static int key;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cipher cipherCaller = new Cipher();

//        System.out.println("Please enter source address:");
//        srcAddress = scanner.nextLine();
//        System.out.println("Please enter address for cipher:");
//        cipherAddress = scanner.nextLine();
//        System.out.println("Please enter destination address:");
//        dstAddress = scanner.nextLine();

        System.out.println("Please enter key:");
        key = scanner.nextInt();

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
                    System.out.println("Анализатор включен");
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
