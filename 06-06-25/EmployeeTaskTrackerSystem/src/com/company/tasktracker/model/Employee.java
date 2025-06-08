package com.company.tasktracker.model;

public class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {return id;}

    public String getName() {return name;}

    public String getDepartment() {return department;}

    public String toString(){
        return id + " - " + name + " (" + department + ")";
    }

    public int hashCode(){
        return id;
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Employee)) return false;
        return this.id == ((Employee) obj).id;
    }
}
