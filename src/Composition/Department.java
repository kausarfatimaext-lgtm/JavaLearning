package Composition;

public class Department {
    private String depName;
    private String managerName;
    private int noOfEmp;

    public Department(String depName, String managerName, int noOfEmp){
        this.depName = depName;
        this.managerName = managerName;
        this.noOfEmp = noOfEmp;
    }

    public String getDepName(){
        return this.depName;
    }
    public String getManagerName(){
        return this.managerName;
    }
    public int getNoOfEmp(){
        return noOfEmp;
    }
}
