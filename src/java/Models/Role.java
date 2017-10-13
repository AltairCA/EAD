/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author Altair
 */
public class Role {
    private int roleID;
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
