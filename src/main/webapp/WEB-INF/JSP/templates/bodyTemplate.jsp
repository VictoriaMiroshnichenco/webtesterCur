<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">Create new Test</h1>

      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label for="inputName" class="col-sm-2 control-label">Test title<sup>*</sup></label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputName" placeholder="Test title">
          </div>
        </div>
        <div class="form-group">
          <label for="inputDesc" class="col-sm-2 control-label">Description<sup>*</sup></label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputDesc" placeholder="Enter Description">
          </div>
        </div>
        <div class="form-group">
          <label for="inputTime" class="col-sm-2 control-label">Question time</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputTime" placeholder="Enter Time per Question (sec). Default: 30 sec" maxlength="4">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Create Test</button>
          </div>
        </div>
      </form>
    </div>

</body>
</html>