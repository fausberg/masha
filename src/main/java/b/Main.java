package b;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ElectricApplianceList list = new ElectricApplianceList();

            Lamp lamp1 = new Lamp("Living Room Lamp", 60);
            Lamp lamp2 = new Lamp("Bedroom Lamp", 40);
            TV tv1 = new TV("Living Room TV", 100);
            TV tv2 = new TV("Bedroom TV", 80);

            list.add(lamp1);
            list.add(lamp2);
            list.add(tv1);
            list.add(tv2);

            list.turnOnAll();
            System.out.println("Total power consumption: " + list.getTotalPower() + " watts");
            System.out.println("Sorted by power: " + list.sortByPower());
            System.out.println("Appliances with power between 50 and 100 watts: " + list.findByPowerRange(50, 100));

            list.turnOffAll();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
