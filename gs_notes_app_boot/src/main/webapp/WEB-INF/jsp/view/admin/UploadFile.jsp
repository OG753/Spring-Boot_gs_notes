<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/adminHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
  <script src="<c:url value="/resources/js/UploadFile.js" />"></script>
<meta charset="ISO-8859-1">
<title>Import Notes file</title>
</head>
<body>
  <h2>File Upload</h2>
      <form  action ="uploadFile" method = "POST" enctype = "multipart/form-data">
      <br/> <br/>
         Please select a file to upload : 
         <input type = "file" name = "file" value = "Browse File" /> <br /> <br/>
         Press here to upload the file :
         <input type = "submit" value = "upload" /> <br/> 
         <c:forEach items="${Msg}" var="msg">
         <c:out value="${msg}" ></c:out><br> 
         </c:forEach>
         Do you want to save excel data into database ? <a href="saveData"><b>Yes</b></a> <a href="delete"><b>No</b></a>
      </form>
</body>
</html>