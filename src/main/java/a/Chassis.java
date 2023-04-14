package a;

public class Chassis {

    private boolean isRaised;

    public void raiseChassis() {
        isRaised = true;
        System.out.println("Шасси подняты");
    }

    public void lowerTheLandingGear() {
        isRaised = false;
        System.out.println("Шасси опущены");
    }

    @Override
    public String toString() {
        return "Chassis{}";
    }
}
