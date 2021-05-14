package com.admix.didomigdpr;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;

public class GdprStringController {

    private static final GdprStringController _instance = new GdprStringController();
    private static final String LOGTAG = "AdmixGDPR";

    private Context context;

    public static GdprStringController getInstance() {
        return _instance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private GdprStringController() {
        Log.i(LOGTAG, "Created GdprStringController");
    }

    public String GetGdprString() {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("IABTCF_TCString", null);
    }

}
