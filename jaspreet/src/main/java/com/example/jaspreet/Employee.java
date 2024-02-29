// Employee.java
package com.example.jaspreet;

public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String department;



    public Employee(int employee_id, String first_name, String last_name, String department) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.department = department;

    }

    public int getemployee_id() {
        return employee_id;
    }

    public void setemployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getdepartment() {
        return department;
    }

    public void setdepartment(String department) {
        this.department = department;
    }

}
