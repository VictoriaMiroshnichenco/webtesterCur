<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<
<c:if test="${requestScope.MODE=='view'}">
	<c:set var="disabled" scope="page" value="true" />
	<c:set var="action" scope="page" value="#" />
</c:if>
<c:if test="${requestScope.MODE=='create'}">
	<c:set var="disabled" scope="page" value="false" />
	<c:set var="action" scope="page" value="createTest" />
</c:if>
<c:if test="${requestScope.MODE=='edit'}">
	<c:set var="disabled" scope="page" value="false" />
	<c:set var="action" scope="page" value="editTest" />
</c:if>

<div align="left" class="container">


	<form:form method="POST" action="${action }" commandName="testForm">

		<table>
			<tr>
				<td colspan="2" class="errors"><form:errors path="*" /></td>
			</tr>
			<form:hidden path="idTest" />
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input disabled="${disabled }" path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">description</form:label></td>
				<td><form:textarea path="description" disabled="${disabled }"
						rows="5" cols="30"></form:textarea></td>

			</tr>
			<tr>
				<td><form:label path="time">time</form:label></td>
				<td><form:input disabled="${disabled }" path="time" /></td>
			</tr>
			<tr>
				<td><form:label path="created">created</form:label></td>
				<td><form:input disabled="true" path="created" /></td>
			</tr>
			<tr>
				<td><form:label path="updated">updated</form:label></td>
				<td><form:input disabled="true" path="updated" /></td>
			</tr>
			<tr>
				<td><form:label path="active">active</form:label></td>
				<td><form:checkbox disabled="${disabled }" path="active" /></td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${requestScope.MODE=='view'}">
						<td colspan="2" style="text-align: center;"><a
							href="${context }/advanced_tutor/edit">Edit</a></td>
					</c:when>

					<c:otherwise>
						<td colspan="2" style="text-align: center;"><input
							type="submit" name="save" value="Save" /></td>
					</c:otherwise>
				</c:choose>

				<td colspan="2" style="text-align: center;"><a
					href="${context }/advanced_tutor/addTest?testId=${test.id}">Add
						question</a></td>
				<td colspan="2" style="text-align: center;"><a
					href="${context }/advanced_tutor/testList">Cancel
					</a></td>
			</tr>
		</table>
	</form:form>
</div>
<%-- <jsp:include page="templates/footer.jsp" /> --%>