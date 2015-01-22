<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <jsp:include page="templates/header.jsp" /> --%>
<div class="container">

	<h2> User</h2>

	<form:form method="POST" action="signUp" commandName="signUpForm" >
	 <c:out value="Debug information"></c:out>
	 <c:out value="${requestScope.MODE}"></c:out>
	 <c:out value="${roles}"></c:out>
	   <table>
	    <tr>
	        <td colspan="2" class="errors"><form:errors path="*"/></td>
	    </tr>
	    <form:hidden path="idUser"/>
	    <tr>
	         <td><form:label path="name">Name</form:label></td>
	        <td><form:input path="name" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="login">Login</form:label></td>
	        <td><form:input path="login" /></td>
	    </tr>
			<tr>

				<c:if test="${requestScope.MODE == 'edit'}">
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" /></td>
				</c:if>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
			
			<td><form:label path="existsRoles">Has Roles</form:label></td>
			<td>
			<form:textarea readonly="true" path="existsRoles" rows="5" cols="30"></form:textarea>

			</td>
			</tr>
			<tr>
			
			<td><form:label path="userRoles">Roles</form:label></td>
			<td><form:select path="userRoles" multiple="true" size="4">
                                <c:forEach items="${userRoles}" var="role">
                                    <form:option value="${role.id}">${role.name}</form:option>
                                </c:forEach>
                            </form:select>
			 

<%-- <form:checkboxes items="${roles }" path="userRoles"/> --%>
	</td>
	<td>
<%--	<c:forEach var="role" items="${roles }">
	        			<form:checkbox  value="${role.idRole }" ></form:checkbox>
	        		</c:forEach>
	        		--%>
		
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" name="save" value="Save" /></td>
				<td colspan="2" style="text-align: center;"><input
					type="submit" name="cancel" value="Cancel" /></td>
			</tr>
		</table>  
	</form:form>
</div>
<%-- <jsp:include page="templates/footer.jsp" /> --%>