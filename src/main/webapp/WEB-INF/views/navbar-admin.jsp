<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow py-3 px-5 mb-4">
   <div class="container-fluid">
     <a class="navbar-brand" href="<%=request.getContextPath()%>/">ABC Jobs</a>
     <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>
     <div class="collapse navbar-collapse" id="navbarSupportedContent">
       <ul class="navbar-nav me-auto mb-2 mb-lg-0">
         <li class="nav-item">
           <a class="nav-link" href="<%=request.getContextPath()%>/search">Search</a>
         </li>
         <li class="nav-item">
           <a class="nav-link" href="<%=request.getContextPath()%>/job">Job</a>
         </li>
         <li class="nav-item">
           <a class="nav-link" href="<%=request.getContextPath()%>/thread">Thread</a>
         </li>
       </ul>
       <div class="rightNav">
         <a href="<%=request.getContextPath()%>/admin" class="me-2">Administration</a>
         <a href="<%=request.getContextPath()%>/profile" id="profile-link">${user.firstname}</a>
         <a href="<%=request.getContextPath()%>/logout"><button class="btn btn-nav mx-2" type="submit">Logout</button></a>
       </div>
     </div>
   </div>
</nav>