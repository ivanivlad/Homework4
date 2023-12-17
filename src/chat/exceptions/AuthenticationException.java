package chat.exceptions;

public class AuthenticationException extends OneGramChatException {
    @Override
    public String getMessage() {
        return "Ошибка: неправильно указаны логин или пароль. Попробуйте еще раз";
    }
}
