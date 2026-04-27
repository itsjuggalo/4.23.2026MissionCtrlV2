package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: loaded from: classes.dex */
public final class Q extends zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S f5121a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(S s6, Looper looper) {
        super(looper);
        this.f5121a = s6;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
                throw runtimeException;
            }
            Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i);
            return;
        }
        com.google.android.gms.common.api.q qVar = (com.google.android.gms.common.api.q) message.obj;
        synchronized (this.f5121a.f5123b) {
            try {
                S s6 = this.f5121a.f5122a;
                com.google.android.gms.common.internal.I.g(s6);
                if (qVar == null) {
                    s6.a(new Status(13, "Transform returned null", null, null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
