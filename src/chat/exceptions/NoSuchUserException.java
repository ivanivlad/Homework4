package chat.exceptions;

public class NoSuchUserException extends OneGramChatException {
    @Override
    public String getMessage() {
        return "Ошибка: пользователя с таким именем нет в системе."
                + " Уточните имя пользователя и попробуйте еще раз";
    }
}
