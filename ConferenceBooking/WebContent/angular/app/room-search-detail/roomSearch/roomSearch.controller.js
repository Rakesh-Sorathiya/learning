/**
 * search room on click event of show occupancy button
 */

angular.module('roomSearch').controller('roomSearchController',
		[ '$scope', function($scope) {
			$scope.roomSearchInfo = {};
			
			$scope.showOccupancy = function (roomSearchInfo) {
				alert("Hello How are you !!!"	);
				$scope.roomSearchInfo = angular.copy(roomSearchInfo);
			};

		} ]);