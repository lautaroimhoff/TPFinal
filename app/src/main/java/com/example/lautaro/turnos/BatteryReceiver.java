package com.example.lautaro.turnos;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Francisco on 7/2/2018.
 */

public class BatteryReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent arg1) {
        sendNotification(context);
    }

    private void sendNotification(Context context) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nm = (NotificationManager) context.getSystemService(ns);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        PendingIntent pi = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context.getApplicationContext())
                        .setContentIntent(pi)
                        .setContentTitle("Cargue el Telefono!")
                        .setContentText("La aplicacion podria no funcionar bien con menos del 15% de bateria");
        nm.notify(1, mBuilder.build());
    }
}
