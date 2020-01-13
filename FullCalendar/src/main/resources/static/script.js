$(document).ready(function() {
	$('#calendar').fullCalendar({
		header : {
			left : 'prev,next today',
			center : 'title',
			right : 'listDay,listWeek,month'
		},
		views : {
			listDay : {
				buttonText : 'list day'
			},
			listWeek : {
				buttonText : 'list week'
			}
		},
		displayEventTime : false,
		fixedWeekCount : false,
		height : 'parent',
		showNonCurrentDates : false,
		themeSystem : 'bootstrap4',
		weekNumberCalculation : 'ISO',
		navLinks : true,
		eventLimit : true,
		events : 'api'
	});
});