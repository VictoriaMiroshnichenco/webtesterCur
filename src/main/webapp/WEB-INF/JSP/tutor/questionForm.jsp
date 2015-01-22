<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:if test="${requestScope.MODE=='view'}">
	<c:set var="disabled" scope="page" value="true" />testForm.jsp
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

     
      
<form:form method="POST" action="addQuestion" commandName="questionForm" class="form-horizontal" role="form">

	<div class="form-group">

		<div class="errors">
			<form:errors path="*" />
		</div>
<form:hidden path="testId" />
	</div>
	<div class="form-group">
				<form:label class="col-sm-2 control-label" path="question">Question</form:label>
				<div class="col-sm-10">
				<form:textarea class="form-control" disabled="${disabled }" path="question" placeholder="Question"/>
				</div>
			</div>
			 <c:forEach var="answer" items="answers">
			 
			 <div class="form-group">
				<form:label class="col-sm-2 control-label" path="answers">Answer</form:label>
				<div class="col-sm-10">
				<form:textarea class="form-control"  path="answers" placeholder="Answer"/>
				</div>
			</div>
			 
			 </c:forEach>

 <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
			<c:if test="${requestScope.MODE=='create'}">
				<button type="submit" class="btn btn-primary">Save Question</button>
			</c:if>
			<c:if test="${requestScope.MODE=='edit'}">
				<button type="submit" class="btn btn-primary">Save Question</button>
			</c:if>
			<c:if test="${requestScope.MODE=='view'}">
				<p class="btn btn-primary" ><a href="${context }/tutor/addQuestion?testId=${test.id}">Add  answers</a></p>
			</c:if>

		</div>
				</div>
	</form:form>
	
     