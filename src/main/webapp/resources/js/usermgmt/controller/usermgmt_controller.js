'use strict';

/* Controller  : User Management Controllers */

var usermgmtController = angular.module('usermgmtController', []);

usermgmtController.controller('socUserCtrl', [ '$scope','$filter' ,'fileReader' ,'socUserService' ,
		function($scope, $filter, fileReader, socUserService) {

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
				profileImage : '',
				endDate : ''
			};

			$scope.getUserName = function(){
				self.socUser.userName = angular.lowercase(self.socUser.firstName + self.socUser.lastName);
			};
			
			
			$scope.calAgreementEndDate = function(){
				if(self.socUser.isOwner == 'tenant'){
					var selStartDate = new Date(self.socUser.startDate);
					selStartDate.setMonth(selStartDate.getMonth() + 11);
					selStartDate.setDate(selStartDate.getDate() - 1);
				    self.socUser.endDate = $filter('date')(selStartDate, "MM/dd/yyyy");
				}
				else {
					return;
				}
			};
			
			// File Upload functions
		     console.log(fileReader)
		     $scope.getFile = function () {
		         $scope.progress = 0;
		         fileReader.readAsDataURL($scope.file, $scope).then(function(result) {
		        	 $scope.imageSrc = result;
		        	 self.socUser.profileImage = result;
		         });
		     };
		  
		     $scope.$on("fileProgress", function(e, progress) {
		         $scope.progress = progress.loaded / progress.total;
		     });
			
		    // User Management controller functions 
			self.getAllUsers = function() {
				socUserService.getAllUsers().then(function(responseData) {
					console.log(responseData);
					$("#grid").kendoGrid({
					    dataSource: {
					        transport: {
					            read:  $('#context').val()+"/user/viewAll",
					            dataType: "Json"
					        },
					        pageSize: 10
					    },
					    height: 325,
					    sortable: true,
					    pageable: {
					        refresh: true,
					        pageSizes: true,
					        buttonCount: 5
					    },
					    columns: [
					       {
					        template: "<div align=right><a href='"+ $('#context').val()+"/user/view/#: userId #'> #: userId #</a></div>",
					        field: "userId",
					        title: "Id",
					        width: 50
					    }, {
					        template: "<div class='customer-photo' style='background-image: url(data:image/JPEG;base64,#: profileImage #);'></div> <div class='customer-name'>#: firstName # #: lastName #</div>",
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
					self.reset();
					$scope.message = "User name : " + response.userName + " - is created successfully";
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
			
			// Get User Details based on user Id
			self.viewUserDetails = function(userId){
				socUserService.viewUserDetails(userId).then(function(response) {
					console.log('User Details', response);
				}, function(errResponse) {
					console.error('Error while viewing the User Details.');
				});
			}
			
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
						profileImage : '',
						endDate : ''
					};
	              $scope.socUserMaintain.$setPristine(); //reset Form
	          };

			self.getAllUsers();
		} ]);