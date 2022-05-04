import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cipher {

    private static int minChar = 1040;
    private static int maxChar = 1104;

    Addresses addresses = new Addresses();
    private static List<Character> marks = Arrays.asList('.', ',', '"', ':', '-', '!', '?', ' ');

    public void cipher() {
        String srcAddress = addresses.getSrcAddress();
        String dstAddress = addresses.getDstAddress();
        int key = addresses.getKey();

        String message = FileReaderAndWriter.readerByte(srcAddress);

        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (marks.contains(character)) {
                int marksIndex = marks.indexOf(character);
                marksIndex = marksIndex + key;
                if (marksIndex > (marks.size() - 1)) {
                    int marksNewIndex = marksIndex - (marks.size() - 1);
                    result.append(marks.get(marksNewIndex - 1));
                } else {
                    result.append(marks.get(marksIndex));
                }
            } else if (character != ' ') {
                if (((int) character) >= minChar && ((int) character <= maxChar)) {
                    int hideCharNum = (int) character + key;
                    if (hideCharNum > maxChar) {
                        hideCharNum = (hideCharNum - maxChar) + minChar;
                    }
                    result.append((char) hideCharNum);
                }
            }
        }
        System.out.println("Encryption text is - " + result.toString());
        FileReaderAndWriter.writerByte(dstAddress, result.toString());
    }

    public void deCoder() {
        String cipherAddress = addresses.getCipherAddress();
        String message = FileReaderAndWriter.readerByte(cipherAddress);
        int key = addresses.getKey();

        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (marks.contains(character)) {
                int marksIndex = marks.indexOf(character);
                marksIndex = marksIndex - key;
                if (marksIndex < 0) {
                    int marksNewIndex = marks.size() + marksIndex;
                    result.append(marks.get(marksNewIndex));
                } else {
                    result.append(marks.get(marksIndex));
                }
            } else if (((int) character) >= minChar && ((int) character <= maxChar)) {
                int hideCharNum = (int) character - key;
                if (hideCharNum < minChar) {
                    hideCharNum = maxChar - (minChar - hideCharNum);
                }
                result.append((char) hideCharNum);
            }
        }
        System.out.println("Encrypting text is - " + result.toString());
        FileReaderAndWriter.writerByte(addresses.getDstAddress(), result.toString());
    }

    public void bruteForce() {
        Scanner scanner = new Scanner(System.in);
        boolean proses = true;
        while (proses) {
            System.out.println(Menu.getBruteForceMenu());
            int movingKey = scanner.nextInt();
            switch (movingKey) {
                case 1:
                    System.out.println("You started moving alphabet to right - ");
                    cipher();
                    break;
                case 2:
                    System.out.println("You started moving alphabet to left - ");
                    deCoder();
                    break;
                case 3:
                    System.out.println("You exited from analysing");
                    proses = false;
                    break;
                default:
                    System.out.println("Choose correct function");
            }
        }
    }
}

