package chat.exceptions;

public class OutOfMaxMessagesException extends OneGramChatException {
    @Override
    public String getMessage() {
        return "Ошибка: превышен лимит сообщений. Обратитесь к администратору";
    }
}
