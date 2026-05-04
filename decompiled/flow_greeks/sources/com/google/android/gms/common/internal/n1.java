package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1 f5753a;

    public /* synthetic */ n1(o1 o1Var, byte[] bArr) {
        Objects.requireNonNull(o1Var);
        this.f5753a = o1Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            o1 o1Var = this.f5753a;
            synchronized (o1Var.f()) {
                try {
                    l1 l1Var = (l1) message.obj;
                    m1 m1Var = (m1) o1Var.f().get(l1Var);
                    if (m1Var != null && m1Var.g()) {
                        if (m1Var.d()) {
                            m1Var.a("GmsClientSupervisor");
                        }
                        o1Var.f().remove(l1Var);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        o1 o1Var2 = this.f5753a;
        synchronized (o1Var2.f()) {
            try {
                l1 l1Var2 = (l1) message.obj;
                m1 m1Var2 = (m1) o1Var2.f().get(l1Var2);
                if (m1Var2 != null && m1Var2.e() == 3) {
                    String strValueOf = String.valueOf(l1Var2);
                    StringBuilder sb2 = new StringBuilder(strValueOf.length() + 47);
                    sb2.append("Timeout waiting for ServiceConnection callback ");
                    sb2.append(strValueOf);
                    Log.e("GmsClientSupervisor", sb2.toString(), new Exception());
                    ComponentName componentNameI = m1Var2.i();
                    if (componentNameI == null) {
                        componentNameI = l1Var2.c();
                    }
                    if (componentNameI == null) {
                        String strB = l1Var2.b();
                        s.k(strB);
                        componentNameI = new ComponentName(strB, FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE);
                    }
                    m1Var2.onServiceDisconnected(componentNameI);
                }
            } finally {
            }
        }
        return true;
    }
}
