package a;

import java.util.Objects;

public class Plane {
    private Wing wing;
    private Chassis chassis;
    private Engine engine;
    private String route;

    public Plane(Wing wing, Chassis chassis, Engine engine) {
        this.wing = wing;
        this.chassis = chassis;
        this.engine = engine;
    }

    public void fly() {
        System.out.println("The plane is flying.");
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String printRoute() {
        return this.route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (!Objects.equals(wing, plane.wing)) return false;
        if (!Objects.equals(chassis, plane.chassis)) return false;
        if (!Objects.equals(engine, plane.engine)) return false;
        return Objects.equals(route, plane.route);
    }

    @Override
    public int hashCode() {
        int result = wing != null ? wing.hashCode() : 0;
        result = 31 * result + (chassis != null ? chassis.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (route != null ? route.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "wing=" + wing +
                ", chassis=" + chassis +
                ", engine=" + engine +
                ", route='" + route + '\'' +
                '}';
    }
}

