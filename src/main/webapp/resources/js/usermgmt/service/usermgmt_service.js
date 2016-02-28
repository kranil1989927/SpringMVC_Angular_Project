'use strict';

/* Service  : User Management Service */

var usermgmtService = angular.module('usermgmtService', []);

usermgmtService.factory('socUserService', ['$http','$q', function($http, $q){
	return {
		getAllUsers : function(){
			return $http.get('http://localhost:9082/socmaintain/user/viewAll')
			.then(
					function(response){
						return response.data;
					}, 
                    function(errResponse){
                    	console.error('Error while fetching users');
                    	return $q.reject(errResponse);
                    }
			);
		}
	};
}])