<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7 "> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8 br-ie7"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9 br-ie8"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Webtester</title>
<!-- Bootstrap -->
<link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="${context}/resources/css/dopstyle.css" rel="stylesheet"
	media="screen">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css"
	href="${context}/resources/css/normalize.css?v=${CSS_JS_VERSION}" />
<link rel="stylesheet" type="text/css"
	href="${context}/resources/css/styles.css?v=${CSS_JS_VERSION}" />
</head>

<body class="style1">

	<div class="jumbotron">
		<div class="row">
			<!---------------------------------head-block---------------------------->
			<div class="col-md-12 head-block"></div>
			<!---------------------------------------------------------------------->
			<!---------------------------------top-menu----------------------------->
			<div class="col-md-12 top-menu">

				<nav class="navbar navbar-default  navbar-fixed" role="navigation">
					<div class="container-fluid">


						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">

							<ul class="nav navbar-nav navbar-right">
								<c:if test="${sessionScope.CURRENT_ACCOUNT!=null}">
									<li class="active"><p>
											You log in as
											<c:out value="${sessionScope.CURRENT_ACCOUNT.username}">
											</c:out>
										</p></li>
									<li class="active"><p>
											Granted Authorities:
											<c:forEach var="authority"
												items="${sessionScope.CURRENT_ACCOUNT.authorities }">
			${authority.authority }
			</c:forEach>
								</c:if>


								<li><a href="${context }/logout">Logout</a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">More <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="https://www.google.com.ua/">Help</a></li>
										<li class="divider"></li>
										<li><a href="#">About</a></li>
									</ul></li>
							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>

			</div>
			


					<section class="main">
					<div class="container-fluid">
  						<div class="row">
						<decorator:body />
						</div>
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${context}/resources/js/bootstrap.min.js"></script>



	<script
		src="${context}/resources/js/jquery-1.10.2.js?v=${CSS_JS_VERSION}"></script>
	<script>
		$(document).ready(function(){
	
		});
	</script>

</body>
</html>