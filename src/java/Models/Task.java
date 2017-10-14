/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Altair
 */
@Entity(name="Task")
@Table(name="TASK")
public class Task implements java.io.Serializable {
    @Id
    @GenericGenerator(name="Altair", strategy="increment")
    @GeneratedValue(generator="Altair")
    @Column(name="TASKID")
    private int taskID;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="EMPLOYEEID")
    private Integer employeeID;

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployeeID() {
        if(this.employeeID == null){
            return 0;
        }else{
            return this.employeeID;
        }
        
    }

    public void setEmployeeID(Integer employeeID) {
        if(employeeID == null){
            this.employeeID = 0;
        }else{
            this.employeeID = employeeID;
        }
        
    }
    
    @Override
    public String toString(){
        return "Task id: "+getTaskID()+" Employee ID: "+getEmployeeID();
    }
}
