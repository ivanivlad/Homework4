package chat;

public class IncomeMessage extends Message {
    public IncomeMessage(User destination, String text) {
        super(destination, text);
    }

    @Override
    public String toString() {
        return
                "Письмо от "
                + super.toString();
    }
}
