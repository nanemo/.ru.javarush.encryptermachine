public class Menu {

    private static String menu = "Выберите функцию:" +
            "\n1. Шифровать" +
            "\n2. Расшифровать" +
            "\n3. Анализатор" +
            "\n4. Выйти";
    private static String login = "Наберите пароль что бы войти в систему: ";

    public static String getMenu() {
        return menu;
    }

    public static String getLogin() {
        return login;
    }
}
