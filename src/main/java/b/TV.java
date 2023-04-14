package b;

public class TV extends ElectricAppliance {
    private boolean isOn;
    private int channel;

    public TV(String name, double power) {
        super(name, power);
    }

    public TV(double power) {
        super(power);
    }

    public TV() {
    }

    public void turnOn() {
        isOn = true;
        channel = 1;
        System.out.println(getName() + " is turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(getName() + " is turned off.");
    }

    public void setChannel(int channel) {
        if (isOn) {
            this.channel = channel;
            System.out.println(getName() + " is set to channel " + channel);
        } else {
            System.out.println(getName() + " is not turned on.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TV tv = (TV) o;

        if (isOn != tv.isOn) return false;
        return channel == tv.channel;
    }

    @Override
    public int hashCode() {
        int result = (isOn ? 1 : 0);
        result = 31 * result + channel;
        return result;
    }

    @Override
    public String toString() {
        return "TV{" +
                "isOn=" + isOn +
                ", channel=" + channel +
                '}';
    }

    public boolean isOn() {
        return isOn;
    }
}
