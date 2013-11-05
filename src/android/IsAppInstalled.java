/**
 *  IsAppInstalled.java
 *  Cordova IsAppInstalled Plugin for Android
 */

package com.mosalingua.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class IsAppInstalled extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if ("isappinstalled".equals(action)) {
            boolean isAppInstalled;
            try {
                isAppInstalled = this.isPackageInstalled(args.getString(0), cordova.getActivity().getApplicationContext());
                if(isAppInstalled) {
                    callbackContext.success("true");
                }
                else {
                    callbackContext.success("false");
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

    private boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
