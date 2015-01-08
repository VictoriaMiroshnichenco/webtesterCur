<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="container">
<p>Manage users</p>
	<p>Users list</p>
	<td colspan="2" class="errors">${error }</td>
	 <table style="width:300px;margin:0 auto;" border="1">
	 <tr>
	 <th>
	        			Login
	        			</th>
	        			<th>
	        			Name 
	        			</th>
	        			<td>
	        			Email
	        			</th>
	        			<th>
	        			Roles
	        			</th>
	        			<th>
	        			Active
	        			</th>
	        			<th>
	        			Created
	        			</th>
	        			<th>
	        			Updated
	        			</th>
	        			<th>
	        			Edit
	        			</th>
	        			<th>
	        			Delete
	        			</th>
	        			<th>
	        			Activate/Deactivate
	        			</th>
	        			
	 </tr>
	 <c:forEach var="user" items="${users }">
	        			<tr>
	        			
	        			<td>
	        			${user.login }
	        			</td>
	        			<td>
	        			${user.name }
	        			</td>
	        			<td>
	        			${user.email}
	        			</td>
	        			<td>
	        			<c:forEach var="role" items="${user.accountRoles}">
										${role.role.name}<br/>
										</c:forEach>
	        			</td>
	        			<td>
	        			${user.active}
	        			</td>
	        			<td>
	        			${user.created}
	        			</td>
	        			<td>
	        			${user.updated}
	        			</td>
	        			
	        			<td>
	        			<a href="${context }/admin/edit?userId=${user.id}" >
	        			Edit
	        			</a>
	        			</td>
	        			<td>
	        			<a href="${context }/admin/delete?userId=${user.id}" onclick="return confirm('Are you shure?')">
	        			Delete
	        			</a>
	        			</td>
	        			<td>
	        			Activate/Deactivate
	        			</td>
	        			
	        			</tr>
	        		</c:forEach>
	 </table>
</div>
