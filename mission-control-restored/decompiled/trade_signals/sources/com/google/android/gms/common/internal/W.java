package com.google.android.gms.common.internal;

import Q1.C0790b;
import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class W extends e2.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC1283c f14943b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(AbstractC1283c abstractC1283c, Looper looper) {
        super(looper);
        this.f14943b = abstractC1283c;
    }

    public static final void a(Message message) {
        X x8 = (X) message.obj;
        x8.b();
        x8.e();
    }

    public static final boolean b(Message message) {
        int i8 = message.what;
        return i8 == 2 || i8 == 1 || i8 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f14943b.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i8 = message.what;
        if ((i8 == 1 || i8 == 7 || ((i8 == 4 && !this.f14943b.enableLocalFallback()) || message.what == 5)) && !this.f14943b.isConnecting()) {
            a(message);
            return;
        }
        int i9 = message.what;
        if (i9 == 4) {
            this.f14943b.zzC = new C0790b(message.arg2);
            if (AbstractC1283c.zzo(this.f14943b)) {
                AbstractC1283c abstractC1283c = this.f14943b;
                if (!abstractC1283c.zzD) {
                    abstractC1283c.d(3, null);
                    return;
                }
            }
            AbstractC1283c abstractC1283c2 = this.f14943b;
            C0790b c0790b = abstractC1283c2.zzC != null ? abstractC1283c2.zzC : new C0790b(8);
            this.f14943b.zzc.a(c0790b);
            this.f14943b.onConnectionFailed(c0790b);
            return;
        }
        if (i9 == 5) {
            AbstractC1283c abstractC1283c3 = this.f14943b;
            C0790b c0790b2 = abstractC1283c3.zzC != null ? abstractC1283c3.zzC : new C0790b(8);
            this.f14943b.zzc.a(c0790b2);
            this.f14943b.onConnectionFailed(c0790b2);
            return;
        }
        if (i9 == 3) {
            Object obj = message.obj;
            C0790b c0790b3 = new C0790b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f14943b.zzc.a(c0790b3);
            this.f14943b.onConnectionFailed(c0790b3);
            return;
        }
        if (i9 == 6) {
            this.f14943b.d(5, null);
            AbstractC1283c abstractC1283c4 = this.f14943b;
            if (abstractC1283c4.zzw != null) {
                abstractC1283c4.zzw.onConnectionSuspended(message.arg2);
            }
            this.f14943b.onConnectionSuspended(message.arg2);
            AbstractC1283c.zzn(this.f14943b, 5, 1, null);
            return;
        }
        if (i9 == 2 && !this.f14943b.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((X) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
