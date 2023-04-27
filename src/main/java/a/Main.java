package a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        try {
            Wing wing = new Wing();
            Chassis chassis = new Chassis();
            Engine engine = new Engine();

            Plane plane = new Plane(wing, chassis, engine);

            String command;

            while (true) {
                System.out.println("Установите маршрут (его надо написать)");
                command = new Scanner(System.in).nextLine();
                plane.setRoute(command);
                System.out.println("Здравствуйте уважаемы поссажиры на самолет будет лететь по маршруту " + plane.printRoute());
                System.out.println("Завести двигатель?");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    engine.TurnOnEngine();
                } else {
                    engine.TurnOffEngine();
                    System.out.println("мы так далеко не улетим");
                    break;
                }
                System.out.println("при взлёте необходимо открыть закрылки, хотите их открыть?");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    wing.turnOnFlaps();
                } else {
                    wing.turnOffFlaps();
                    System.out.println("при попытке взлететь вы не смогли набрать высоту и разбились об забор");
                    break;
                }
                Thread.sleep(2000);
                System.out.println("самолет набрал высоту, хотите закрыть шасси");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    chassis.raiseChassis();
                } else {
                    chassis.lowerTheLandingGear();
                    System.out.println("из-за открытых шасси самолёт летел плохо, но всё обошлось");
                }
                Thread.sleep(5000);
                System.out.println("мы приближаемся к месту назначения, открыть шасси?");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    chassis.lowerTheLandingGear();
                } else {
                    chassis.raiseChassis();
                    System.out.println("Вы не сумели приземлится, самолёт разбился");
                    break;
                }
                System.out.println("Уважаемые пассажиры мы успешно приземлились, самолёт пилотировала Мария Быцко(наш лучший пилот)");
                System.out.println("Когда самолёт стоит нужно закрыть закрылки. Закрыть закрылки");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    wing.turnOffFlaps();
                    System.out.println("Следующий рейс через 30 минут");
                } else {
                    wing.turnOnFlaps();
                    System.out.println("Зачем вы портите самолёт?");
                }
                Thread.sleep(5000);

            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
