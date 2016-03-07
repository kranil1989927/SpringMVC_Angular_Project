'use strict';

/* Controller  : User Management Controllers */

var usermgmtController = angular.module('usermgmtController', []);

usermgmtController.controller('socUserCtrl', [ '$scope', 'socUserService',
		function($scope, socUserService) {
	
			this.getAllUsers = function() {
				socUserService.getAllUsers().then(function(responseData) {
					$scope.socusers = responseData;
				}, function(errResponse) {
					console.error('Error while fetching User Details');
				});
			};

			this.getAllUsers();
}]);