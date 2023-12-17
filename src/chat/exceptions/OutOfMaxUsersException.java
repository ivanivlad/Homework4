package chat.exceptions;

public class OutOfMaxUsersException extends OneGramChatException {
    @Override
    public String getMessage() {
        return "Ошибка: превышено возможное количество пользователей. Обратитесь к администратору";
    }
}
