<%-- 
    Document   : View
    Created on : Oct 13, 2017, 9:00:35 PM
    Author     : Altair
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tasks View</title>
        <jsp:include page="../Includes/Head.jsp" />
        <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <jsp:include page="../Includes/mainLogo.jsp">
                <jsp:param name="pname" value="taskView" />
            </jsp:include>
            <!-- Left side column. contains the logo and sidebar -->


            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Tasks
                        <small>View</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="../DashBoard/Dashboard.jsp"><i class="fa fa-dashboard"></i> Dashboard</a></li>

                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <!-- Small boxes (Stat box) -->
                    <div class="row">
                        <div class="col-md-1">

                        </div>
                        <div class="col-md-10">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Tasks</h3>
                                </div>
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Task Id</th>
                                                <th>Description</th>
                                                <th>Employee ID</th>
                                                <th>Update</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%@page import="DbContext.ApplicationDbContext" %>
                                            <%@page import="java.util.List" %>
                                            <%@page import="java.util.Iterator" %>
                                            <%@page import="Models.Task" %>
                                            <%
                                                ApplicationDbContext dbContext = ApplicationDbContext.getInstance();
                                                List tasks = dbContext.task.getAllTasks();
                                                if (tasks != null) {
                                                    for (Iterator iter = tasks.iterator(); iter.hasNext();) {
                                                        Task elem = (Task) iter.next();
                                                        out.write("<tr><td>" + elem.getTaskID() + "</td><td>" + elem.getDescription() + "</td><td>" + elem.getEmployeeID() + "</td>");
                                                        out.write("<td><button type='button' onclick='onClick(" + elem.getTaskID() + ")' class='btn btn-block btn-primary btn-xs'>Update</button></td></tr>");
                                                    }
                                                }
                                            %>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Task Id</th>
                                                <th>Description</th>
                                                <th>Employee ID</th>
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
            function onClick(url) {
                window.location.href = "${pageContext.request.contextPath}/Tasks/Update?id=" + url;
            }
        </script>
    </body>
</html>