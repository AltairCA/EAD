/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets.Employee;

import DbContext.ApplicationDbContext;
import Models.Employee;
import Models.Task;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.tool.hbm2x.StringUtils;

/**
 *
 * @author Altair
 */
@WebServlet(name = "EmpUpdate", urlPatterns = {"/Employees/Update"})
public class Update extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee em = ApplicationDbContext.getInstance().employees.getFirstEmployees();
        Integer empID = 1;
        if(em != null){
            empID = em.getEmployeeID();
        }else{
            response.sendRedirect(request.getContextPath()+"/Employees/Create");
            return;
        }
        
        try {
            empID = Integer.parseInt(request.getParameter("id"));
        } catch (Exception ex) {

        }
        request.setAttribute("empID", empID);

        request.getRequestDispatcher("/Employees/Update.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] tasks = request.getParameterValues("tasks");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String empID = request.getParameter("employee");
        request.setAttribute("empID", Integer.parseInt(empID));
        if (name.isEmpty()) {
            request.setAttribute("error", "error");
        } else {
            ApplicationDbContext dbContext = ApplicationDbContext.getInstance();
            Set dbtasks = dbContext.employees.getTasks(Integer.parseInt(empID));
            for (Iterator iter = dbtasks.iterator(); iter.hasNext();) {
                Task elem = (Task) iter.next();
                dbContext.employees.removeTask(Integer.parseInt(empID), elem.getTaskID());

            }
            if(tasks != null){
                for (int x=0;tasks.length > x;x++) {
                
                    dbContext.employees.addTask(Integer.parseInt(empID), Integer.parseInt(tasks[x]));

                }
            }
            
            dbContext.employees.updateEmployee(name, Integer.parseInt(empID));
            if(Integer.parseInt(role) == -1){
                dbContext.employees.removeRole(Integer.parseInt(empID));
            }else{
                dbContext.employees.setRole(Integer.parseInt(empID), Integer.parseInt(role));
            }
            
            request.setAttribute("sucess", "sucess");
        }
        request.getRequestDispatcher("/Employees/Update.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
