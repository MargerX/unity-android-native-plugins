package com.admix.idfa;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class IDFAController {

    private static final IDFAController _instance = new IDFAController();
    private static final String LOGTAG = "AdmixIDFA";

    private Context context;

    public static IDFAController getInstance() {
        return _instance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private IDFAController() {
        Log.i(LOGTAG, "Created IDFAController");
    }

    public void RequestData() throws Exception {
        try {
            AdvertisingIdClient.AdInfo info = AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (Exception e) {
            Log.e(LOGTAG, "Ooops cant get access to info");
        }
    }


    public void getIDFA() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    AdvertisingIdClient.AdInfo adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                    String myId = adInfo != null ? adInfo.getId() : null;
                    Log.i(LOGTAG, myId);

                } catch (Exception e) {
                    Toast toast = Toast.makeText(context, "error occurred ", Toast.LENGTH_SHORT);
                    toast.setGravity(0, 0, 0);
                    toast.show();
                }
            }
        });
    }
}
