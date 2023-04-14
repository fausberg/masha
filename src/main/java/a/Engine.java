package a;

public class Engine {
    private boolean isWoundUp;

    public void TurnOnEngine() {
        isWoundUp = true;
        System.out.println("Двигатель заведён");
    }

    public void TurnOffEngine() {
        isWoundUp = false;
        System.out.println("Двигатель заглушен");
    }

    @Override
    public String toString() {
        return "Engine{}";
    }
}
