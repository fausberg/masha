package b;

public class Lamp extends ElectricAppliance{
    private boolean isOn;

    public Lamp(String name, double power) {
        super(name, power);
    }

    public Lamp(double power) {
        super(power);
    }

    public void turnOn() {
        isOn = true;
        System.out.println(getName() + " is turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(getName() + " is turned off.");
    }

    public Lamp() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lamp lamp = (Lamp) o;

        return isOn == lamp.isOn;
    }

    @Override
    public int hashCode() {
        return (isOn ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Lamp{" +
                "isOn=" + isOn +
                '}';
    }

    public boolean isOn() {
        return isOn;
    }
}
