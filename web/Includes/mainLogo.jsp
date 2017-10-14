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
            <a href="../DashBoard/Dashboard">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
            
          </a>
        </li>
        
        
        <li <% 
               
               if(pageName.equals("roleCreate") || pageName.equals("roleUpdate") || pageName.equals("roleView")){
                   out.write("class='active treeview'");
               }else{
                   out.write("class='treeview'");
               }
              
            
              %>
            
            >
          <a href="#">
            <i class="fa fa-key"></i>
            <span>Roles</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
              <li <% 
               
               if(pageName.equals("roleView")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Roles/View"><i class="fa fa-circle-o text-aqua"></i> View</a></li>
              <li <% 
               
               if(pageName.equals("roleCreate")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Roles/Create"><i class="fa fa-circle-o text-yellow"></i> Create</a></li>
              <li <% 
               
               if(pageName.equals("roleUpdate")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Roles/Update"><i class="fa fa-circle-o text-red"></i> Update</a></li>
          </ul>
        </li>
        
        
        <li <% 
               
               if(pageName.equals("taskCreate") || pageName.equals("taskUpdate") || pageName.equals("taskView")){
                   out.write("class='active treeview'");
               }else{
                   out.write("class='treeview'");
               }
              
            
              %>
            
            >
          <a href="#">
            <i class="fa fa-tasks"></i>
            <span>Tasks</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
              <li <% 
               
               if(pageName.equals("taskView")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Tasks/View"><i class="fa fa-circle-o text-aqua"></i> View</a></li>
              <li <% 
               
               if(pageName.equals("taskCreate")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Tasks/Create"><i class="fa fa-circle-o text-yellow"></i> Create</a></li>
              <li <% 
               
               if(pageName.equals("taskUpdate")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Tasks/Update"><i class="fa fa-circle-o text-red"></i> Update</a></li>
          </ul>
        </li>
        
        
        
        <li <% 
               
               if(pageName.equals("empCreate") || pageName.equals("empUpdate") || pageName.equals("empView")){
                   out.write("class='active treeview'");
               }else{
                   out.write("class='treeview'");
               }
              
            
              %>
            
            >
          <a href="#">
            <i class="fa fa-users"></i>
            <span>Employees</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
              <li <% 
               
               if(pageName.equals("empView")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Employees/View"><i class="fa fa-circle-o text-aqua"></i> View</a></li>
              <li <% 
               
               if(pageName.equals("empCreate")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Employees/Create"><i class="fa fa-circle-o text-yellow"></i> Create</a></li>
              <li <% 
               
               if(pageName.equals("empUpdate")){
                   out.write("class='active'");
               }
              
            
              %> ><a href="../Employees/Update"><i class="fa fa-circle-o text-red"></i> Update</a></li>
          </ul>
        </li>
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>