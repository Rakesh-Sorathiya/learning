/**
 * Register location list component along with it's associated controller and
 * template
 */

'use strict';

angular.module('location').component('location', {

	templateUrl : 'angular/app/room-search-detail/location-detail/location.template.html',

	controller : function locationController() {
		this.locations = [{
			name : 'All'
		}, {
			name : 'Cybage Towers'
		}, {
			name : 'Gandhinagr'
		}, {
			name : 'Hydrabad'
		}, {
			name : 'West Avenue'
		}];
	}
});