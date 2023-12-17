package sounds;

public abstract class Man implements MakeSound {
    @Override
    public String getSound() {
        return "Я человек.";
    }
}
