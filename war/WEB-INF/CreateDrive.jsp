<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.adaptavant.windowExplorerSpringmvc.*" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
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
			<h1>Do you want to create a drive?</h1>
			<br>
			<br>
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">click
				to create a new drive</button>
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
						<h4 class="modal-title" id="myModalLabel">New Drive</h4>
					</div>

					<!-- *******************new folder creation action *******************************-->
					<form name="createdrive" action="/drivecreated" method="post">
					<p>${errorMessage}</p>
						<div class="modal-body">
							Drive Name:<input type="text" name="driveName"><br>
							<br> Drive Type:<select id="driveTypeOption"
								name="driveType">
								<option>System Folder</option>
								<option>File Folder</option>
								<option>Local Disk</option>
							</select><br><br> Drive File System:<select id="driveFileSystemOption"
								name="driveFileSystem">
								<option>NTFS</option>
								<option>FAT32</option>
								<option>HFS</option>
								<option>RAID</option>
							</select> <br><br>
							<%
		Drive drive = new Drive();
	
		if(request.getAttribute("drive")!=null){
		
			drive = (Drive)request.getAttribute("drive");
			
		}
		
	%>
							Free Space:<input type="text" value="<%=drive.getDriveFreeSpace() %>" name="freeSpace"> <br><br>
							Used Space:<input type="text" value="<%=drive.getDriveUsedSpace() %>" name="usedSpace"><br><br> 
							Capacity:<input type="text" value="50" name="capacity" > <br><br>
							
					 

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-default">submit</button>
						</div>
					</form>
					<!-- *******************END of new folder creation action *******************************-->
                  
				</div>
			</div>
		</div>
		
		
</body>
</html>