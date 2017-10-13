/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DbContext;

import Models.Role;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Altair
 */
public class dbRole {
    public List getAvailableRoles(){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            List roles = session.createQuery(
                    "select r from Role as r where r.roleID not in (select e.role.roleID from Employee as e where e.role is not null)"
            ).list();
            
            tx.commit();
            return roles;
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
    
    public void createRole(String title){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Role role = new Role();
            role.setTitle(title);
            session.save(role);
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
    
    public void updateRole(int RoleID,String title){
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try{
            tx = session.beginTransaction();
            Role dbRole =(Role) session.createQuery(
                    "select r from Role as r where r.roleID = :rid"
            ).setParameter("rid", RoleID).uniqueResult();
            
            dbRole.setTitle(title);
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
}
