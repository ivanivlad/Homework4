import carwash.Bus;
import carwash.Car;
import carwash.CarWash;
import carwash.CarWithCruiseControl;
import carwash.Machine;
import chat.OneGramChat;
import flight.Airplane;
import flight.Duck;
import flight.Fly;
import flight.FlyException;
import sounds.Bird;
import sounds.Builder;
import sounds.Driver;
import sounds.MakeSound;

public class Main {
    public static void main(String[] args) {
        ex1();
        System.out.println("--------------");
        ex2();
        System.out.println("--------------");
        ex3();
        System.out.println("--------------");
        ex4();
    }

    public static void ex1() {

        //Создаем и пачкаем машины
        Machine[] townCouncilMachines = new Machine[9];
        for (int i = 0; i < 4; i++) {
            townCouncilMachines[i] = new Car(5, 2, 1.8);
            townCouncilMachines[i].stain();
        }

        for (int i = 2; i < 4; i++) {
            townCouncilMachines[i] = new CarWithCruiseControl(5, 2, 1.8);
            townCouncilMachines[i].stain();
        }
        for (int i = 4; i < 9; i++) {
            townCouncilMachines[i] = new Bus(12, 3, 2.3, 20);
            townCouncilMachines[i].stain();
        }

        CarWash carWash = new CarWash();
        int totalCoast = carWash.wash(townCouncilMachines);
        System.out.printf("Your bill: %d rubles \n", totalCoast);

    }

    public static void ex2() {

        Fly[] pilotsGroup = new Fly[4];

        pilotsGroup[0] = new Duck();

        Duck injDuck = new Duck();
        injDuck.setInjured();
        pilotsGroup[1] = injDuck;

        Airplane air1 = new Airplane();
        air1.setCountPassengers(10);
        pilotsGroup[2] = air1;

        Airplane air2 = new Airplane();
        air2.setCountPassengers(-1);
        pilotsGroup[3] = air2;

        for (Fly pilot : pilotsGroup) {
            try {
                pilot.fly();
            } catch (FlyException e) {
                System.out.println("ошибка: " + e.getMessage());
            }

        }
    }

    public static void ex3() {
        MakeSound[] singers = new MakeSound[3];
        singers[0] = new Driver();
        singers[1] = new Builder();
        singers[2] = new Bird();

        for (MakeSound singer : singers) {
            System.out.println(singer.getSound());
        }
    }

    public static void ex4() {
        OneGramChat oneGramChat = new OneGramChat();
        oneGramChat.waitCommand();
    }
}