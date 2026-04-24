package j1;

import android.content.Context;
import android.util.Log;
import j1.InterfaceC2199b;

/* JADX INFO: renamed from: j1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2202e implements InterfaceC2200c {
    @Override // j1.InterfaceC2200c
    public InterfaceC2199b a(Context context, InterfaceC2199b.a aVar) {
        boolean z7 = I.a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z7 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z7 ? new C2201d(context, aVar) : new n();
    }
}
