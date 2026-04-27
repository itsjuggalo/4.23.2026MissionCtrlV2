package com.google.firebase.messaging;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.Executor;
import l2.AbstractC2328l;
import l2.InterfaceC2319c;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f15668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f15669b = new C2882a();

    public interface a {
        AbstractC2328l start();
    }

    public Y(Executor executor) {
        this.f15668a = executor;
    }

    public synchronized AbstractC2328l b(final String str, a aVar) {
        AbstractC2328l abstractC2328l = (AbstractC2328l) this.f15669b.get(str);
        if (abstractC2328l != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + str);
            }
            return abstractC2328l;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Making new request for: " + str);
        }
        AbstractC2328l abstractC2328lI = aVar.start().i(this.f15668a, new InterfaceC2319c() { // from class: com.google.firebase.messaging.X
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l2) {
                return this.f15666a.c(str, abstractC2328l2);
            }
        });
        this.f15669b.put(str, abstractC2328lI);
        return abstractC2328lI;
    }

    public final /* synthetic */ AbstractC2328l c(String str, AbstractC2328l abstractC2328l) {
        synchronized (this) {
            this.f15669b.remove(str);
        }
        return abstractC2328l;
    }
}
