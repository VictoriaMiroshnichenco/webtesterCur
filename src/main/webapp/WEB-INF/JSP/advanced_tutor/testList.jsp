<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../templates/header.jsp" />
<div class="container">
	Hello, tutor!
	<p>TestList</p>
	<table style="width:300px;margin:0 auto;" border="1">
	 <tr>
	 <th>
	        			name
	        			</th>
	        			<th>
	        			created 
	        			</th>
	        			<td>
	        			updated
	        			</th>
	        			<th>
	        			active
	        			</th>
	        			<th>
	        			owner
	        			</th>
	        			<th>
	        			Detail
	        			</th>
	        			
	        			
	 </tr>
	 <c:forEach var="test" items="${tests }">
	        			<tr>
	        			
	        			<td>
	        			${test.name }
	        			</td>
	        			<td>
	        			${test.created }
	        			</td>
	        			<td>
	        			${test.updated}
	        			</td>
	        			
	        			<td>
	        			${test.active}
	        			</td>
	        			<td>
	        			${test.user.name}
	        			</td>
	        			
	        			
	        			<td>
	        			<a href="${context }/advanced_tutor/viewTest?testId=${test.id}" >
	        			Detail
	        			</a>
	        			</td>
	        			
	        		</c:forEach>
	 </table>
	<p><a href="${context }/advanced_tutor/create">Add new test</a></p>
</div>
