package e3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: e3.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0534D extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RunnableC0535E f6094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RunnableC0535E f6095b;

    public C0534D(RunnableC0535E runnableC0535E, RunnableC0535E runnableC0535E2) {
        this.f6095b = runnableC0535E;
        this.f6094a = runnableC0535E2;
    }

    public final void a() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        RunnableC0535E runnableC0535E = this.f6095b;
        runnableC0535E.f6099a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        try {
            RunnableC0535E runnableC0535E = this.f6094a;
            if (runnableC0535E == null) {
                return;
            }
            if (runnableC0535E.d()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                RunnableC0535E runnableC0535E2 = this.f6094a;
                runnableC0535E2.f6102d.f6091f.schedule(runnableC0535E2, 0L, TimeUnit.SECONDS);
                context.unregisterReceiver(this);
                this.f6094a = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
