package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.firebase.messaging.q0;
import l2.AbstractC2328l;
import l2.InterfaceC2322f;
import w0.ExecutorC2893k;

/* JADX INFO: loaded from: classes.dex */
public class n0 extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f15777a;

    public interface a {
        AbstractC2328l a(Intent intent);
    }

    public n0(a aVar) {
        this.f15777a = aVar;
    }

    public void c(final q0.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        this.f15777a.a(aVar.f15789a).b(new ExecutorC2893k(), new InterfaceC2322f() { // from class: com.google.firebase.messaging.m0
            @Override // l2.InterfaceC2322f
            public final void a(AbstractC2328l abstractC2328l) {
                aVar.d();
            }
        });
    }
}
