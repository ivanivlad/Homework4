package chat;

public abstract class Message {
    private final String text;
    private final User destination;

    public Message(User destination, String text) {
        this.text = text;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return destination
                + ": "
                + text;
    }
}
