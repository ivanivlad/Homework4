package carwash;

public abstract class Machine implements Washable {
    private final double height;
    private final double width;
    private final double length;
    private boolean muddy;

    public Machine(double length, double height, double width) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.muddy = false;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }


    public boolean isMuddy() {
        return muddy;
    }

    public void stain() {
        this.muddy = true;
    }

    @Override
    public void wash() {
        this.muddy = false;
    }
}
