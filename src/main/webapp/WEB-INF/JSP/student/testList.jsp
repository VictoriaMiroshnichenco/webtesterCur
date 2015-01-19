<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="container">
<p>Student</p>
	<p>Test list</p>

	 <table style="width:300px;margin:0 auto;" border="1">
	
	 <c:forEach var="test" items="${tests }">
	        			<tr>
	        			
	        			<td>
	        			
	        			 <a href="${context }/student/test?testId=${test.idTest }">
	        			
	        			${test.name }
	        			</a>
	        			</td>
	        			
	        			
	        			
	        			
	        			</tr>
	        		</c:forEach>
	 </table>
	 	 
	 <a href="${context }/student/home">
	Home
	</a>
</div>
