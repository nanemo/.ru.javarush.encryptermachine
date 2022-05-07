import java.util.Scanner;

import static java.lang.System.*;
public class Addresses {



    public String getSrcAddress() {
        Scanner scanner = new Scanner(in);
        out.println("Please enter source address:");
        return scanner.nextLine();
    }

    public String getCipherAddress() {
        Scanner scanner = new Scanner(in);
        out.println("Please enter address for ciphing:");
        return scanner.nextLine();
    }

    public String getDstAddress() {
        Scanner scanner = new Scanner(in);
        out.println("Please enter destination address:");
        return scanner.nextLine();
    }

    public int getKey() {
        Scanner scanner = new Scanner(in);
        out.println("Please enter key:");
        return scanner.nextInt();
    }
}
