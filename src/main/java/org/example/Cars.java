package org.example;


public class Cars {
    private int price = 50000;
    private int mileage = 0;//how many miles on a full tank
    private String color = "";
    private String brand = "";
    private String type = ""; //suv or sedan
    private int totalMiles = 0;

    double gas = 0;
    Cars() {
    }
    Cars(String brand, int mileage, String color, String type, int price){
        this.price = price;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
        this.type = type;
    }

    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    //setter
    public void setMileage(int mileage){
        this.mileage = mileage;
        gas = mileage;
    }
    //getter
    public int getMileage(){
        return mileage;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setTotalMiles(int totalMiles){
        this.totalMiles = totalMiles;
    }

    public int getTotalMiles(){
        return totalMiles;
    }
    //driving said distance
    public void drive(int distance){
        totalMiles += distance;
        gasTank(distance);
    }

    public String horn(){
        return " HONK!!!!";
    }
    //how much gas left in tank
    public void gasTank(int miles){
        gas -= miles;
    }


}

