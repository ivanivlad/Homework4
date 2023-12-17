package chat;

import chat.exceptions.OneGramChatException;
import chat.exceptions.OutOfMaxMessagesException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
    private static final int MAX_NUM_OF_MESSAGES = 100;

    private final String name;
    private String hashPassword;
    private final Message[] messages;
    private int indexOfNewMessage;

    public User(String name, String password) {
        try {
            this.hashPassword = getHash(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        this.name = name;
        this.messages = new Message[MAX_NUM_OF_MESSAGES];
    }

    public String getLogin() {
        return name;
    }

    public boolean isAuthenticate(String password) {
        try {
            return getHash(password).equals(hashPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String getHash(String password) throws NoSuchAlgorithmException {

        // Создаем объект MessageDigest с использованием алгоритма SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Преобразуем пароль в байтовый массив и вычисляем хэш-значение
        byte[] hash = md.digest(password.getBytes());

        // Кодируем хэш-значение в Base64
        return Base64.getEncoder().encodeToString(hash);
    }

    public void addIncomeMessage(User destinationUser, String text) throws OneGramChatException {
        if (MAX_NUM_OF_MESSAGES == indexOfNewMessage) {
            throw new OutOfMaxMessagesException();
        }
        messages[indexOfNewMessage] = new IncomeMessage(destinationUser, text);
        indexOfNewMessage++;
    }

    public void addOutcomeMessage(User destinationUser, String text) throws OneGramChatException {
        if (MAX_NUM_OF_MESSAGES == indexOfNewMessage) {
            throw new OutOfMaxMessagesException();
        }
        messages[indexOfNewMessage++] = new OutcomeMessage(destinationUser, text);
    }

    public void printAllMessages() {
        if (indexOfNewMessage == 0) {
            System.out.println("У пользователя нет сообщений");
            return;
        }

        System.out.println("Ваши письма " + this + ":");
        for (int i = 0; i < indexOfNewMessage; i++) {
            System.out.println(messages[i]);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
