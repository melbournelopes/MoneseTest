package com.demo.monesespecex.utilities;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {
    private static NotificationManager notificationManager;

    public static int getResourceId(Context context, String name) {
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable", context.getPackageName());
        return resourceId;
    }

    /**
     * Checks if the text is empty.
     *
     * @param edittext
     * @return boolean
     */
    public static boolean setError(EditText editText) {
        boolean flagError = false;
        if (TextUtils.isEmpty(editText.getText().toString().trim())) {
            editText.setError("Please fill this field!");
            flagError = true;
            editText.requestFocus();
        } else {
            editText.setError(null);
        }
        return flagError;
    }

    /**
     * Checks if Internet is present.
     *
     * @param context
     * @return boolean
     */
    public static boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Converts unix timestamp to String date.
     *
     * @param timestamp
     * @return string
     */
    public static String convertTimestampToDate(long timestamp){
        Calendar calendar = Calendar.getInstance();
        TimeZone tz = TimeZone.getDefault();
        calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+05:30"));
        java.util.Date currenTimeZone=new java.util.Date(timestamp * 1000);

        return sdf.format(currenTimeZone);
    }
}
