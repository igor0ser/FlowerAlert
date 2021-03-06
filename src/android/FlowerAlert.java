package com.epam.cordova.flower;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class FlowerAlert extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("alert")) {
            this.alert(args.getString(0), args.getInt(1), callbackContext);
            return true;
        } else {
            return false;
        }
    }

    public synchronized void alert(final String text, final int theme, final CallbackContext callbackContext) {
        final CordovaInterface cordova = this.cordova;
        final String title = "Ionic Flower Alert";
        final String button = "OK, THANKS!";
        final int themeNumber;
        switch (theme) {
            case(1) :
                themeNumber = AlertDialog.THEME_DEVICE_DEFAULT_DARK;
                break;
            case(2) :
                themeNumber = AlertDialog.THEME_DEVICE_DEFAULT_LIGHT;
                break;
            case(3) :
                themeNumber = AlertDialog.THEME_HOLO_LIGHT;
                break;
            case(4) :
                themeNumber = AlertDialog.THEME_HOLO_DARK;
                break;
            default :
                themeNumber = AlertDialog.THEME_TRADITIONAL;
                break;
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(cordova.getActivity(), themeNumber);

        builder.setMessage(text)
                .setTitle(title)
                .setNegativeButton(button,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .create()
                .show();

        callbackContext.success();
    }
}