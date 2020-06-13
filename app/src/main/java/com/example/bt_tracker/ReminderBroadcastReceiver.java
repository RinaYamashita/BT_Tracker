package com.example.bt_tracker;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // An Intent broadcast
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "BT_Tracker_Channel")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Notification from BT Tracker")
                .setContentText("Please log your body temperature now")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(200, builder.build()); // ID could be any number

        Intent notificationIntent  = new Intent(context,LogActivity.class);
        PendingIntent contentIntent =PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Resources res = context.getResources();
        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(context);
        builder1.setContentIntent(contentIntent)
                .setTicker("Please log your body temperature now")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true);
        Notification n = builder.getNotification();

        n.defaults = Notification.DEFAULT_ALL;
        nm.notify(0, n);
    }
}

