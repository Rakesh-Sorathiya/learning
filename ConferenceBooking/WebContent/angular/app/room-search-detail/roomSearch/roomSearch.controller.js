/**
 * search room on click event of show occupancy button
 */

angular.module('roomSearch').controller('roomSearchController',
		[ 'fetchOccupancy', '$scope', function($fetchOccupancy, $scope) {
			$fetchOccupancy.roomSearchInfo = {};

			$scope.showOccupancy = function(roomSearchInfo) {
				$fetchOccupancys.roomSearchInfo = angular.copy(roomSearchInfo);
             
			};

		} ]);