package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class U implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V f5224a;

    public /* synthetic */ U(V v2) {
        this.f5224a = v2;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f5224a.f5225d) {
                try {
                    S s6 = (S) message.obj;
                    T t6 = (T) this.f5224a.f5225d.get(s6);
                    if (t6 != null && t6.f5218a.isEmpty()) {
                        if (t6.f5220c) {
                            t6.f5223g.f5226f.removeMessages(1, t6.e);
                            V v2 = t6.f5223g;
                            v2.f5227g.c(v2.e, t6);
                            t6.f5220c = false;
                            t6.f5219b = 2;
                        }
                        this.f5224a.f5225d.remove(s6);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.f5224a.f5225d) {
            try {
                S s7 = (S) message.obj;
                T t7 = (T) this.f5224a.f5225d.get(s7);
                if (t7 != null && t7.f5219b == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(s7)), new Exception());
                    ComponentName componentName = t7.f5222f;
                    if (componentName == null) {
                        componentName = s7.f5216c;
                    }
                    if (componentName == null) {
                        String str = s7.f5215b;
                        I.g(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    t7.onServiceDisconnected(componentName);
                }
            } finally {
            }
        }
        return true;
    }
}
