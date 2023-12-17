package sounds;

public class Builder extends Man {
    @Override
    public String getSound() {
        return "Я строитель." + super.getSound();
    }
}
