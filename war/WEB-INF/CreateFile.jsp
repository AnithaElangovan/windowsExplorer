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

<div class="span4 proj-div" data-toggle="modal" data-target="#GSCCModal">
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
			<h1>Do you want to create a file?</h1>
			<br>
			<br>
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">click
				to create a new File</button>
		</div>
	</div>
<div class="span4 proj-div" data-toggle="modal" data-target="#GSCCModal"></div>
 <div id="GSCCModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;  </button>
        <h4 class="modal-title" id="myModalLabel">New File</h4>
      </div>
      
 <!-- *******************new folder creation action *******************************-->
    <form name="filecreation" action="/filecreated"method="post">
    <p>${errorMessage}</p>
  	<div class="modal-body">
  		Drive Name to which this file belongs to:<input type="text" name="belongsToDrive"><br><br>
  		Folder Name to which this file belongs to:<input type="text" name="belongsToFolder"><br><br>
        File Name:<input type="text" name="fileName"><br><br>
        File Type:<select id="fileType" name="fileType">
        	<option>RTF</option>
        	<option>TXT Doc</option>
        	<option>MS-DOS </option>
			<option>XML Doc</option>
      		</select><br><br>
      	<!--  File Location:<input type="text" value="${belongsToDrive}/${belongsToFolder}/${fileName}" name="fileLocation"><br><br>-->
      	
      	
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
<br>
</body>
</html>