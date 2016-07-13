<html ng-app= "top">
<head>
	<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
	<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
	<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
	<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="angular.min.js"></script>
	<script src="top.js"></script>
<style>
.container-fluid {
	width : 30%;
	margin-right: auto;
	margin-left: auto;
}

#carousel-762850{
	margin-top: 0px;
	margin-bottom: 0px;
	}

.list-group-item-text {
	width : 100%;
}

.list-group-item-text td{
	width : 20%;
}

table img{
	width : 50%;
}

.show-app-detail{
	width : 100%;
}
.show-app-detail td{
	width : 25%;
	text-align: left;
}

.app-detail-img{
	margin-left : 25%;
	margin-top  : 10%;
	margin-bottom  : 10%;
}

.app-recom td{
	width : 20%;
}

.app-recom img{
	margin-left : 25%;
	margin-top  : 10%;
	margin-bottom  : 10%;
}
</style>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="carousel slide" id="carousel-762850" data-ride="carousel" >
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-762850">
					</li>
					<li data-slide-to="1" data-target="#carousel-762850">
					</li>
					<li data-slide-to="2" data-target="#carousel-762850">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="img/3.jpg" />
						<div class="carousel-caption">
							<h4>
								App Name Here
							</h4>
							<p>
								App Description Here
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/4.jpg" />
						<div class="carousel-caption">
							<h4>
								App Name Here
							</h4>
							<p>
								App Description Here
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/5.jpg" />
						<div class="carousel-caption">
							<h4>
								App Name Here
							</h4>
							<p>
								App Description Here
							</p>
						</div>
					</div>
				</div> 
				<a class="left carousel-control" data-slide="prev" href="#carousel-762850">&lsaquo;</a> 
				<a class="right carousel-control" data-slide="next" href="#carousel-762850">&rsaquo;</a>
			</div>
		</div>
	</div>
	<div class="row-fluid" ng-controller = "appList as apps">
		<div class="span12">
		
			<div class="list-group" ng-show = "!apps.showApp">
			
				<a href="#" class="list-group-item active" >Top 10 Apps</a>
				<div class="list-group-item" ng-repeat = "app in apps.appList">
					<table class="list-group-item-text">
						<tr>
							<td id = "show_appid" rowspan = "2">{{app.appid}}</td>
							<td id = "show_img" rowspan = "2"><img alt="app_img" ng-src="{{app.thumbnail_url}}"/></td>
							<td id = "show_appname" colspan="2">{{app.title}}</td>
							<td id = "get_appdetail" rowspan="2"><button class="btn btn-primary" type="button" ng-click="apps.selectApp(app)">GET</button> </td>
						</tr>
						<tr>
							<td id= "show_rate" colspan="2">rate:{{app.score}}/10</td>
						</tr>
					</table>
				</div>
				
			</div>
			
			<div class = "showApp" ng-show = "apps.showApp">
				<div class = list-group>
				<a href="#" class="list-group-item active" ng-click= "apps.goBackToMain()">Go Back</a>
				<div class="list-group-item">
					<table class="show-app-detail">
						<tr>
							<td rowspan = "3" colspan="1"><img class="app-detail-img" ng-src="{{apps.appToShow.thumbnail_url}}"/></td>
							<td colspan = "1"> {{apps.appToShow.appid}}</td>
						</tr>
						
						<tr>
							<td rowspan = "1" colspan = "1">{{apps.appToShow.title}}</td>
						</tr>
						
						<tr>
							<td colspan = "1">rate: {{apps.appToShow.score}}/10</td>
						</tr>
					</table>
				</div>
				<div class="list-group-item">
					<p>Customers Also Like:</p>
					<table class="app-recom">
						<tr >
							<td ng-repeat="appToRecom in apps.appsToRecom"><img ng-src="{{appToRecom.thumbnail_url}}"></td>
						</tr>
						
						<tr>
							<td ng-repeat="appToRecom in apps.appsToRecom">{{appToRecom.title}}</td>
						</tr>
					</table>
				</div>
				
				<div class="list-group-item">
					<div> <h4>Description:</h4> </div>
					<div>
						<p>
							{{apps.appToShow.intro}}
						</p>
					</div>
				</div>
			</div>
			</div>

		</div>
	</div>
</div>
</body>
</html>