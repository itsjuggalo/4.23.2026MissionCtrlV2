package com.google.firebase.sessions;

import W2.E;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SessionLifecycleServiceBinderImpl implements SessionLifecycleServiceBinder {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "LifecycleServiceBinder";
    private final Context appContext;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    public SessionLifecycleServiceBinderImpl(Context appContext) {
        r.f(appContext, "appContext");
        this.appContext = appContext;
    }

    private final Object unbindServiceSafely(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return E.f5463a;
        } catch (IllegalArgumentException e4) {
            return Integer.valueOf(Log.w(TAG, "Session lifecycle service binding failed.", e4));
        }
    }

    @Override // com.google.firebase.sessions.SessionLifecycleServiceBinder
    public void bindToService(Messenger callback, ServiceConnection serviceConnection) {
        boolean zBindService;
        r.f(callback, "callback");
        r.f(serviceConnection, "serviceConnection");
        Intent intent = new Intent(this.appContext, (Class<?>) SessionLifecycleService.class);
        Log.d(TAG, "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra(SessionLifecycleService.CLIENT_CALLBACK_MESSENGER, callback);
        intent.setPackage(this.appContext.getPackageName());
        try {
            zBindService = this.appContext.bindService(intent, serviceConnection, 65);
        } catch (SecurityException e4) {
            Log.w(TAG, "Failed to bind session lifecycle service to application.", e4);
            zBindService = false;
        }
        if (zBindService) {
            return;
        }
        unbindServiceSafely(this.appContext, serviceConnection);
        Log.i(TAG, "Session lifecycle service binding failed.");
    }
}
