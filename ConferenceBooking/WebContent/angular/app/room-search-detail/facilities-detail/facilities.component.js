/**
 * Register facilities component along with it's associated controller and
 * template
 */

'use strict';

angular
		.module('facilities')
		.component(
				'facilities',
				{
					templateUrl : 'angular/app/room-search-detail/facilities-detail/facilities.template.html',
					controller : function facilitiesController() {
						this.facilities = [ {
							name : 'Network Point'
						}, {
							name : 'Projector'
						}, {
							name : 'Video Conferencing'
						} ];
					}
				});