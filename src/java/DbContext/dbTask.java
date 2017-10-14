/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DbContext;

import Models.Task;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Handles all the query operations regarding to the Task class
 * @author Altair
 */
public class dbTask {
    /**
     * Get the first task from the database
     * @return Task
     */
    public Task getFirstTasks(){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Task tasks = (Task)session.createQuery(
                    "select t from Task as t"
            ).setMaxResults(1).uniqueResult();
            
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
     * Get all the tasks
     * @return List
     */
    public List getAllTasks(){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            List tasks = session.createQuery(
                    "select t from Task as t"
            ).list();
            
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
     * get the all the tasks that are not assigned to a employee
     * @return List
     */
    public List getAvailableTasks(){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            List tasks = session.createQuery(
                    "select t from Task as t where t.employeeID = 0 or t.employeeID is null"
            ).list();
            
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
     * Update Task
     * @param taskId
     * @param description 
     */
    public void updateTask(int taskId,String description){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Task dbRole =(Task) session.createQuery(
                    "select t from Task as t where t.taskID = :tid"
            ).setParameter("tid", taskId).uniqueResult();
            
            dbRole.setDescription(description);
            session.update(dbRole);
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
     * create Task
     * @param description 
     */
    public void createTask(String description){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Task task = new Task();
            task.setDescription(description);
            session.save(task);
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
}
