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
 *
 * @author Altair
 */
public class dbEmployee {
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
}
