package carwash;

public class CarWash {

    private static final int LARGE_TARIFF = 4_000;
    private static final int SMALL_TARIFF = 2_000;
    private static final double MAX_HEIGHT = 2.5;
    private static final int MAX_LENGTH = 6;
    private static final int MAX_WIDTH = 2;

    public int wash(Machine machine) {
        machine.wash();
        return getTariff(machine);
    }

    public int wash(Machine[] machines) {
        int amount = 0;

        for (Machine machine : machines) {
            machine.wash();
            amount += getTariff(machine);
        }
        return amount;
    }

    private int getTariff(Machine machine) {
        if (machine.getLength() > MAX_LENGTH
                || machine.getHeight() > MAX_HEIGHT
                || machine.getWidth() > MAX_WIDTH) {
            return LARGE_TARIFF;
        } else {
            return SMALL_TARIFF;
        }
    }

}
