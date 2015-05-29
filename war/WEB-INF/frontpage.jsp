<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="com.adaptavant.windowExplorerSpringmvc.*" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>Windows Explorer</title>
<meta name="viewport"content="width=device-width,initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
 </head>
<style type="text/css">

.col-md-3
{
overflow:scroll;
}
.col-md-6
{
overflow:scroll;
}
.dropdown-submenu {
position: relative;
}

.dropdown-submenu>.dropdown-menu {
top: 0;
left: 100%;
margin-top: -6px;
margin-left: -1px;
-webkit-border-radius: 0 6px 6px 6px;
-moz-border-radius: 0 6px 6px;
border-radius: 0 6px 6px 6px;
}
.dropdown-submenu:hover>.dropdown-menu {
display: block;
}

.dropdown-submenu>a:after {
display: block;
content: " ";
float: right;
width: 0;
height: 0;
border-color: transparent;
border-style: solid;
border-width: 5px 0 5px 5px;
border-left-color: #ccc;
margin-top: 5px;
margin-right: -10px;
}

.dropdown-submenu:hover>a:after {
border-left-color: #fff;
}

.dropdown-submenu.pull-left {
float: none;
}

.dropdown-submenu.pull-left>.dropdown-menu {
left: -100%;
margin-left: 10px;
-webkit-border-radius: 6px 0 6px 6px;
-moz-border-radius: 6px 0 6px 6px;
border-radius: 6px 0 6px 6px;
}
#min{
font-color:white;
}
#max{
font-color:white;
}

</style>
<body>

<div class="navbar navbar-inverse navbar-default">

<form method="post">

<input type="button" 
      value="<"
    OnClick="history.go( -1 );return true;">

<input type="button" 
     value=">" 
    OnClick="history.go(  1 );return true;">
	
</form>

<form class="navbar-form navbar-right" action="/search" role="search">
		<button type="submit" class="btn btn-default">search</button>
</form>
				
		<div class="container">
				<div class="collapse navbar-collapse navHeaderCollapse">
					<ul class="nav navbar-nav navbar-left">
					
						<li class="active">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">file<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">open new window</a></li>
									<li><a href="#">open command prompt</a></li>
									<li><a href="#">open windows powershell</a></li>
									<li><a href="#">delete history</a></li>
									<li><a href="#">help</a></li>
									<li><a href="#">close</a></li>
								</ul>
						</li>
						<li class="active">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">computer<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">properties</a></li>
									<li><a href="#">access media</a></li>
									<li><a href="#">map network driver</a></li>
									<li><a href="#">add network drive</a></li>
									<li><a href="#">open control panel</a></li>
								</ul>
						</li>
						<li class="active">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">view<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">navigation pane</a></li>
									<li><a href="#">extra large icons</a></li>
									<li><a href="#">large icons</a></li>
									<li><a href="#">list</a></li>
									<li><a href="#">details</a></li>
									<li><a href="#">small icons</a></li>
									<li><a href="#">sort by</a></li>
								</ul>
						</li>
					</ul>
					
				</div>
			</div>
		</div>
		
<!--*************************************-->
	<div class="row">
  <div class="col-md-3">
  <div style="width:350px; height:650px; background-color:lightgray">
  

<a href="/createdrive"><button type="button" class="btn btn-default"  style="background-color:lightgray">
    <span class="glyphicon glyphicon-hdd"></span> New Drive
  </button></a><br>
  
  <a href="/createfolder"><button type="button" class="btn btn-default" style="background-color:lightgray">
    <span class="glyphicon glyphicon-folder-open"></span> New Folder
  </button></a><br>
  
  <a href="/createfile"><button type="button" class="btn btn-default" style="background-color:lightgray">
    <span class="glyphicon glyphicon-file"></span> New File
  </button></a><br>
 
  <a href="/delete"><button type="button" class="btn btn-default" style="background-color:lightgray">
    <span class="glyphicon glyphicon-trash"></span> delete
  </button></a><br>
  
  <a href="/copy"><button type="button" class="btn btn-default" style="background-color:lightgray">
    <span class="glyphicon glyphicon-copy"></span> copy
  </button></a><br>
  
   
  
