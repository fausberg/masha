package a;

import lab_5_c.MemoryAllocationException;

import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, MemoryAllocationException {
        try {
            Writer writer = new Writer();
            Wing wing = new Wing();
            Chassis chassis = new Chassis();
            Engine engine = new Engine();

            Plane plane = new Plane(wing, chassis, engine);

            String command;

            while (true) {
                System.out.println("Установите маршрут (его надо написать)");
                command = new Scanner(System.in).nextLine();
                plane.setRoute(command);
                writer.fileWriter("Здравствуйте уважаемы поссажиры на самолет будет лететь по маршруту " + plane.printRoute());
                System.out.println("Завести двигатель?");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    engine.TurnOnEngine();
                } else {
                    engine.TurnOffEngine();
                    writer.fileWriter("мы так далеко не улетим");
                    break;
                }
                System.out.println("при взлёте необходимо открыть закрылки, хотите их открыть?");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    wing.turnOnFlaps();
                } else {
                    wing.turnOffFlaps();
                    writer.fileWriter("при попытке взлететь вы не смогли набрать высоту и разбились об забор");
                    break;
                }
                Thread.sleep(2000);
                System.out.println("самолет набрал высоту, хотите закрыть шасси");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    chassis.raiseChassis();
                } else {
                    chassis.lowerTheLandingGear();
                    writer.fileWriter("из-за открытых шасси самолёт летел плохо, но всё обошлось");
                }
                Thread.sleep(5000);
                System.out.println("мы приближаемся к месту назначения, открыть шасси?");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    chassis.lowerTheLandingGear();
                } else {
                    chassis.raiseChassis();
                    writer.fileWriter("Вы не сумели приземлится, самолёт разбился");
                    break;
                }
                writer.fileWriter("Уважаемые пассажиры мы успешно приземлились, самолёт пилотировала Мария Быцко(наш лучший пилот)");
                System.out.println("Когда самолёт стоит нужно закрыть закрылки. Закрыть закрылки");
                command = new Scanner(System.in).nextLine();
                if (command.equals("да")) {
                    wing.turnOffFlaps();
                    writer.fileWriter("Следующий рейс через 30 минут");
                } else {
                    wing.turnOnFlaps();
                    writer.fileWriter("Зачем вы портите самолёт?");
                }
                Thread.sleep(5000);

            }
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (OutOfMemoryError e) {
            throw new MemoryAllocationException("Not enough memory to read file: a.txt");
        }
    }
}
