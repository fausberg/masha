package b;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ElectricApplianceListTest {

    @Test
    public void testTurnOnAll() {
        Lamp lamp1 = new Lamp();
        Lamp lamp2 = new Lamp();
        TV tv1 = new TV();
        TV tv2 = new TV();

        ElectricAppliance[] appliances = {lamp1, lamp2, tv1};

        for (ElectricAppliance appliance : appliances) {
            appliance.turnOff();
        }

        ElectricApplianceList manager = new ElectricApplianceList(List.of(appliances));
        manager.turnOnAll();

        Assert.assertTrue(lamp1.isOn());
        Assert.assertTrue(lamp2.isOn());
        Assert.assertTrue(tv1.isOn());
    }

    @Test
    public void testTurnOffAll() {
        Lamp lamp1 = new Lamp();
        Lamp lamp2 = new Lamp();
        TV tv1 = new TV();

        ElectricAppliance[] appliances = {lamp1, lamp2, tv1};

        for (ElectricAppliance appliance : appliances) {
            appliance.turnOn();
        }

        ElectricApplianceList manager = new ElectricApplianceList(List.of(appliances));
        manager.turnOffAll();

        Assert.assertFalse(lamp1.isOn());
        Assert.assertFalse(lamp2.isOn());
        Assert.assertFalse(tv1.isOn());
    }

    @Test
    public void testGetTotalPower() {
        Lamp lamp1 = new Lamp(100);
        Lamp lamp2 = new Lamp(50);
        TV tv1 = new TV(200);

        ElectricAppliance[] appliances = {lamp1, lamp2, tv1};

        ElectricApplianceList manager = new ElectricApplianceList(List.of(appliances));

        double expectedTotalPower = 350; // 100 + 50 + 200
        double actualTotalPower = manager.getTotalPower();
        Assert.assertEquals(actualTotalPower, expectedTotalPower);
    }

    @Test
    public void testSortByPower() {
        Lamp lamp1 = new Lamp(100);
        Lamp lamp2 = new Lamp(50);
        TV tv1 = new TV(200);

        ElectricAppliance[] appliances = {lamp1, lamp2, tv1};

        ElectricApplianceList manager = new ElectricApplianceList(List.of(appliances));

        List<ElectricAppliance> sorted = manager.sortByPower();

        Assert.assertEquals(sorted.size(), 3);
        Assert.assertEquals(sorted.get(0), lamp2);
        Assert.assertEquals(sorted.get(1), lamp1);
        Assert.assertEquals(sorted.get(2), tv1);
    }

    @Test
    public void testFindByPowerRange() {
        Lamp lamp1 = new Lamp(100);
        Lamp lamp2 = new Lamp(50);
        TV tv1 = new TV(200);

        ElectricAppliance[] appliances = {lamp1, lamp2, tv1};

        ElectricApplianceList manager = new ElectricApplianceList(List.of(appliances));

        double minPower = 75;
        double maxPower = 225;
        List<ElectricAppliance> appliancesInRange = manager.findByPowerRange(minPower, maxPower);

        Assert.assertEquals(appliancesInRange.size(), 2);
        Assert.assertTrue(appliancesInRange.contains(lamp1));
        Assert.assertTrue(appliancesInRange.contains(tv1));
    }
}