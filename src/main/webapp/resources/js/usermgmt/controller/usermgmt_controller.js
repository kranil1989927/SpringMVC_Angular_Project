'use strict';

/* Controller  : User Management Controllers */

var usermgmtController = angular.module('usermgmtController', []);

usermgmtController.controller('socUserCtrl', [ '$scope', 'socUserService',
		function($scope, socUserService) {

			var self = this;
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

			self.getAllUsers = function() {
				socUserService.getAllUsers().then(function(responseData) {
					/*$("#grid").kendoGrid({
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
					        //template: "<div class='customer-photo' style='background-image: url(../content/web/Customers/#:data.CustomerID#.jpg);'></div> <div class='customer-name'>#: ContactName #</div>",
					        field: "firstName",
					        title: "Name",
					        width: 240
					    }, {
					        field: "address",
					        title: "Address"
					    }, {
					        field: "lastName",
					        title: "Owner"
					    }, {
					        field: "emailId",
					        title: "Email Id",
					        width: 150
					    }]
					});*/

					$scope.socusers = responseData;
				}, function(errResponse) {
					console.error('Error while fetching User Details');
				});
			};

			self.createSocUser = function(socUser) {
				socUserService.createSocUser(socUser).then(
				//console.log("Success"),
				function(errResponse) {
					console.error('Error while creating User.');
				});
			};

			self.submit = function() {
				if (self.socUser.userId == null) {
					console.log('Saving New User', self.socUser);
					self.createSocUser(self.socUser);
				} else {
					//self.updateUser(this.socUser, this.socUser.id);
					console.log('User updated with id ', this.socUser.id);
				}
			};

			self.getAllUsers();
		} ]);