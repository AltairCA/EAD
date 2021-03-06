/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DbContext;

import Models.Employee;
import Models.Role;
import Models.Task;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Handles all the query operations regarding to the employee class
 * @author Altair
 */
public class dbEmployee {
    /**
     * Get the first record from the data source
     * @return Employee object
     */
    public Employee getFirstEmployees(){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee employees =(Employee) session.createQuery(
                    "select e from Employee as e"
            ).setMaxResults(1).uniqueResult();
            
            tx.commit();
            return employees;
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
        return null;
    }
    /**
     * Get all the employees
     * @return List of employees
     */
    public List getEmployees(){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery(
                    "select e from Employee as e"
            ).list();
            
            tx.commit();
            return employees;
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
        return null;
    }
    /**
     * Create a new employee
     * @param name employee Name
     * @param roleId 
     */
    public void createEmployee(String name,int roleId){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee employee = new Employee();
            employee.setName(name);
            if(roleId != -1){
                Role role = (Role) session.createQuery(
                                "select r from Role as r where r.roleID = :rid"
                            ).setParameter("rid", roleId).uniqueResult();
                employee.setRole(role);
            }
            session.save(employee);
            tx.commit();
            
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    /**
     * Update the employee
     * @param name
     * @param empID 
     */
    public void updateEmployee(String name,int empID){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee dbEmp =(Employee) session.createQuery(
                    "select e from Employee as e where e.employeeID = :eid"
            ).setParameter("eid", empID).uniqueResult();
            
            dbEmp.setName(name);
            session.update(dbEmp);
            tx.commit();
            
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    /**
     * remove role from the employee
     * @param empID 
     */
    public void removeRole(int empID){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee dbEmp =(Employee) session.createQuery(
                    "select e from Employee as e where e.employeeID = :eid"
            ).setParameter("eid", empID).uniqueResult();
            
            dbEmp.setRole(null);
            session.update(dbEmp);
            tx.commit();
            
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    /**
     * Set role to a employee
     * @param empID
     * @param roleId 
     */
    public void setRole(int empID,int roleId){
        removeRole(empID);
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee dbEmp =(Employee) session.createQuery(
                    "select e from Employee as e where e.employeeID = :eid"
            ).setParameter("eid", empID).uniqueResult();
            Role dbRole = (Role) session.createQuery(
                    "select r from Role as r where r.roleID = :rid"
            ).setParameter("rid", roleId).uniqueResult();
            dbEmp.setRole(dbRole);
            session.update(dbEmp);
            tx.commit();
            
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    /**
     * Remove a task from employee
     * @param empID
     * @param taskID 
     */
    public void removeTask(int empID,int taskID){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee dbEmp =(Employee) session.createQuery(
                    "select e from Employee as e where e.employeeID = :eid"
            ).setParameter("eid", empID).uniqueResult();
            Task dbTask = (Task) session.createQuery(
                    "select t from Task as t where t.taskID = :tid"
            ).setParameter("tid", taskID).uniqueResult();
            dbEmp.removeTask(dbTask);
            
            session.update(dbEmp);
            tx.commit();
            
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    /**
     * Add task to a employee
     * @param empID
     * @param taskID 
     */
    public void addTask(int empID,int taskID){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee dbEmp =(Employee) session.createQuery(
                    "select e from Employee as e where e.employeeID = :eid"
            ).setParameter("eid", empID).uniqueResult();
            Task dbTask = (Task) session.createQuery(
                    "select t from Task as t where t.taskID = :tid"
            ).setParameter("tid", taskID).uniqueResult();
            dbEmp.addTask(dbTask);
            
            session.update(dbEmp);
            tx.commit();
            
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
    /**
     * Get Task from the employee
     * @param empID
     * @return 
     */
    public Set getTasks(int empID){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee dbEmp =(Employee) session.createQuery(
                    "select e from Employee as e where e.employeeID = :eid"
            ).setParameter("eid", empID).uniqueResult();
            Set tasks = dbEmp.getTasks();
            tasks.size();
            
            tx.commit();
            return tasks;
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
        return null;
    }
    /**
     * Get role from the employee
     * @param empID
     * @return 
     */
    public Role getRole(int empID){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Employee dbEmp =(Employee) session.createQuery(
                    "select e from Employee as e where e.employeeID = :eid"
            ).setParameter("eid", empID).uniqueResult();
            Role role = dbEmp.getRole();
            Role temp = null;
            if(role != null){
                temp = new Role();
                temp.setRoleID(role.getRoleID());
                temp.setTitle(role.getTitle());
            }
            
            tx.commit();
            return temp;
        }catch(RuntimeException e){
            if(tx != null && tx.isActive()){
                try{
                    tx.rollback();
                }catch(HibernateException el){
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
        return null;
    }
}
