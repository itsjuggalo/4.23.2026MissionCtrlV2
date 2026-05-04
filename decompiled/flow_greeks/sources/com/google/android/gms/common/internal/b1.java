package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.common.zzg;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends zzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f5663a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(c cVar, Looper looper) {
        super(looper);
        Objects.requireNonNull(cVar);
        this.f5663a = cVar;
    }

    public static final void a(Message message) {
        c1 c1Var = (c1) message.obj;
        if (c1Var != null) {
            c1Var.c();
        }
    }

    public static final boolean b(Message message) {
        int i10 = message.what;
        return i10 == 2 || i10 == 1 || i10 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        c cVar = this.f5663a;
        if (cVar.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i10 = message.what;
        if ((i10 == 1 || i10 == 7 || ((i10 == 4 && !cVar.enableLocalFallback()) || message.what == 5)) && !cVar.isConnecting()) {
            a(message);
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            cVar.zzn(new m5.b(message.arg2));
            if (cVar.zzg() && !cVar.zzo()) {
                cVar.zzd(3, null);
                return;
            }
            m5.b bVarZzm = cVar.zzm() != null ? cVar.zzm() : new m5.b(8);
            cVar.zzc.d(bVarZzm);
            cVar.onConnectionFailed(bVarZzm);
            return;
        }
        if (i11 == 5) {
            m5.b bVarZzm2 = cVar.zzm() != null ? cVar.zzm() : new m5.b(8);
            cVar.zzc.d(bVarZzm2);
            cVar.onConnectionFailed(bVarZzm2);
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            m5.b bVar = new m5.b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            cVar.zzc.d(bVar);
            cVar.onConnectionFailed(bVar);
            return;
        }
        if (i11 == 6) {
            cVar.zzd(5, null);
            if (cVar.zzk() != null) {
                cVar.zzk().onConnectionSuspended(message.arg2);
            }
            cVar.onConnectionSuspended(message.arg2);
            cVar.zze(5, 1, null);
            return;
        }
        if (i11 == 2 && !cVar.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((c1) message.obj).b();
            return;
        }
        int i12 = message.what;
        StringBuilder sb2 = new StringBuilder(String.valueOf(i12).length() + 34);
        sb2.append("Don't know how to handle message: ");
        sb2.append(i12);
        Log.wtf("GmsClient", sb2.toString(), new Exception());
    }
}
