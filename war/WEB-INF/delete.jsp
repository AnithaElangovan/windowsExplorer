<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Windows Explorer</title>

<meta name="viewport"content="width=device-width,initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
</head>
<body>


		<div class="col-md-11.5 text-center"
			style="background-color: lightgray">
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<h1>Do you want to delete?</h1>
			<br>
			<br>
			<div class="span4 proj-div" data-toggle="modal" data-target="#GSCCModal1">
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">Drive</button>
			</div><br><br>
			<div class="span4 proj-div" data-toggle="modal" data-target="#GSCCModal2">
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">Folder</button>
			</div><br><br>
			<div class="span4 proj-div" data-toggle="modal" data-target="#GSCCModal3">
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">File</button>
			</div><br><br>
	</div>
	<div class="span4 proj-div" data-toggle="modal" data-target="#GSCCModal1"></div>
 <div id="GSCCModal1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;  </button>
        <h4 class="modal-title" id="myModalLabel">Drive deletion</h4>
      </div>
      
 <!-- *******************new folder creation action *******************************-->
    <form name="drivedeletion" action="/deletedrive"method="get">
  	<div class="modal-body">
  		Enter the name of the file to delete<input type="text" name="driveName"><br><br>
  		
      	
      	
    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-default">submit</button>
      </div>
  </form>
  <!-- *******************END of new folder creation action *******************************-->
  
    </div>
  </div>
</div>
			<div class="span4 proj-div" data-toggle="modal" data-target="#GSCCModal2"></div>
 <div id="GSCCModal2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;  </button>
        <h4 class="modal-title" id="myModalLabel">folder deletion</h4>
      </div>
      
 <!-- *******************new folder creation action *******************************-->
    <form name="folderdeletion" action="/deletefolder"method="get">
  	<div class="modal-body">
  		Enter the name of the folder to delete<input type="text" name="folderName"><br><br>
  		
      	
      	
    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-default">submit</button>
      </div>
  </form>
  <!-- *******************END of new folder creation action *******************************-->
  
    </div>
  </div>
</div>



<div class="span4 proj-div" data-toggle="modal" data-target="#GSCCModal3"></div>
 <div id="GSCCModal3" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;  </button>
        <h4 class="modal-title" id="myModalLabel">File deletion</h4>
      </div>
      
 <!-- *******************new folder creation action *******************************-->
    <form name="filedeletion" action="/deletefile"method="get">
  	<div class="modal-body">
  		Enter the name of the file to delete<input type="text" name="fileName"><br><br>
  		
      	
      	
    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-default">submit</button>
      </div>
  </form>
  <!-- *******************END of new folder creation action *******************************-->
  
    </div>
  </div>
</div>
</body>
</html>