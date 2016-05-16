var exec = require('cordova/exec');

exports.alert = function(text, theme) {
	function callback() {
		console.log('This text: "' + text + '" was alerted.');
	}
	var themeNumber;

	switch (theme) {
		case("dark") :
			themeNumber = 1;
			break;
		case("light") :
			themeNumber = 2;
			break;
		case("holo_light") :
			themeNumber = 3;
			break;
		case("holo_dark") :
			themeNumber = 4;
			break;
		default :
			themeNumber = 5;
			break;
	}

	exec(callback, null, 'FlowerAlert', 'alert', [text, themeNumber]);
};

