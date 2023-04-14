package b;

public abstract class ElectricAppliance {
    private String name;
    private double power;

    public ElectricAppliance(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public ElectricAppliance(double power) {
        this.power = power;
    }

    protected ElectricAppliance() {
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}

