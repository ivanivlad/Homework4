package chat.exceptions;

public class EmptyCurrentUserException extends OneGramChatException {
    @Override
    public String getMessage() {
        return "Ошибка: сначала нужно 'войти' в приложение";
    }
}
