package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f10975a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(k0 k0Var, Looper looper) {
        super(looper);
        this.f10975a = k0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i7 = message.what;
        if (i7 != 0) {
            if (i7 == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
                throw runtimeException;
            }
            Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i7);
            return;
        }
        com.google.android.gms.common.api.h hVar = (com.google.android.gms.common.api.h) message.obj;
        synchronized (this.f10975a.f10979c) {
            try {
                k0 k0Var = (k0) AbstractC1207s.k(this.f10975a.f10977a);
                if (hVar == null) {
                    k0Var.g(new Status(13, "Transform returned null"));
                } else {
                    k0Var.f(hVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
