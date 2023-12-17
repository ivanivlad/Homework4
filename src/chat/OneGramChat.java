package chat;

import chat.exceptions.AuthenticationException;
import chat.exceptions.EmptyCurrentUserException;
import chat.exceptions.NoSuchUserException;
import chat.exceptions.OneGramChatException;
import chat.exceptions.OutOfMaxUsersException;
import java.util.Scanner;

public class OneGramChat {

    private static final int MAX_NUM_OF_USERS = 100;
    private static final  Scanner scanner = new Scanner(System.in);

    private User currentUser;
    private final User[] users;
    private int indexOfNewUser;

    public OneGramChat() {
        users = new User[MAX_NUM_OF_USERS];
    }

    public void waitCommand() {
        System.out.println("Приветсвуем вас в OneGramChat");

        printInstruction();
        System.out.println("Введите команду:");

        while (true) {
            if (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                try {
                    executeCommand(command);
                } catch (OneGramChatException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Введите команду:");
            }
        }
    }

    private void executeCommand(String command) throws OneGramChatException {
        switch (command) {
            case "новый" -> createUser();
            case "войти" -> loginUser();
            case "выйти" -> logoutUser();
            case "написать" -> writeMessage();
            case "прочитать" -> readAllMessageOfCurrentUser();
            case "exit" -> System.exit(0);
            default -> {
                System.out.println("Ошибка: неправильная команда");
                printInstruction();
            }
        }
    }

    private void createUser() throws OneGramChatException {

        if (MAX_NUM_OF_USERS == indexOfNewUser) {
            throw new OutOfMaxUsersException();
        }

        System.out.println("Регистрация");
        System.out.print("Введите логин:");
        String login = scanner.nextLine();

        if (login.isEmpty()) {
            return;
        }

        if (loginExist(login)) {
            System.out.println("Логин уже занят. Попробуйте другой");
            return;
        }

        System.out.print("Введите пароль:");
        String password = scanner.nextLine();
        System.out.print('\n');

        currentUser = new User(login, password);
        users[indexOfNewUser] = currentUser;
        indexOfNewUser++;
    }

    private boolean loginExist(String login) {
        try {
            getUser(login);
            return true;
        } catch (NoSuchUserException e) {
            return false;
        }
    }

    private void loginUser() throws OneGramChatException {

        System.out.print("Введите логин:");
        String login = scanner.nextLine();
        System.out.print("Введите пароль:");
        String password = scanner.nextLine();

        User checkedUser = getUser(login);

        if (checkedUser.isAuthenticate(password)) {
            currentUser = checkedUser;
            System.out.print('\n');
            System.out.println("Рады снова вас видеть!");
        } else {
            throw new AuthenticationException();
        }
    }

    private void logoutUser() {
        currentUser = null;
        System.out.println("Вы вышли. Возвращайтесь!");
    }

    private void writeMessage() throws OneGramChatException {

        if (currentUser == null) {
            throw new EmptyCurrentUserException();
        }

        System.out.println("Новое сообщение");
        System.out.print("кому:");
        String destination = scanner.nextLine();

        User destinationUser = getUser(destination);

        System.out.println("сообщение:");
        String text = scanner.nextLine();
        System.out.print('\n');

        currentUser.addOutcomeMessage(destinationUser, text);
        destinationUser.addIncomeMessage(currentUser, text);

    }

    private User getUser(String login) throws NoSuchUserException {
        for (int i = 0; i < indexOfNewUser; i++) {
            if (users[i].getLogin().equals(login)) {
                return users[i];
            }
        }
        throw new NoSuchUserException();
    }

    private void readAllMessageOfCurrentUser() throws EmptyCurrentUserException {
        if (currentUser == null) {
            throw new EmptyCurrentUserException();
        }
        currentUser.printAllMessages();
    }

    private void printInstruction() {
        System.out.println("""
                Доступны команды:
                "войти" - запуск функции "войти пользователю"
                "новый" - запуск функции "создать пользователя"
                "выйти" - запуск функции "выйти пользователю"
                "написать" - запуск функции "написать письмо"
                "прочитать" - запуск функции "прочитать письма"
                "exit" - окончание работы программы""");
    }
}
