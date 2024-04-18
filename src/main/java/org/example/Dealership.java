package org.example;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Dealership {
    int numOfCars;

//create array
    Car[] parkingSpots;
//constructor
    Dealership(){
         parkingSpots = new Car[10];
    }

    public void loadCarsFromFile() {
        Scanner input = new Scanner(Dealership.class.getClassLoader().getResourceAsStream("Cars.csv"));
        input.nextLine(); // skip header row
        while(input.hasNextLine()){
            String[] row = input.nextLine().split(",");
            Car car = new Car(row[0], Integer.parseInt(row[1]), row[2], row[3], Integer.parseInt(row[4]));
            add(car);
        }
    }

    /**
     * Adds a new car to the dealership
     * @param car the new car
     */
    public void add(Car car){
        // find an open parking spot to park in
        for(int i = 0; i < parkingSpots.length; i++){
            if(parkingSpots[i] == null){
                parkingSpots[i] = car;
                numOfCars++;
                return;
            }
        }
        // no parking spots available, add some
        addTenParkingSpots();
        add(car);
    }

    private void addTenParkingSpots() {
        Car[] newParkingSpots = new Car[parkingSpots.length + 10];
        for(int i = 0; i < parkingSpots.length; i++){
            newParkingSpots[i] = parkingSpots[i];
        }
        parkingSpots = newParkingSpots;
    }

    //buying the car
    public void purchase(int i){
        parkingSpots[i] = null;
        System.out.println("Enjoy your new car!");
    }
    //test drive the car
    public void testDrive(Car car){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < parkingSpots.length; i++){
            if(parkingSpots[i] == null){
                continue;
            }
            //checks if car is at dealership
            if(parkingSpots[i].getBrand().equals(car.getBrand()) && parkingSpots[i].getMileage()== car.getMileage() && parkingSpots[i].getColor().equals(car.getColor()) && parkingSpots[i].getType().equals(car.getType())){
                System.out.println("Have a good test drive!");
                parkingSpots[i].drive(10);
                System.out.println("Would you like to buy the car? It is $" + parkingSpots[i].getPrice());
                String val = scan.nextLine();
                if(val.equals("yes")||val.equals("Yes")){
                    purchase(i);
                }
                else{
                    System.out.println("Have a good day!");
                }
            }
        }

    }
    public void browse(){
        //prints array to show all cars
        for(int i = 0; i < parkingSpots.length; i++){
            if(parkingSpots[i] == null){
                continue;
            }
            System.out.printf("Car: %s, Price: $%d, Mileage: %d miles per tank, Color: %s, Type of Vehicle: %s \n", parkingSpots[i].getBrand(), parkingSpots[i].getPrice(), parkingSpots[i].getMileage(), parkingSpots[i].getColor(), parkingSpots[i].getType());
        }
    }

    public List<Car> browseByColor(String color){
        List<Car> results = new ArrayList<>();
        //prints array to show all cars
        for(int i = 0; i < parkingSpots.length; i++){
            if(parkingSpots[i] == null){
                continue;
            } else if(parkingSpots[i].getColor().equals(color)){
                results.add(parkingSpots[i]);
            }
        }
        return results;
    }
}

