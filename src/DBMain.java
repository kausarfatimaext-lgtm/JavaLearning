import EmployeeDB.Employee;
import EmployeeDB.EmployeeDAO;

void main() {
    EmployeeDAO dao= new EmployeeDAO();

    // Insert Employee
    Employee newEmployee1 = new Employee("Ahmad", 25, "ahmad@gmail.com", "Finance");
    dao.insertUser(newEmployee1);
    Employee newEmployee2 = new Employee("Usman", 27, "usman@gmail.com", "HR");
    dao.insertUser(newEmployee2);

    // Get all Employees
    List<Employee> employees = dao.getAllEmployees();
    employees.forEach(e -> System.out.println(e.getName() + ": " + e.getAge() + ": " + e.getEmail() + ": " + e.getDepartment()));

    // Update Employees
    if(!employees.isEmpty()){
        Employee emp = employees.get(1);
        emp.setName("Fatima");
        emp.setAge(24);
        emp.setEmail("fatima@gmail.com");
        emp.setDepartment("IT");
        dao.updateUser(emp);
    }

    // Delete employee
    if(!employees.isEmpty()){
        dao.deleteUser(employees.get(2).getId());
    }
}