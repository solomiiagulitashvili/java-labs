package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Ship {
    private double id = 10.4;
    private String name;
    private String captain;
    private String currentPort;
    private double maxSpeed;
    private double maxCapacity;
    private double currentLoad;

    public void dock(String port) {
        this.currentPort = port;
    }

    public void setSpeed(double speed) {
        this.maxSpeed = speed;
    }

    public void load(double weight) {
        if (this.currentLoad + weight < this.maxCapacity) {
            this.currentLoad = this.currentLoad + weight;
        }
    }

    public void unload(double weight) {
        if (this.currentLoad > 0 && this.currentLoad - weight > 0) {
            this.currentLoad = this.currentLoad - weight;
        } else {
            this.currentLoad = 0;
        }
    }
    private static Ship instance = new Ship();
    public static Ship getInstance() {
        return instance;
    }


    @Override
    public String toString() {
        return "Name:" + this.name + ";" + "captain:" + this.captain + ";" + "current port:" + this.currentPort + ";" + "max speed:" + this.maxSpeed + ";" + "max capacity:" + this.maxCapacity + ";" + "current load:" + this.currentLoad + ";";
    }

    public static void main(String... args) {
        Ship[] shipsArray;
        shipsArray = new Ship[4];
        Ship myShip = new Ship();
        Ship myAnotherShip = new Ship(12.1, "Balta", "Solomiia Gulitashvili", "Odesa", 13.6, 2096, 1073);
        shipsArray[0] = myShip;
        shipsArray[1] = myAnotherShip;
        Ship thirdShip = Ship.getInstance();
        Ship fourthShip = Ship.getInstance();
        shipsArray[2] = thirdShip;
        shipsArray[3] = fourthShip;

        for (int i = 0; i < shipsArray.length; i++) {
            System.out.println(shipsArray[i].id);
        }
    }
}


