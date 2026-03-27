package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;
import y1.AbstractC1939b;
import y1.C1938a;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends AbstractC1939b {
    private static final String TAG = "FirebaseMessaging";

    private static Intent createServiceIntent(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // y1.AbstractC1939b
    public int onMessageReceive(Context context, C1938a c1938a) {
        try {
            return ((Integer) Tasks.await(new FcmBroadcastProcessor(context).process(c1938a.i()))).intValue();
        } catch (InterruptedException | ExecutionException e4) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e4);
            return 500;
        }
    }

    @Override // y1.AbstractC1939b
    public void onNotificationDismissed(Context context, Bundle bundle) {
        Intent intentCreateServiceIntent = createServiceIntent(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle);
        if (MessagingAnalytics.shouldUploadScionMetrics(intentCreateServiceIntent)) {
            MessagingAnalytics.logNotificationDismiss(intentCreateServiceIntent);
        }
    }
}
