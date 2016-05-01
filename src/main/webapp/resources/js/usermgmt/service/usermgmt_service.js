'use strict';

/* Service  : User Management Service */

var usermgmtService = angular.module('usermgmtService', []);

usermgmtService.factory('socUserService', ['$http','$q', function($http, $q){
	return {
		getAllUsers : function(){
			return $http.get('/socmaintain/user/viewAll')
			.then(
					function(response){
						return response.data;
					}, 
                    function(errResponse){
                    	console.error('Error while fetching users');
                    	return $q.reject(errResponse);
                    }
			);
		},
		
		createSocUser : function(socUser){
			return $http.post('/socmaintain/user/save',socUser )
			.then(
					function(response){
						console.log('New User', response);
						return response.data;
					}, 
                    function(errResponse){
                    	console.error('Error while saving users');
                    	return $q.reject(errResponse);
                    }
			);
		},
		
		viewUserDetails : function(userId){
			return $http.get('/socmaintain/user/viewuser/'+ userId)
			.then(
					function(response){
						console.log('User Details', response);
						return response.data;
					}, 
                    function(errResponse){
                    	console.error('Error while viewing the User Details.');
                    	return $q.reject(errResponse);
                    }
			);
		},
		
		deleteUserDetails : function(userId){
			return $http.get('/socmaintain/user/delete/'+ userId)
			.then(
					function(response){
						console.log('User Details is deleted successfully', response);
						return response.data;
					}, 
                    function(errResponse){
                    	console.error('Error while deleting the User Details.');
                    	return $q.reject(errResponse);
                    }
			);
		},
	};
}])