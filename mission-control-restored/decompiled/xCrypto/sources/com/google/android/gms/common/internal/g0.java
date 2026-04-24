package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.common.zzh;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends zzh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0925c f9916a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(AbstractC0925c abstractC0925c, Looper looper) {
        super(looper);
        this.f9916a = abstractC0925c;
    }

    public static final void a(Message message) {
        h0 h0Var = (h0) message.obj;
        h0Var.b();
        h0Var.e();
    }

    public static final boolean b(Message message) {
        int i4 = message.what;
        return i4 == 2 || i4 == 1 || i4 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f9916a.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i4 = message.what;
        if ((i4 == 1 || i4 == 7 || ((i4 == 4 && !this.f9916a.enableLocalFallback()) || message.what == 5)) && !this.f9916a.isConnecting()) {
            a(message);
            return;
        }
        int i5 = message.what;
        if (i5 == 4) {
            this.f9916a.zzC = new C1984b(message.arg2);
            if (AbstractC0925c.zzo(this.f9916a)) {
                AbstractC0925c abstractC0925c = this.f9916a;
                if (!abstractC0925c.zzD) {
                    abstractC0925c.c(3, null);
                    return;
                }
            }
            AbstractC0925c abstractC0925c2 = this.f9916a;
            C1984b c1984b = abstractC0925c2.zzC != null ? abstractC0925c2.zzC : new C1984b(8);
            this.f9916a.zzc.b(c1984b);
            this.f9916a.onConnectionFailed(c1984b);
            return;
        }
        if (i5 == 5) {
            AbstractC0925c abstractC0925c3 = this.f9916a;
            C1984b c1984b2 = abstractC0925c3.zzC != null ? abstractC0925c3.zzC : new C1984b(8);
            this.f9916a.zzc.b(c1984b2);
            this.f9916a.onConnectionFailed(c1984b2);
            return;
        }
        if (i5 == 3) {
            Object obj = message.obj;
            C1984b c1984b3 = new C1984b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f9916a.zzc.b(c1984b3);
            this.f9916a.onConnectionFailed(c1984b3);
            return;
        }
        if (i5 == 6) {
            this.f9916a.c(5, null);
            AbstractC0925c abstractC0925c4 = this.f9916a;
            if (abstractC0925c4.zzw != null) {
                abstractC0925c4.zzw.c(message.arg2);
            }
            this.f9916a.onConnectionSuspended(message.arg2);
            AbstractC0925c.zzn(this.f9916a, 5, 1, null);
            return;
        }
        if (i5 == 2 && !this.f9916a.isConnected()) {
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
