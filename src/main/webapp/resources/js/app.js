'use strict';

/* Society Maintenance Application Module */

var socUserMgmtApp = angular.module('socUserMgmtApp', ['ngRoute','usermgmtService','usermgmtController']);

socUserMgmtApp.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/user/search', {
		templateUrl:'/usermgmt/search.jsp',
		controller:'socUserCtrl'
	}).when('/user/add', {
		templateUrl:'/usermgmt/user.jsp',
		controller:'socUserCtrl'
	}).otherwise({
        redirectTo: '/user/search'
      });
}])