<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Windows Explorer</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
			<h1>Do you want to create a folder?</h1>
			<br>
			<br>
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">click
				to create a new Folder</button>
		</div>
	</div>
	<div class="span4 proj-div" data-toggle="modal"
		data-target="#GSCCModal"></div>
	<div id="GSCCModal" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">New Folder</h4>
				</div>

				<!-- *******************new folder creation action *******************************-->
				<form name="folderCreation" action="/foldercreated"method="post">
				<p>${errorMessage}</p>
					<div class="modal-body">
						Drive Name to which this folder belongs to:<input type="text" name="belongsToDrive"><br><br>
						Folder Name:<input type="text" name="folderName"><br>
						<br> Folder Type:<select id="folderType" name="folderType">
							<option>file folder</option>
							<option>pictures</option>
							<option>music</option>
							<option>videos</option>
						</select> <br><br>
						<!-- Folder Location:<input type="text" value="${belongsToDrive}/${folderName}" name="folderLocation"><br><br> -->
						
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