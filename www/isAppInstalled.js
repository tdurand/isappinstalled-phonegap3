/**
 *  isappinstalled.js
 *  Cordova isappinstalled Plugin for Android
 */

var IsAppInstalled = function () {

};

IsAppInstalled.prototype = {
    /**
     * Open the Android share dialog.
     */
	packageName: function (packageName, success, fail) {
        return cordova.exec( function(args) { success(args); }, function(args) { fail(args); }, 'IsAppInstalled', 'isappinstalled', [packageName]);
	}
};

var isAppInstalled = new IsAppInstalled();

module.exports = isAppInstalled;
