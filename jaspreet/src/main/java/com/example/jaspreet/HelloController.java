package com.example.jaspreet;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Employee> tableView;

    private TextField first_name;
    private TextField last_name;
    private TextField department;

    @FXML
    protected void loadData() {
        try {
            Connection connection = HelloApplication.getConnection();

            String sql = "SELECT * FROM employee";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            List<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String department = resultSet.getString("department");


                Employee employee = new Employee(employee_id, firstName, lastName, department);
                employees.add(employee);
            }

            tableView.getItems().setAll(employees);

            TableColumn<Employee, Integer> idColumn = new TableColumn<>("Employee_id");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
            TableColumn<Employee, String> fNameColumn = new TableColumn<>("First_name");
            fNameColumn.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            TableColumn<Employee, Integer> lNameColumn = new TableColumn<>("Last_name");
            lNameColumn.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            TableColumn<Employee, String> departmentColumn = new TableColumn<>("Department");
            departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

            tableView.getColumns().setAll(idColumn, fNameColumn, lNameColumn, departmentColumn);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }



    @FXML
    protected void insertData() {
        try {

            Connection connection = HelloApplication.getConnection();

            String sql = "INSERT INTO employee (first_name, last_name, department) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Jaz");
            statement.setString(2, "Gill");
            statement.setString(3, "Engineering");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new employee was inserted successfully!");
            }


            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @FXML
    protected void updateData() {
        try {

            Connection connection = HelloApplication.getConnection();

            String sql = "UPDATE employee SET first_name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "UpdatedFirstName");
            statement.setInt(2, 1); // Assuming we are updating employee with ID = 1

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee first name was updated successfully!");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void deleteData() {
        try {
            Connection connection = HelloApplication.getConnection();

            String sql = "DELETE FROM employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 1);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee was deleted successfully!");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
