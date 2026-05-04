package com.google.android.gms.common.api.internal;

import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f5596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f5597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile a f5598c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f5600b;

        public a(Object obj, String str) {
            this.f5599a = obj;
            this.f5600b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5599a == aVar.f5599a && this.f5600b.equals(aVar.f5600b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f5599a) * 31) + this.f5600b.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void notifyListener(Object obj);

        void onNotifyListenerFailed();
    }

    public l(Looper looper, Object obj, String str) {
        this.f5596a = new u5.a(looper);
        this.f5597b = com.google.android.gms.common.internal.s.l(obj, "Listener must not be null");
        this.f5598c = new a(obj, com.google.android.gms.common.internal.s.e(str));
    }

    public void a() {
        this.f5597b = null;
        this.f5598c = null;
    }

    public a b() {
        return this.f5598c;
    }

    public void c(final b bVar) {
        com.google.android.gms.common.internal.s.l(bVar, "Notifier must not be null");
        this.f5596a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.r0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f5616a.d(bVar);
            }
        });
    }

    public final /* synthetic */ void d(b bVar) {
        Object obj = this.f5597b;
        if (obj == null) {
            bVar.onNotifyListenerFailed();
            return;
        }
        try {
            bVar.notifyListener(obj);
        } catch (RuntimeException e10) {
            bVar.onNotifyListenerFailed();
            throw e10;
        }
    }
}
