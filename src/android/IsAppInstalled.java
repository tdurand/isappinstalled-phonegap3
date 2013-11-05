/**
 *  IsAppInstalled.java
 *  Cordova IsAppInstalled Plugin for Android
 */

package com.mosalingua.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.util.Log;
import android.net.Uri;

public class IsAppInstalled extends CordovaPlugin {
	
	@Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if ("isappinstalled".equals(action)) {
            boolean isAppInstalled = this.isPackageExisted(args.getString(0));
            if(isAppInstalled) {
                callbackContext.success(true);
            }
            else {
                callbackContext.success(false);
            }
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

    public boolean isPackageExisted(String targetPackage){
       PackageManager pm = getPackageManager();
       try {
        PackageInfo info = pm.getPackageInfo(targetPackage,PackageManager.GET_META_DATA);
           } catch (NameNotFoundException e) {
        return false;
        }  
        return true;
    }
}
