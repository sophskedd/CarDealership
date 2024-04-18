package org.example;

public class Main {
    public static void main(String[] args) {

        Dealership sd = new Dealership();
        Car car1 = new Car("Honda", 400, "White", "Sedan", 30000);

        sd.add(car1);

        sd.browse();
        sd.testDrive(car1);

        sd.browse();

        for(Car whiteCars: sd.browseByColor("Black")) {
            System.out.println(whiteCars);
        }
    }
}