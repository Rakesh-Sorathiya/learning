/**
 * 
 */
'use strict';

angular
		.module('bookingDuration')
		.component(
				'bookingDuration',
				{

					templateUrl : 'angular/app/room-search-detail/booking-date/booking-duration.template.html',
					controller : ['fetchOccupancy',function bookingTimeController($fetchOccupancy) {

						$fetchOccupancy.roomSearchInfo.duration={};
						
						this.hrArray = [ '01', '02', '03', '04', '06', '07',
								'08', '09', '10', '11', '12' ];
						this.minArray = [ '00', '15', '30' ];

					}]

				});
