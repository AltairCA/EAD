<%-- 
    Document   : Dashboard
    Created on : Oct 13, 2017, 2:59:25 PM
    Author     : Altair
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DbContext.ApplicationDbContext" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="Models.Task" %>
<%@page import="Models.Employee" %>
<%@page import="Models.Role" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../Includes/Head.jsp" />
        <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <jsp:include page="../Includes/mainLogo.jsp">
                <jsp:param name="pname" value="Dashboard" />
            </jsp:include>
            <%
                ApplicationDbContext dbContext = ApplicationDbContext.getInstance();
                List roleList = dbContext.roles.getAllRoles();
                List employeeList = dbContext.employees.getEmployees();
                List taskList = dbContext.task.getAllTasks();
                int roleSize = roleList.size();
            %>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Dashboard
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="../DashBoard/Dashboard.jsp"><i class="fa fa-dashboard"></i> Dashboard</a></li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Small boxes (Stat box) -->
                    <div class="row">

                        <!-- ./col -->
                        <div class="col-lg-4 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-green">
                                <div class="inner">
                                    <h3><% out.write(String.valueOf(roleList.size())); %></h3>

                                    <p>Roles Count</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-stats-bars"></i>
                                </div>
                                <a href="#" class="small-box-footer"></a>
                            </div>
                        </div>
                        <!-- ./col -->
                        <div class="col-lg-4 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-yellow">
                                <div class="inner">
                                    <h3><% out.write(String.valueOf(employeeList.size())); %></h3>

                                    <p>Employees</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-person-add"></i>
                                </div>
                                <a href="#" class="small-box-footer"></a>
                            </div>
                        </div>
                        <!-- ./col -->
                        <div class="col-lg-4 col-xs-6">
                            <!-- small box -->
                            <div class="small-box bg-red">
                                <div class="inner">
                                    <h3><% out.write(String.valueOf(taskList.size())); %></h3>

                                    <p>Unique Tasks</p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-pie-graph"></i>
                                </div>
                                <a href="#" class="small-box-footer"></a>
                            </div>
                        </div>
                        <!-- ./col -->
                    </div>
                    <!-- /.row -->
                    <!-- Main row -->

                    <!-- /.row (main row) -->
                     <div class="row">
                        <div class="col-md-1">

                        </div>
                        <div class="col-md-10">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Employees</h3>
                                </div>
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Employee Id</th>
                                                <th>Name</th>
                                                <th>Update</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            
                                            <%
                                                
                                                List employees = dbContext.employees.getEmployees();
                                                if (employees != null) {
                                                    for (Iterator iter = employees.iterator(); iter.hasNext();) {
                                                        Employee elem = (Employee) iter.next();
                                                        out.write("<tr><td>" + elem.getEmployeeID()+ "</td><td>" + elem.getName()+ "</td>");
                                                        out.write("<td><button type='button' onclick='onClick("+elem.getEmployeeID()+")' class='btn btn-block btn-primary btn-xs'>Update</button></td></tr>");
                                                    }
                                                }
                                            %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Employee Id</th>
                                                <th>Name</th>
                                                <th>Update</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>


                            </div>
                        </div>
                        <div class="col-md-1">

                        </div>

                    </div>
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

        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 3.3.6 -->

        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->

        <!-- AdminLTE for demo purposes -->
        <script src="../dists/js/demo.js"></script>
        <script src="../plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
        <script>
            $(function() {
                $("#example1").DataTable();
            });
            function onClick(url){
                window.location.href = "${pageContext.request.contextPath}/Employees/Update?id=" + url;
            }
        </script>
            
    </body>
</html>
