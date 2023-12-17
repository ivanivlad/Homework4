package chat;

public class OutcomeMessage extends Message {
    public OutcomeMessage(User destination, String text) {
        super(destination, text);
    }

    @Override
    public String toString() {
        return "Письмо к "
                + super.toString();
    }
}
