var exec = require('cordova/exec');

exports.alert = function(flower) {

        function callback() {
            console.log(flower.name + ' was alerted.');
        }

        exec(callback, null, "FlowerAlert", "alert", [flower.name]);
};