<ul id="left_panel" class="nav nav-pills nav-stacked">
 
  <script type="text/javascript">
  var driveListObject=${driveListObject};
  if(driveListObject.length!=0)
	  {
	  for(var i=0;i<driveListObject.length;i++)
		  {
		  var list=document.createElement("LI");
		  list.setAttribute("role","presentation");
		  list.setAttribute("data-toggle","tooltip");
		  list.setAttribute("data-placement","right");
		  
		  var anchor=document.createElement("A");
		  anchor.setAttribute("class","btn btn-default");
		  anchor.setAttribute("href","/");
		  
		  var button=document.createElement("BUTTON");
		  button.setAttribute("id","button");
		  button.setAttribute("style","background-color:lightgray");
		  button.setAttribute("type","button");
		  button.setAttribute("class","btn btn-default");
		  button.setAttribute("data-toggle","dropdown");
		  button.setAttribute("aria-expanded","false");
		 
		  
		 
		  
		  
		  
		  var text=document.createTextNode(" "+driveListObject[i].driveName);
		  var span=document.createElement("SPAN");
		  span.setAttribute("class","glyphicon glyphicon-hdd");

		  var span1=document.createElement("SPAN");
		  span1.setAttribute("class","caret");
		  
		  
		  
		  button.appendChild(span);
		  button.appendChild(text);
		  button.appendChild(span1);
		  
		  anchor.appendChild(button);
		  //div.appendChild(button);
  		  list.appendChild(button);
  		

		  document.getElementById('left_panel').appendChild(list);
		  }
	  }
  </script>
  </ul>
  </div>
  </div>
  <!--**********************************-->
  <div class="col-md-6">
  <div style="width:700px; height:650px; background-color:lightyellow">
  <!-- <table id="table">
  
  <thead>
  <tr>
  <th width="150">name </th>
  <th width="150">type </th>
  <th width="150">size </th>
  <th>date and time</th>
  </tr>
  </thead>
  
     
	</table> -->
<ul id="mid_panel" class="nav nav-pills nav-stacked">
 <li>Name..................................type.......................................location...............................contains</li>
 <br>
  <script type="text/javascript">
  var driveFolderObject=${driveFolderObject};
  if(driveFolderObject.length!=0)
	  {
	  for(var i=0;i<driveFolderObject.length;i++)
		  {
		  var list=document.createElement("LI");
		  list.setAttribute("role","presentation");
		  list.setAttribute("data-toggle","tooltip");
		  list.setAttribute("data-placement","right");
		  list.setAttribute("style","background-color:gray;color:white")
		  
		  var anchor=document.createElement("A");
		  anchor.setAttribute("class","btn btn-default");
		  anchor.setAttribute("href","/"+(i+1));
		  
		 
		  var text=document.createTextNode("    "+driveFolderObject[i].folderName+".........................."+driveFolderObject[i].folderType+"..................................."+driveFolderObject[i].belongsToDrive+"................................"+driveFolderObject[i].folderContains);
		  var span=document.createElement("SPAN");
		  span.setAttribute("class","glyphicon glyphicon-folder-open");

		  
		  list.appendChild(span);
		  list.appendChild(text);
		  
		  
		  anchor.appendChild(list);
		  //div.appendChild(button);
  		  
  		

		  document.getElementById('mid_panel').appendChild(list);
		  }
	  }
  </script>
  </ul>
  </div>
  </div>
 
  <div class="col-md-3">
  <div style="width:300px; height:650px; background-color:white">
  <ul id="right_panel" class="nav nav-pills nav-stacked">
 <li>Name............type............location..................size</li>
 <br>
  <script type="text/javascript">
  var folderFileObject=${folderFileObject};
  if(folderFileObject.length!=0)
	  {
	  for(var i=0;i<folderFileObject.length;i++)
		  {
		  var list=document.createElement("LI");
		  list.setAttribute("role","presentation");
		  list.setAttribute("data-toggle","tooltip");
		  list.setAttribute("data-placement","right");
		  list.setAttribute("style","background-color:gray;color:white")
		  
		  var anchor=document.createElement("A");
		  anchor.setAttribute("class","btn btn-default");
		  anchor.setAttribute("href","/"+(i+1));
		  
		  
		  
		  var text=document.createTextNode(" "+folderFileObject[i].fileName+".........."+folderFileObject[i].fileType+"..........."+folderFileObject[i].belongsToDrive+"/"+folderFileObject[i].belongsToFolder+"............"+folderFileObject[i].fileSize+"");
		  var span=document.createElement("SPAN");
		  span.setAttribute("class","glyphicon glyphicon-file");

		  list.appendChild(span);
		  list.appendChild(text);
		 
		  anchor.appendChild(list);
		  //div.appendChild(button);
  		
  		

		  document.getElementById('right_panel').appendChild(list);
		  }
	  }
  </script>
  </ul>
  </div>
  </div>
 
</div>
</body>
</html>