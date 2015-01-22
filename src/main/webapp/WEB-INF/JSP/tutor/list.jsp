<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Created</th>
					<th>Updated</th>
					<th>Active</th>
					<th>Owner</th>
					<th>Detail</th>
				</tr>

			</thead>
			<tbody>
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
	        			<a href="${context }/tutor/viewTest?testId=${test.id}" >
	        			Detail
	        			</a>
	        			</td>
	        			
	        		</c:forEach>
			</tbody>
		</table>

	</div>