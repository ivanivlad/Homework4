package flight;

public class Duck implements Fly {
    private boolean isInjured;

    @Override
    public void fly() throws FlyException {
        if (isInjured) {
            throw new FlyException("утка ранена");
        }
        System.out.println("утка летит");
    }

    public void setInjured() {
        isInjured = true;
    }
}
