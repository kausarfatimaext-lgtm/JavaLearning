import Aggregation.Car;
import Aggregation.Driver;
import Composition.Company;

void main() {
    // ------ Aggregation ------
    Driver driver = new Driver();
    driver.setName("Ali");
    driver.setAge(28);
    driver.setLicenseNumber("12345678");

    Car car = new Car();
    car.setMake("Honda");
    car.setColor("white");
    car.setModel("2011");
    car.setDriver(driver);
    car.drivenBy();

    // ------ Composition ------
    Company company = new Company("XYZ", "Lahore");
    company.logCompanyInfo();
    company.addDepartment("HR", "Shahid", 50);
    company.addDepartment("IT", "Ahmad", 90);
    company.getDepartments();
    System.out.println(company.getCompanyName() + " Total no of employees: " + company.getTotalEmp());
}