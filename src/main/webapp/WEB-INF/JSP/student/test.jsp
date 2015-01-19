<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="container">
<p>Student</p>
	<p>Test list</p>

	<table style="width: 300px; margin: 0 auto;" border="1">
		<tr>
			<p>${test.name }</p>
		</tr>
		<tr>
			<p>${test.description }</p>
		</tr>
	</table>
	<table style="width: 300px; margin: 0 auto;" border="1">
	<tr>
	<a href="${context }/student/testList">
	Back to test list
	</a>
	</tr>
	<tr>
	<a href="${context }/student/home">
	Home
	</a>
	</tr>
	<tr>
	<a href="${context }/student/testQuestion?testId=${test.idTest }&count=0">
	Start
	</a>
	</tr>
	</table>
</div>
