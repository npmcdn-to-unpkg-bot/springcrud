<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="springcurd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>::Spring CRUD::</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css" />
<style>
label.error {
	color: red;
}
</style>
</head>
<body ng-controller="BodyController">
	<div class="container-fliud">
		<nav class="navbar navbar-default navbar-primary">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">{{projectName}}</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="home">Home</a></li>
			</ul>
		</div>
		</nav>
		<div class="container-fluid">
			<div class="col-md-4">
				<div class="panel panel-primary" ng-controller="crudController">
					<div class="panel-heading">Create</div>
					<div class="panel-body">
						<form role="form" id="demoform" name="demoform" ui-jq="validate"
							ui-options="validationOpt">
							<div class="form-group mb25">
								<strong>Firstname</strong>
								<div>
									<input type="text" class="form-control" ng-model="firstname"
										name="firstname" placeholder="Firstname" required
										minlength="5">
								</div>
							</div>
							<div class="form-group mb25">
								<strong>Lastname</strong>
								<div>
									<input type="text" class="form-control" ng-model="lastname"
										name="lastname" placeholder="Lastname" required minlength="5">
								</div>
							</div>
							<div class="form-group pull-right">
								<label></label>
								<div>
									<button type="submit" class="btn btn-success mr10">Submit</button>
									<button type="reset" class="btn btn-warning">Reset</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="panel panel-primary" ng-controller="crudController">
					<div class="panel-heading">List</div>
					<div class="panel-body">
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>SlNo</th>
									<th>FirstName</th>
									<th>LastName</th>
									<th>Options</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="u in userlistdata" ng-include="getTemplate(u)">

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/ng-template" id="view.html">
		<td style="text-align: center">{{$index+1}}</td>
		<td>{{u.firstname}}</td>
		<td>{{u.lastname}}</td>
		<td>
			<span class="btn btn-success btn-sm" ng-click="edit(u)">
				<i class="fa fa-edit"></i>
            </span> 
			<span class="btn btn-warning btn-sm" ng-click="deleteuser(u)">
				<i class="fa fa-trash"></i>
			</span>
		</td>
	</script>
	<script type="text/ng-template" id="edit.html">
		<td style="text-align: center">{{$index+1}}</td>
		<td><input type="text" class="form-control input-sm" ng-model="selected.firstname" value="{{u.firstname}}"/></td>
		<td><input type="text" class="form-control input-sm" ng-model="selected.lastname" value="{{u.lastname}}"></td>
		<td>
			<span class="btn btn-success btn-sm" ng-click="save()">
  				<i class="fa fa-save"></i>
			</span>
			<span class="btn btn-warning btn-sm" ng-click="cancel()">
				<i class="fa fa-remove"></i>
			</span>
		</td>
	</script>

	<script type="text/javascript" src="assets/jQuery/jQuery-2.2.0.min.js"></script>
	<script type="text/javascript"
		src="assets/angular-1.5.7/angular.min.js"></script>
	<script type="text/javascript"
		src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/ui-bootstrap-tpls.min.js"></script>
	<script type="text/javascript" src="assets/jquery.validate.min.js"></script>
	<script type="text/javascript" src="assets/angular-ui-utils.min.js"></script>
	<script type="text/javascript" src="assets/angularjs/app.js"></script>
</body>
</html>