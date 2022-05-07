public class Menu {

    private Menu(){}

    private static String showMenu = "Choose function:" +
            "\n1. Encryption" +
            "\n2. Decryption" +
            "\n3. Analysing" +
            "\n4. Exit";
    private static String login = "Enter password: ";

    private static String bruteForceMenu = "Choose direction for moving" +
            "\n - 1 - to right" +
            "\n - 2 - to left" +
            "\n - 3 - for exit";


    public static String getShowMenu() {
        return showMenu;
    }

    public static String getLogin() {
        return login;
    }

    public static String getBruteForceMenu() {
        return bruteForceMenu;
    }
}
