package com.cordova.plugins.ringermode;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.AudioManager;


public class RingerMode extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callback_context) throws JSONException {
    if (action.equals("getMode")) {
      this.getMode(callback_context);
      return true;
    }
    return false;
  }

  private void getMode(CallbackContext callback_context) {
    Context context = this.cordova.getActivity().getApplicationContext();
    AudioManager audio_manager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

    switch (audio_manager.getRingerMode()) {
    case AudioManager.RINGER_MODE_SILENT:
      callback_context.success("RINGER_MODE_SILENT");
      break;
    case AudioManager.RINGER_MODE_VIBRATE:
      callback_context.success("RINGER_MODE_VIBRATE");
      break;
    case AudioManager.RINGER_MODE_NORMAL:
      callback_context.success("RINGER_MODE_NORMAL");
      break;
    }
  }
}
