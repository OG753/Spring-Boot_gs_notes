<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/adminHeader.jsp" />
<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<jsp:include page="../fragments/menu.jsp" />

		</div>
	</nav>






	<div>
		<h3>List De Filieres</h3>
	</div>

	<div>

    <table class="table">
			<thead>
				<tr>
					<th scope="col">Filiere</th>
					<th scope="col">Niveau</th>
					<th scope="col">Import</th>
				</tr>
			</thead>


			<c:forEach items="${flist}" var="fil"> 
			
				<tr><td><c:out value="${fil.titreFiliere}" /></td>
				<td>
				<c:forEach items="${niv}" var="niveau">
	            <c:if test="${niveau.titre.contains(fil.titreFiliere) && !niveau.titre.substring(niveau.titre.length() - 1).equals('3')}">
	            <c:out value="${niveau.titre}" /><br>
			    </c:if>
			    </c:forEach> 
			    </td>
			      
			    <td>
			     <a href="${pageContext.request.contextPath}/admin/GotoUpload">Upload</a>
			    </td>
			    </tr>
		    </c:forEach>
     </table>
	</div>
</div>
	
<jsp:include page="../fragments/adminfooter.jsp" />