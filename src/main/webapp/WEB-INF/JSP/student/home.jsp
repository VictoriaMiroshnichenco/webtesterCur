<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="col-md-12 top-material">
	Hello, student!
	<p>
	<a href="${context }/student/edit">
	Edit profile
	</a>
	<p>
	<a href="${context }/student/testList">
	Choose test
	</a>
	</p>
	<p>
	<a href="${context }/student/resultList?userId=${sessionScope.CURRENT_ACCOUNT.idAccount}">
	Results
	</a>
	</p>
</div>
<jsp:include page="../templates/footer.jsp" />