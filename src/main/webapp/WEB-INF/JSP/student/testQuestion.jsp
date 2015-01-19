<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">

	<p>time</p>
<form:form id="my_form" method="POST" action="processAnswer" commandName="testQuestionForm" >
	 <table style="width:300px;margin:0 auto;" border="1">
		<tr>
		<td>
		<b>${test.name }</b>
		</td></tr>
		<tr><td>
		<input type="text" name="count" value="${count }"/>
		</td></tr>
		<tr><td>
		<input type="text" name="testId" value="${test.idTest }"/>
		</td>
		</tr>
		<tr><td>
		${question.question }
		</td></tr>
		<tr>
		<td>Answers:
		</td></tr>

			<%-- <c:forEach var="answer" items="${answers }">
				<td><form:checkbox value="${answer.idAnswer }"></form:checkbox>
				</td>
				<td><form:label path="email">Email</form:label></td>
			</c:forEach>
			 --%>
			 <c:forEach var="answer" items="${answers }">
			 <tr align="left">
			  <td colspan="2" style="text-align:center;padding-top:20px;">
				<input type="checkbox" name="answerId" value="${answer.idAnswer }">${answer.text }<Br> 
				</td></tr>
			</c:forEach>
			
			<tr>
			<td>
			
			</td>
			</tr>

		</table>
		<table style="width: 300px; margin: 0 auto;" border="1">
			<tr>
				 <td colspan="2" style="text-align:center;padding-top:20px;">
	            <input type="submit" value="Next"/>
	        </td>
				 <td colspan="2" style="text-align:center;padding-top:20px;">
	            <input type="submit" value="Next"/>
	        </td>
			</tr>
		</table>
	</form:form>
	<table style="width:300px;margin:0 auto;" border="1">
	<tr>
	<td><a href="${context }/student/home">
	Home
	</a></td>
	</tr>
	</table>
	<script>
		$(document).ready(function(){
	
		});
		$(function() {
			$form = document.getElementById('my_form').value;
			form.delay(2000).submit();
		});
	</script>
	
</div>
