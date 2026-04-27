package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: loaded from: classes.dex */
public final class l0 extends zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f9800a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(n0 n0Var, Looper looper) {
        super(looper);
        this.f9800a = n0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i4 = message.what;
        if (i4 != 0) {
            if (i4 == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
                throw runtimeException;
            }
            Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i4);
            return;
        }
        com.google.android.gms.common.api.h hVar = (com.google.android.gms.common.api.h) message.obj;
        synchronized (this.f9800a.f9809c) {
            try {
                n0 n0Var = (n0) AbstractC0940s.k(this.f9800a.f9807a);
                if (hVar == null) {
                    n0Var.g(new Status(13, "Transform returned null"));
                } else {
                    n0Var.f(hVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
