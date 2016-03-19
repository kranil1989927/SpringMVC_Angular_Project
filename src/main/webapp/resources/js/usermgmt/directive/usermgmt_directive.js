'use strict';

/* Directive  : User Management Directive for file select */

var usermgmtDirective = angular.module('usermgmtDirective', []);

usermgmtDirective.directive('ngFileSelect', function() {
	return {
		link : function($scope, el) {
			el.bind("change", function(e) {
				$scope.file = (e.srcElement || e.target).files[0];
				$scope.getFile();
			})
		}
	}
})