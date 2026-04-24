package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import l2.InterfaceC2324h;
import w0.ExecutorC2893k;

/* JADX INFO: loaded from: classes.dex */
public abstract class U {
    public static SharedPreferences b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    public static boolean c(Context context) {
        return b(context).getBoolean("proxy_notification_initialized", false);
    }

    public static boolean d(SharedPreferences sharedPreferences, boolean z7) {
        return sharedPreferences.contains("proxy_retention") && sharedPreferences.getBoolean("proxy_retention", false) == z7;
    }

    public static void f(Context context, boolean z7) {
        SharedPreferences.Editor editorEdit = b(context).edit();
        editorEdit.putBoolean("proxy_notification_initialized", z7);
        editorEdit.apply();
    }

    public static void g(final Context context, G g8, final boolean z7) {
        if (W1.l.g() && !d(b(context), z7)) {
            g8.l(z7).f(new ExecutorC2893k(), new InterfaceC2324h() { // from class: com.google.firebase.messaging.T
                @Override // l2.InterfaceC2324h
                public final void onSuccess(Object obj) {
                    U.h(context, z7);
                }
            });
        }
    }

    public static void h(Context context, boolean z7) {
        SharedPreferences.Editor editorEdit = b(context).edit();
        editorEdit.putBoolean("proxy_retention", z7);
        editorEdit.apply();
    }
}
