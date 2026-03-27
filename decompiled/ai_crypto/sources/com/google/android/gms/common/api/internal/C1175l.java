package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1175l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f10984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f10985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile a f10986c;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.l$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f10987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10988b;

        public a(Object obj, String str) {
            this.f10987a = obj;
            this.f10988b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10987a == aVar.f10987a && this.f10988b.equals(aVar.f10988b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f10987a) * 31) + this.f10988b.hashCode();
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.l$b */
    public interface b {
        void notifyListener(Object obj);

        void onNotifyListenerFailed();
    }

    public C1175l(Looper looper, Object obj, String str) {
        this.f10984a = new X1.a(looper);
        this.f10985b = AbstractC1207s.l(obj, "Listener must not be null");
        this.f10986c = new a(obj, AbstractC1207s.e(str));
    }

    public void a() {
        this.f10985b = null;
        this.f10986c = null;
    }

    public a b() {
        return this.f10986c;
    }

    public void c(final b bVar) {
        AbstractC1207s.l(bVar, "Notifier must not be null");
        this.f10984a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.X
            @Override // java.lang.Runnable
            public final void run() {
                this.f10919a.d(bVar);
            }
        });
    }

    public final void d(b bVar) {
        Object obj = this.f10985b;
        if (obj == null) {
            bVar.onNotifyListenerFailed();
            return;
        }
        try {
            bVar.notifyListener(obj);
        } catch (RuntimeException e7) {
            bVar.onNotifyListenerFailed();
            throw e7;
        }
    }
}
