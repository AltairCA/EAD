<%-- 
    Document   : mainLogo
    Created on : Oct 13, 2017, 4:50:59 PM
    Author     : Altair
--%>
<%
            String pageName = request.getParameter("pname");
            
%>
<header class="main-header">
    <!-- Logo -->
    <a href="../DashBoard/Dashboard.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>F</b>JA</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>S</b>JAVA</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      
    </nav>
</header>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
       
        <li <%
             if(pageName.equals("Dashboard")){
                 out.write("class='active'");
             }
            %>
            >
            <a href="../DashBoard/Dashboard.jsp">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
            
          </a>
        </li>
        
        
        <li <% 
               
               if(pageName.equals("roleCreate")){
                   out.write("class='active treeview'");
               }else{
                   out.write("class='treeview'");
               }
              
            
              %>
            
            >
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Roles</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
              <li <% 
               
               if(pageName.equals("roleCreate")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Roles/Create.jsp"><i class="fa fa-circle-o"></i> Create</a></li>
          </ul>
        </li>
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>