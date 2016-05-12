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
			this.alert(args.getString(0), callbackContext);
			return true;
		} else {
			return false;
		}
	}

	public synchronized void alert(final String flowerName, final CallbackContext callbackContext) {
		final CordovaInterface cordova = this.cordova;
		final String text = "You added a new flower — " + flowerName + ". ";
		final String title = "Ionic Flower Alert";
		final String button = "OK, THANKS!";

		AlertDialog.Builder builder = new AlertDialog.Builder(cordova.getActivity(), AlertDialog.THEME_HOLO_LIGHT);

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


