package a;

public class Wing {
    private boolean isOpen;

    public void turnOnFlaps() {
        isOpen = true;
        System.out.println("Закрылки выпущены");
    }

    public void turnOffFlaps() {
        isOpen = false;
        System.out.println("Закрылки опущены");
    }

    @Override
    public String toString() {
        return "Wing{}";
    }
}
