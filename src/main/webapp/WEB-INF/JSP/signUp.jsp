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
	   <table>
	    <tr>
	        <td colspan="2" class="errors"><form:errors path="*"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="name">Name</form:label></td>
	        <td><form:input path="name" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="login">Login</form:label></td>
	        <td><form:input path="login" /></td>
	    </tr>
	    <tr>
	   <%--  <c:if test="${sessionScope.CURRENT_ACCOUNT != null}"> --%>
	        <td><form:label path="password">Password</form:label></td>
	        <td><form:hidden  path="password"/> </td>
	     <%--    </c:if> --%>
	    </tr>
	    <tr>
	        <td><form:label path="email">Email</form:label></td>
	        <td><form:input path="email" /></td>
	    </tr>
	    <tr>
	        <td colspan="2" style="text-align:center;">
	            <input type="submit" name = "save" value="Save"/>
	        </td>
	        <td colspan="2" style="text-align:center;">
	            <input type="submit" name = "cancel" value="Cancel"/>
	        </td>
	    </tr>
	</table>  
	</form:form>
</div>
<%-- <jsp:include page="templates/footer.jsp" /> --%>