package Aggregation;

public class Driver {
    protected String name;
    protected int age;
    protected String licenseNumber;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }

    public String getName(){
        return name;
    }

    public String getLicenseNumber(){
        return licenseNumber;
    }

    public int getAge(){
        return age;
    }
}
