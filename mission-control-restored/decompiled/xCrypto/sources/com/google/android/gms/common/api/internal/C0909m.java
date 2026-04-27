package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0909m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f9801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f9802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile a f9803c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.m$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f9804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f9805b;

        public a(Object obj, String str) {
            this.f9804a = obj;
            this.f9805b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9804a == aVar.f9804a && this.f9805b.equals(aVar.f9805b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f9804a) * 31) + this.f9805b.hashCode();
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.m$b */
    public interface b {
        void notifyListener(Object obj);

        void onNotifyListenerFailed();
    }

    public C0909m(Looper looper, Object obj, String str) {
        this.f9801a = new H1.a(looper);
        this.f9802b = AbstractC0940s.l(obj, "Listener must not be null");
        this.f9803c = new a(obj, AbstractC0940s.e(str));
    }

    public void a() {
        this.f9802b = null;
        this.f9803c = null;
    }

    public a b() {
        return this.f9803c;
    }

    public void c(final b bVar) {
        AbstractC0940s.l(bVar, "Notifier must not be null");
        this.f9801a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f9744a.d(bVar);
            }
        });
    }

    public final void d(b bVar) {
        Object obj = this.f9802b;
        if (obj == null) {
            bVar.onNotifyListenerFailed();
            return;
        }
        try {
            bVar.notifyListener(obj);
        } catch (RuntimeException e4) {
            bVar.onNotifyListenerFailed();
            throw e4;
        }
    }
}
