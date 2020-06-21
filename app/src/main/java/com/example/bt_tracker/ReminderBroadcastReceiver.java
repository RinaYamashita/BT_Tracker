package com.example.bt_tracker;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.util.Log;

public class ReminderBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String TAG = "onReceive";
        // TODO: This method is called when the BroadcastReceiver is receiving
        // An Intent broadcast
        Intent notificationIntent  = new Intent(context,LogActivity.class);
        PendingIntent contentIntent =PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Log.d(TAG, "start building notification");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "BT_Tracker_Channel")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Notification from BT Tracker")
                .setContentText("Please log your body temperature now")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(contentIntent);
        Log.d(TAG, "finish building notification");


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        Log.d(TAG, "start firing notification");
        notificationManager.notify(200, builder.build());
        // ID could be any number
        Log.d(TAG, "notification fired");
    }
}

