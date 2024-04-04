package org.example;

public class Main {
    public static void main(String[] args) {

        Dealership sd = new Dealership();
        Cars car1 = new Cars("Honda", 400, "White", "Sedan", 30000);

        sd.obtainCar(car1);

        sd.browse();
        sd.testDrive(car1);

        sd.browse();

        for(Cars whiteCars: sd.browseByColor("Black")) {
            System.out.println(whiteCars);
        }
    }
}