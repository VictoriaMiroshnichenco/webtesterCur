<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>question</th>
					<th>Created</th>
					<th>Updated</th>
					<th>Active</th>
					<th>Detail</th>
				</tr>

			</thead>
			<tbody>
 <c:forEach var="question" items="${questions }">
	        			<tr>
	        			
	        			<td>
	        			${question.question }
	        			</td>
	        			<td>
	        			${question.created }
	        			</td>
	        			<td>
	        			${question.updated}
	        			</td>
	        			
	        			<td>
	        			${question.active}
	        			</td>
	        			
	        			
	        			
	        			<td>
	        			<a href="${context }/tutor/viewQuestion?questionId=${question.id}" >
	        			Detail
	        			</a>
	        			</td>
	        			
	        		</c:forEach>
			</tbody>
		</table>

	</div>