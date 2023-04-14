package b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ElectricApplianceList {
    private List<ElectricAppliance> appliances;

    public ElectricApplianceList(List<ElectricAppliance> appliances) {
        this.appliances = appliances;
    }

    public ElectricApplianceList() {
        appliances = new ArrayList<>();
    }

    public void add(ElectricAppliance appliance) {
        appliances.add(appliance);
    }

    public void turnOnAll() {
        for (ElectricAppliance appliance : appliances) {
            appliance.turnOn();
        }
    }

    public void turnOffAll() {
        for (ElectricAppliance appliance : appliances) {
            if (appliance instanceof Lamp) {
                ((Lamp) appliance).turnOff();
            } else if (appliance instanceof TV) {
                ((TV) appliance).turnOff();
            }
        }
    }

    public double getTotalPower() {
        double totalPower = 0;
        for (ElectricAppliance appliance : appliances) {
            totalPower += appliance.getPower();
        }
        return totalPower;
    }

    public List<ElectricAppliance> sortByPower() {
        List<ElectricAppliance> sorted = new ArrayList<>(appliances);
        Collections.sort(sorted, new Comparator<ElectricAppliance>() {
            public int compare(ElectricAppliance a1, ElectricAppliance a2) {
                return Double.compare(a1.getPower(), a2.getPower());
            }
        });
        return sorted;
    }

    public List<ElectricAppliance> findByPowerRange(double minPower, double maxPower) {
        List<ElectricAppliance> appliancesInRange = new ArrayList<>();

        for (ElectricAppliance appliance : appliances) {
            if (appliance.getPower() >= minPower && appliance.getPower() <= maxPower) {
                appliancesInRange.add(appliance);
            }
        }

        return appliancesInRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElectricApplianceList that = (ElectricApplianceList) o;

        return Objects.equals(appliances, that.appliances);
    }

    @Override
    public int hashCode() {
        return appliances != null ? appliances.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ElectricApplianceList{" +
                "appliances=" + appliances +
                '}';
    }
}