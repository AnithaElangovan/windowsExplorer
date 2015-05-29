<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.adaptavant.windowExplorerSpringmvc.*" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h1>click to process?</h1>
			<br>
			<br>
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">click
		    </button>
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
						<h4 class="modal-title" id="myModalLabel">copy results</h4>
					</div>

					<!-- *******************new folder creation action *******************************-->
					<form name="copyresult" action="/" method="post">
					<p>${errorMessage}</p>
						<div class="modal-body">
						${errorMessage}
							<table>
                            <c:forEach items="${folderName}" var="name">
                            <tr>
                            <td>${name.folderName} <p>folder is copied</p></td>
                            </tr>
                            </c:forEach>
                            </table>
                            <table>
                            <c:forEach items="${fileName}" var="name1">
                            <tr>
                            <td>${name1.fileName}<p>file is copied</p></td>
                            </tr>
                            </c:forEach>
                            </table>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-default">ok</button>
						</div>
					</form>
					<!-- *******************END of new folder creation action *******************************-->
                  
				</div>
			</div>
		</div>
		
		
</body>
</html>