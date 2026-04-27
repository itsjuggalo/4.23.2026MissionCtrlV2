package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: loaded from: classes.dex */
final class ProxyNotificationPreferences {
    private static final String FCM_PREFERENCES = "com.google.firebase.messaging";

    private ProxyNotificationPreferences() {
    }

    private static SharedPreferences getPreference(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    public static boolean isProxyNotificationInitialized(Context context) {
        return getPreference(context).getBoolean("proxy_notification_initialized", false);
    }

    public static boolean isProxyNotificationRetentionSet(SharedPreferences sharedPreferences, boolean z4) {
        return sharedPreferences.contains("proxy_retention") && sharedPreferences.getBoolean("proxy_retention", false) == z4;
    }

    public static void setProxyNotificationsInitialized(Context context, boolean z4) {
        SharedPreferences.Editor editorEdit = getPreference(context).edit();
        editorEdit.putBoolean("proxy_notification_initialized", z4);
        editorEdit.apply();
    }

    public static void setProxyRetention(final Context context, GmsRpc gmsRpc, final boolean z4) {
        if (G1.m.g() && !isProxyNotificationRetentionSet(getPreference(context), z4)) {
            gmsRpc.setRetainProxiedNotifications(z4).addOnSuccessListener(new l0.k(), new OnSuccessListener() { // from class: com.google.firebase.messaging.F
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    ProxyNotificationPreferences.setProxyRetentionPreferences(context, z4);
                }
            });
        }
    }

    public static void setProxyRetentionPreferences(Context context, boolean z4) {
        SharedPreferences.Editor editorEdit = getPreference(context).edit();
        editorEdit.putBoolean("proxy_retention", z4);
        editorEdit.apply();
    }
}
