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
@Entity(name="Role")
@Table(name="ROLE")
public class Role implements java.io.Serializable {
    @Id
    @GenericGenerator(name="Altair", strategy="increment")
    @GeneratedValue(generator="Altair")
    @Column(name="ROLEID")
    private int roleID;
    
    @Column(name="TITLE")
    private String title;

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRoleID() {
        return roleID;
    }

    public String getTitle() {
        return title;
    }
    @Override
    public String toString(){
        return "RoleId :"+getRoleID()+" Title: "+getTitle();
    }
}
