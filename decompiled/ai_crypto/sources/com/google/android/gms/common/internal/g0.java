package com.google.android.gms.common.internal;

import P1.C0648b;
import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.common.zzh;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends zzh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1192c f11099a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(AbstractC1192c abstractC1192c, Looper looper) {
        super(looper);
        this.f11099a = abstractC1192c;
    }

    public static final void a(Message message) {
        h0 h0Var = (h0) message.obj;
        h0Var.b();
        h0Var.e();
    }

    public static final boolean b(Message message) {
        int i7 = message.what;
        return i7 == 2 || i7 == 1 || i7 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f11099a.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i7 = message.what;
        if ((i7 == 1 || i7 == 7 || ((i7 == 4 && !this.f11099a.enableLocalFallback()) || message.what == 5)) && !this.f11099a.isConnecting()) {
            a(message);
            return;
        }
        int i8 = message.what;
        if (i8 == 4) {
            this.f11099a.zzC = new C0648b(message.arg2);
            if (AbstractC1192c.zzo(this.f11099a)) {
                AbstractC1192c abstractC1192c = this.f11099a;
                if (!abstractC1192c.zzD) {
                    abstractC1192c.c(3, null);
                    return;
                }
            }
            AbstractC1192c abstractC1192c2 = this.f11099a;
            C0648b c0648b = abstractC1192c2.zzC != null ? abstractC1192c2.zzC : new C0648b(8);
            this.f11099a.zzc.b(c0648b);
            this.f11099a.onConnectionFailed(c0648b);
            return;
        }
        if (i8 == 5) {
            AbstractC1192c abstractC1192c3 = this.f11099a;
            C0648b c0648b2 = abstractC1192c3.zzC != null ? abstractC1192c3.zzC : new C0648b(8);
            this.f11099a.zzc.b(c0648b2);
            this.f11099a.onConnectionFailed(c0648b2);
            return;
        }
        if (i8 == 3) {
            Object obj = message.obj;
            C0648b c0648b3 = new C0648b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f11099a.zzc.b(c0648b3);
            this.f11099a.onConnectionFailed(c0648b3);
            return;
        }
        if (i8 == 6) {
            this.f11099a.c(5, null);
            AbstractC1192c abstractC1192c4 = this.f11099a;
            if (abstractC1192c4.zzw != null) {
                abstractC1192c4.zzw.b(message.arg2);
            }
            this.f11099a.onConnectionSuspended(message.arg2);
            AbstractC1192c.zzn(this.f11099a, 5, 1, null);
            return;
        }
        if (i8 == 2 && !this.f11099a.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((h0) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
