package Aggregation;

public class Car {
    private String make;
    private String model;
    private String color;
    private Driver driver;

    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setDriver(Driver driver){
        this.driver = driver;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public String getColor(){
        return color;
    }

    public void drivenBy(){
        if(driver != null){
            System.out.println(make + " model of " + model + " having color of " + color + " is driven by " + driver.getName());
        } else {
            System.out.println(make + "Car has no driver assigned.");
        }
    }
}
