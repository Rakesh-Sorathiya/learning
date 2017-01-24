/**
 * 
 */
'use strict';

angular
		.module('bookingTime')
		.component(
				'bookingTime',
				{

					templateUrl : 'angular/app/room-search-detail/booking-date/booking-time.template.html',
					controller : [
							'fetchOccupancy',
							function bookingTimeController($fetchOccupancy) {

								$fetchOccupancy.roomSearchInfo.time = {};

								this.hrArray = [ '01', '02', '03', '04', '06',
										'07', '08', '09', '10', '11', '12' ];
								this.minArray = [ '00', '15', '30' ];

							} ]

				});
