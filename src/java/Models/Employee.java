/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Altair
 */
public class Employee {
    private int employeeID;
    private String name;
    private Role role;
    private Set tasks;
    
    public Employee(){
        this.tasks = new HashSet();
    }
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set getTasks() {
        return tasks;
    }

    public void setTasks(Set tasks) {
        this.tasks = tasks;
    }
    public void addTask(Task task){
        this.tasks.add(task);
    }
    public void removeTask(Task task){
        this.tasks.remove(task);
    }
}
