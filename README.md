#isAppInstalled plugin android phonegap 3

Small plugin to check if an app is installed on a device, to use it:

    plugins.isAppInstalled.packageName("com.amazon.venezia",function(result) {
        if(result ==  "true") {
            //App is installed
        }
        else {
            //App is not installed on device
        }
    });