package carwash;

public class Bus extends Machine {
    private final int numOfPlaces;

    public Bus(double length, double height, double width, int numOfPlaces) {
        super(length, height, width);
        this.numOfPlaces = numOfPlaces;
    }

}
