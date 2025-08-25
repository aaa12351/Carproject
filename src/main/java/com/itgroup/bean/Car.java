package com.itgroup.bean;

public class Car {
    private int car_no  ;
    private String brand ;
    private String car_model ;
    private String release_date ;
    private String color ;
    private String car_type ;
    private String engine_type ;
    private int fuel_efficiency ;
    private int price ;
    private int maxprice ;
    private int lowprice ;

    @Override
    public String toString() {
        return "Car{" +
                "car_no=" + car_no +
                ", brand='" + brand + '\'' +
                ", car_model='" + car_model + '\'' +
                ", release_date='" + release_date + '\'' +
                ", color='" + color + '\'' +
                ", car_type='" + car_type + '\'' +
                ", engine_type='" + engine_type + '\'' +
                ", fuel_efficiency=" + fuel_efficiency +
                ", price=" + price +
                ", maxprice=" + maxprice +
                ", lowprice=" + lowprice +
                '}';
    }

    public int getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(int maxprice) {
        this.maxprice = maxprice;
    }

    public int getLowprice() {
        return lowprice;
    }

    public void setLowprice(int lowprice) {
        this.lowprice = lowprice;
    }

    public Car(int maxprice, int lowprice) {
        this.maxprice = maxprice;
        this.lowprice = lowprice;
    }

    public Car(){}

    public Car(int car_no, String brand, String car_model, String release_date, String color, String car_type, String engine_type, int fuel_efficiency, int price) {
        this.car_no = car_no;
        this.brand = brand;
        this.car_model = car_model;
        this.release_date = release_date;
        this.color = color;
        this.car_type = car_type;
        this.engine_type = engine_type;
        this.fuel_efficiency = fuel_efficiency;
        this.price = price;
    }

    public int getCarNumber() {
        return car_no;
    }

    public void setCarNumber(int car_no) {
        this.car_no = car_no;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarModel() {
        return car_model;
    }

    public void setCarModel(String car_model) {
        this.car_model = car_model;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String release_date) {
        this.release_date = release_date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarType() {
        return car_type;
    }

    public void setCarType(String car_type) {
        this.car_type = car_type;
    }

    public String getEngineType() {
        return engine_type;
    }

    public void setEngineType(String engine_type) {
        this.engine_type = engine_type;
    }

    public int getFuelEfficiency() {
        return fuel_efficiency;
    }

    public void setFuelEfficiency(int fuel_efficiency) {
        this.fuel_efficiency = fuel_efficiency;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
