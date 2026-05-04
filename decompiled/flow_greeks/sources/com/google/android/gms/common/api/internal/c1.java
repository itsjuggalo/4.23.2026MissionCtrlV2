package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zao;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends zao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f5530a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(d1 d1Var, Looper looper) {
        super(looper);
        Objects.requireNonNull(d1Var);
        this.f5530a = d1Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 0) {
            if (i10 == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
                throw runtimeException;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 59);
            sb2.append("TransformationResultHandler received unknown message type: ");
            sb2.append(i10);
            Log.e("TransformedResultImpl", sb2.toString());
            return;
        }
        com.google.android.gms.common.api.h hVar = (com.google.android.gms.common.api.h) message.obj;
        d1 d1Var = this.f5530a;
        synchronized (d1Var.f()) {
            try {
                d1 d1Var2 = (d1) com.google.android.gms.common.internal.s.k(d1Var.e());
                if (hVar == null) {
                    d1Var2.d(new Status(13, "Transform returned null"));
                } else {
                    d1Var2.c(hVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
