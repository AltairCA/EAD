/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DbContext;

/**
 *
 * @author Altair
 */
public class ApplicationDbContext {
    private static ApplicationDbContext dbContext;
    public dbRole roles;
    public dbTask task;
    public dbEmployee employees;
    private ApplicationDbContext(){
        this.roles = new dbRole();
        this.task = new dbTask();
        this.employees = new dbEmployee();
    }
    public ApplicationDbContext getInstance(){
        if(dbContext == null){
            dbContext = new ApplicationDbContext();
        }
        return dbContext;
    }
}
