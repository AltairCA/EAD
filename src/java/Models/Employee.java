/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author Altair
 */
@Entity(name="Employee")
@Table(name="EMPLOYEE")
public class Employee implements java.io.Serializable {
    @Id
    @GenericGenerator(name="Altair", strategy="increment")
    @GeneratedValue(generator="Altair")
    @Column(name="EMPLOYEEID")
    private int employeeID;
    
    @Column(name="NAME")
    private String name;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ROLEID",nullable = true,unique = true)
    private Role role;
    
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "EMPLOYEEID")
    private Set<Task> tasks = new HashSet(0);
    
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

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    public void addTask(Task task){
        this.tasks.add(task);
    }
    public void removeTask(Task task){
        this.tasks.remove(task);
    }
}
