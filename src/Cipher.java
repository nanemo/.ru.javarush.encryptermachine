import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cipher {

    private static int minChar = 1040;
    private static int maxChar = 1104;

    private static List<Character> marks = Arrays.asList('.', ',', '"', ':', '-', '!', '?', ' ');

    public void cipher(String srcAddress, String dstAddress, int key) {

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
        FileReaderAndWriter.writerByte(dstAddress, result.toString());
    }

    public void deCoder(String cipherAddress, String dstAddress, int key) {
        String message = FileReaderAndWriter.readerByte(cipherAddress);

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
        FileReaderAndWriter.writerByte(dstAddress, result.toString());
    }

    public void bruteForce(String cipherAddress, String dstAddress, int key) {
        Scanner scanner = new Scanner(System.in);
        boolean proses = true;
        int movingKey = scanner.nextInt();
        while (proses) {
            switch (movingKey) {
                case 1:
                    System.out.println("Вы начели проверку перемешая буквы в правую сторону, количество шага будет - " + key);
                    cipher(cipherAddress, dstAddress, key);
                    break;
                case 2:
                    deCoder(cipherAddress, dstAddress, key);
                    System.out.println("Вы начели проверку перемешая буквы в левую сторону, количество шага будет - " + key);
                    break;
                case 3:
                    System.out.println("Вы вышли из метода взлома шифра.");
                    proses = false;
                    break;
                default:
                    System.out.println("Выберите правильный вариант");
            }
        }
    }
}

