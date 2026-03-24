package EmployeeDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    // CREATE
    public void insertUser(Employee user){
        String sql = "INSERT INTO Employees (name, age, email, department) VALUES (?, ?, ?, ?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getDepartment());
            stmt.executeUpdate();
            System.out.println("Employee added successfully");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // READ
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        String sql = "Select * from Employees";

        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()){
                employees.add(new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("department")
                        ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    // UPDATE
    public void updateUser(Employee employee){
        String sql = "Update Employees set name = ?, age = ?, email = ?, department = ? where id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, employee.getName());
            stmt.setInt(2, employee.getAge());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getDepartment());
            stmt.setInt(5, employee.getId());
            stmt.executeUpdate();
            System.out.println("Employee updated successfully");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteUser(int id){
        String sql = "Delete from Employees where id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employee deleted successfully");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
