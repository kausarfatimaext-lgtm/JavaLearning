package Composition;

import java.util.ArrayList;

public class Company {
    private String CompanyName;
    private String location;
    private int totalEmp;
    private ArrayList<Department> departments = new ArrayList<Department>();

    public Company(String companyName, String location){
        this.CompanyName = companyName;
        this.location = location;
    }

    public void addDepartment(String DepName, String managerName, int noOfEmp){
        Department newDep = new Department(DepName, managerName, noOfEmp);
        departments.add(newDep);
    }

    public String getCompanyName(){
        return CompanyName;
    }
    public String getLocation(){
        return location;
    }
    public int getTotalEmp(){
        for(int i = 0; i < departments.size(); i++){
            this.totalEmp += departments.get(i).getNoOfEmp();
        }
        return totalEmp;
    }
    public void logCompanyInfo(){
        System.out.println("Company name: " + CompanyName);
        System.out.println("Company Location: " + location);
    }

    public void getDepartments(){
        for(int i = 0; i < departments.size(); i++){
            System.out.println("Department Name: " + departments.get(i).getDepName());
            System.out.println("Department Manager: " + departments.get(i).getManagerName());
            System.out.println("Department Total No of Employees: " + departments.get(i).getNoOfEmp());
            System.out.println("    ------------------------------------------------------   ");
        }
    }
}
