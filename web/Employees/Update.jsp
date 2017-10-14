<%-- 
    Document   : Update
    Created on : Oct 13, 2017, 11:44:42 PM
    Author     : Altair
--%>

<%@page import="Models.Role"%>
<%@page import="java.util.Set"%>
<%@page import="DbContext.ApplicationDbContext" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="Models.Employee" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Update</title>
        <link rel="stylesheet" href="../plugins/select2/select2.min.css">
        <jsp:include page="../Includes/Head.jsp" />
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <jsp:include page="../Includes/mainLogo.jsp">
                <jsp:param name="pname" value="empUpdate" />
            </jsp:include>
            <!-- Left side column. contains the logo and sidebar -->
            <%
                int employeeID = (Integer) request.getAttribute("empID");
                //int employeeID = 1;
            %>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Employees
                        <small>Update</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="../DashBoard/Dashboard"><i class="fa fa-dashboard"></i> Dashboard</a></li>

                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Small boxes (Stat box) -->
                    <div class="row">
                        <div class="col-md-3">

                        </div>
                        <div class="col-md-6">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Update Employee</h3>
                                </div>
                                <!-- /.box-header -->
                                <!-- form start -->
                                <form role="form" action="${pageContext.request.contextPath}/Employees/Update" method="post">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>Select Employee</label>
                                            <select name="employee" id="emplist"  class="form-control select2" style="width: 100%;">

                                                <%
                                                    ApplicationDbContext dbContext = ApplicationDbContext.getInstance();
                                                    List employees = dbContext.employees.getEmployees();
                                                    Employee currentEmp = null;
                                                    if (employees != null) {
                                                        for (Iterator iter = employees.iterator(); iter.hasNext();) {
                                                            Employee elem = (Employee) iter.next();
                                                            if (elem.getEmployeeID() != employeeID) {
                                                                out.write("<option value='" + elem.getEmployeeID() + "'>" + elem.getEmployeeID() + " - " + elem.getName() + "</option>");
                                                            } else {
                                                                currentEmp = elem;
                                                                out.write("<option selected value='" + elem.getEmployeeID() + "'>" + elem.getEmployeeID() + " - " + elem.getName() + "</option>");
                                                            }

                                                        }
                                                    }
                                                   
                                                %>

                                            </select>
                                        </div>
                                        <div class="form-group 
                                             <%
                                                 if (request.getAttribute("error") != null) {
                                                     out.write("has-error");
                                                 }
                                             %>
                                             ">
                                            <label for="exampleInputEmail1">Employee Name</label>
                                            <input type="text" name="name" value="<% out.write(currentEmp.getName()); %>" class="form-control" id="exampleInputEmail1" placeholder="Enter Name">
                                            <span class="help-block">
                                                <%
                                                    if (request.getAttribute("error") != null) {
                                                        out.write("Please Enter a Name");
                                                    }
                                                %>
                                            </span>
                                        </div>
                                        <div class="form-group">
                                            <label>Tasks</label>
                                            <select name="tasks" class="form-control select2" multiple="multiple" data-placeholder="Select a State" style="width: 100%;">
                                                <%@page import="Models.Task" %>
                                                <%
                                                    Set currentTasks = dbContext.employees.getTasks(currentEmp.getEmployeeID());
                                                    if (currentTasks != null) {
                                                        for (Iterator iter = currentTasks.iterator(); iter.hasNext();) {
                                                            Task task = (Task) iter.next();
                                                            out.write("<option selected value='" + task.getTaskID() + "'>" + task.getTaskID() + " - " + task.getDescription() + "</option>");
                                                        }
                                                    }
                                                    List availableTasks = dbContext.task.getAvailableTasks();
                                                    if (availableTasks != null) {
                                                        for (Iterator iter = availableTasks.iterator(); iter.hasNext();) {
                                                            Task task = (Task) iter.next();
                                                            out.write("<option value='" + task.getTaskID() + "'>" + task.getTaskID() + " - " + task.getDescription() + "</option>");
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Select Role</label>
                                            <select name="role"  class="form-control select2" style="width: 100%;">
                                                <option value="-1">Select ... </option>
                                                <%
                                                    Role role = dbContext.employees.getRole(currentEmp.getEmployeeID());
                                                    if (role != null) {
                                                        out.write("<option selected value='" + role.getRoleID() + "'>" + role.getRoleID() + " - " + role.getTitle() + "</option>");
                                                    }
                                                    List roles = dbContext.roles.getAvailableRoles();
                                                    for (Iterator iter = roles.iterator(); iter.hasNext();) {
                                                        Role roledb = (Role) iter.next();
                                                        out.write("<option value='" + roledb.getRoleID() + "'>" + roledb.getRoleID() + " - " + roledb.getTitle() + "</option>");
                                                    }
                                                %>

                                            </select>
                                        </div>
                                        <%
                                            if (request.getAttribute("sucess") != null) {
                                                out.write("<div class='callout callout-succes' style='background-color: #00a65a !important;'><h4>Sucess!</h4></div>");
                                            }

                                        %>
                                    </div>
                                    <!-- /.box-body -->

                                    <div class="box-footer">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-3">

                        </div>

                    </div>
                    <!-- /.row -->
                    <!-- Main row -->

                    <!-- /.row (main row) -->

                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <jsp:include page="../Includes/Footer.jsp" />
            <!-- Control Sidebar -->

            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <jsp:include page="../Includes/Body.jsp" />
        <script src="../plugins/select2/select2.full.min.js"></script>
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 3.3.6 -->

        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->

        <!-- AdminLTE for demo purposes -->
        <script src="../dists/js/demo.js"></script>
        <script>
            $(function() {
//Initialize Select2 Elements
                $(".select2").select2();

                $(document.body).on("change", "#emplist", function() {
                    //alert(this.value);
                    window.location.href = "${pageContext.request.contextPath}/Employees/Update?id=" + this.value;
                });
            });
        </script>
    </body>
</html>
