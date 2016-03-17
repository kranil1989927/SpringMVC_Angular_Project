'use strict';

/* Controller  : User Management Controllers */

var usermgmtController = angular.module('usermgmtController', []);

usermgmtController.controller('socUserCtrl', [ '$scope', 'socUserService',
		function($scope, socUserService) {

			var self = this;
			$scope.isNew = false;
			self.socUser = {
				userId : null,
				firstName : '',
				middleName : '',
				lastName : '',
				userName : '',
				emailId : '',
				panNo : '',
				phoneNo : '',
				address : '',
				noOfMembers : '',
				isOwner : '',
				startDate : '',
				endDate : ''
			};

			$scope.getUserName = function(){
				self.socUser.userName = angular.lowercase(self.socUser.firstName + self.socUser.lastName);
			};
			
			self.getAllUsers = function() {
				socUserService.getAllUsers().then(function(responseData) {
					console.log(responseData);
					$("#grid").kendoGrid({
					    dataSource: {
					        transport: {
					            read:  $('#context').val()+"/user/viewAll",
					            dataType: "Json"
					        },
					        pageSize: 20
					    },
					    height: 400,
					    sortable: true,
					    pageable: {
					        refresh: true,
					        pageSizes: true,
					        buttonCount: 5
					    },
					    columns: [{
					    	//../content/web/Customers/#:data.CustomerID#.jpg
					        template: "<div class='customer-photo' style='background-image: url(../resources/images/profile.png);'></div> <div class='customer-name'>#: firstName #</div>",
					        field: "firstName",
					        title: "Name",
					        width: 200
					    }, {
					        field: "address",
					        title: "Address"
					    }, {
					        field: "lastName",
					        title: "Last Name",
						    width: 200
					    }, {
					        field: "emailId",
					        title: "Email Id",
					    }]
					});
				}, function(errResponse) {
					console.error('Error while fetching User Details');
				});
			};

			self.createSocUser = function(socUser) {
				socUserService.createSocUser(socUser).then(
				   function(response) {
					console.log('New User', response);
					self.getAllUsers();
					$scope.isNew = true;
					$scope.message = "User name : " + response.userName + " - is created successfully";
					self.reset();
				}, function(errResponse) {
					console.error('Error while creating User.');
				});
			};

			self.submit = function() {
				if (self.socUser.userId == null) {
					console.log('Saving New User', self.socUser);
					self.createSocUser(self.socUser);
				} else {
					console.log('User updated with id ', this.socUser.id);
				}
			};
			
			self.reset = function(){
				self.socUser = {
						userId : null,
						firstName : '',
						middleName : '',
						lastName : '',
						userName : '',
						emailId : '',
						panNo : '',
						phoneNo : '',
						address : '',
						noOfMembers : '',
						isOwner : '',
						startDate : '',
						endDate : ''
					};
	              $scope.socUserMaintain.$setPristine(); //reset Form
	          };

			self.getAllUsers();
		} ]);