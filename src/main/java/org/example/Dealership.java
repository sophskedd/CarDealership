package org.example;
import java.util.Scanner;
public class Dealership {
    int numOfCars;

//create array
    Cars []arr = new Cars[100];
//constructor
    Dealership(){
    }
    //obtain cars
    public void obtainCar(Cars car){
        for(int i = 0; i < arr.length; i++){
            if(arr[0] == null){
                arr[0] = car;
                break;
            }
            else if(arr[i] != null && arr[i+1] == null){
                arr[i+1] = car;
                break;
            }
            else{
                System.out.print("Dealership is full.");
            }
        }
    }
    //buying the car
    public void purchase(int i){
        arr[i] = null;
        System.out.println("Enjoy your new car!");
    }
    //test drive the car
    public void testDrive(Cars car){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null){
                continue;
            }
            //checks if car is at dealership
            if(arr[i].getBrand().equals(car.getBrand()) && arr[i].getMileage()== car.getMileage() && arr[i].getColor().equals(car.getColor()) && arr[i].getType().equals(car.getType())){
                System.out.println("Have a good test drive!");
                arr[i].drive(10);
                System.out.println("Would you like to buy the car? It is $" + arr[i].getPrice());
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
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null){
                continue;
            }
            System.out.printf("Car: %s, Price: $%d, Mileage: %d miles per tank, Color: %s, Type of Vehicle: %s \n",arr[i].getBrand(),arr[i].getPrice(),arr[i].getMileage(),arr[i].getColor(),arr[i].getType());
        }
    }
}

