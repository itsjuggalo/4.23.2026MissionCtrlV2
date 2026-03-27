package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f15018a;

    public /* synthetic */ i0(k0 k0Var, j0 j0Var) {
        this.f15018a = k0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i8 = message.what;
        if (i8 == 0) {
            synchronized (this.f15018a.f15019g) {
                try {
                    g0 g0Var = (g0) message.obj;
                    h0 h0Var = (h0) this.f15018a.f15019g.get(g0Var);
                    if (h0Var != null && h0Var.i()) {
                        if (h0Var.j()) {
                            h0Var.g("GmsClientSupervisor");
                        }
                        this.f15018a.f15019g.remove(g0Var);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i8 != 1) {
            return false;
        }
        synchronized (this.f15018a.f15019g) {
            try {
                g0 g0Var2 = (g0) message.obj;
                h0 h0Var2 = (h0) this.f15018a.f15019g.get(g0Var2);
                if (h0Var2 != null && h0Var2.a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(g0Var2), new Exception());
                    ComponentName componentNameB = h0Var2.b();
                    if (componentNameB == null) {
                        componentNameB = g0Var2.a();
                    }
                    if (componentNameB == null) {
                        String strC = g0Var2.c();
                        AbstractC1294n.j(strC);
                        componentNameB = new ComponentName(strC, FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE);
                    }
                    h0Var2.onServiceDisconnected(componentNameB);
                }
            } finally {
            }
        }
        return true;
    }
}
