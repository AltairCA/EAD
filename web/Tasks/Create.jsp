<%-- 
    Document   : Create
    Created on : Oct 13, 2017, 8:30:57 PM
    Author     : Altair
--%>


<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tasks Create</title>
        <jsp:include page="../Includes/Head.jsp" />
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <jsp:include page="../Includes/mainLogo.jsp">
                <jsp:param name="pname" value="taskCreate" />
            </jsp:include>
            <!-- Left side column. contains the logo and sidebar -->


            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Task
                        <small>Create</small>
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
                                    <h3 class="box-title">Create New Task</h3>
                                </div>
                                <!-- /.box-header -->
                                <!-- form start -->
                                <form role="form" action="${pageContext.request.contextPath}/Tasks/Create" method="post">
                                    <div class="box-body">
                                        <div class="form-group 
                                             <%
                                                 if (request.getAttribute("error") != null) {
                                                     out.write("has-error");
                                                 }
                                             %>
                                             ">
                                            <label for="exampleInputEmail1">Task Description</label>
                                            <input type="text" name="description" class="form-control" id="exampleInputEmail1" placeholder="Enter Description">
                                            <span class="help-block">
                                                <%
                                                        if (request.getAttribute("error") != null) {
                                                            out.write("Please Enter a Description");
                                                        }
                                                %>
                                            </span>
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

        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 3.3.6 -->

        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        
        <!-- AdminLTE for demo purposes -->
        <script src="../dists/js/demo.js"></script>
    </body>
</html>
