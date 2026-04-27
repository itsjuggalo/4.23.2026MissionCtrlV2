package s4;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: s4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1056c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z.B f9704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap f9705b = new WeakHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f9706c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f9707d = new HashMap();
    public final ReferenceQueue e = new ReferenceQueue();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f9708f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f9709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final E3.d f9710h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9711j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f9712k;

    public C1056c(Z.B b3) {
        this.f9704a = b3;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f9709g = handler;
        E3.d dVar = new E3.d(this, 23);
        this.f9710h = dVar;
        this.i = 65536L;
        this.f9712k = 3000L;
        handler.postDelayed(dVar, 3000L);
    }

    public final void a(Object instance, long j4) {
        kotlin.jvm.internal.j.e(instance, "instance");
        f();
        c(instance, j4);
    }

    public final long b(Object instance) {
        kotlin.jvm.internal.j.e(instance, "instance");
        f();
        if (!d(instance)) {
            long j4 = this.i;
            this.i = 1 + j4;
            c(instance, j4);
            return j4;
        }
        throw new IllegalArgumentException(("Instance of " + instance.getClass() + " has already been added.").toString());
    }

    public final void c(Object obj, long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(k0.a.f("Identifier must be >= 0: ", j4).toString());
        }
        HashMap map = this.f9706c;
        if (map.containsKey(Long.valueOf(j4))) {
            throw new IllegalArgumentException(k0.a.f("Identifier has already been added: ", j4).toString());
        }
        WeakReference weakReference = new WeakReference(obj, this.e);
        this.f9705b.put(obj, Long.valueOf(j4));
        map.put(Long.valueOf(j4), weakReference);
        this.f9708f.put(weakReference, Long.valueOf(j4));
        this.f9707d.put(Long.valueOf(j4), obj);
    }

    public final boolean d(Object obj) {
        f();
        return this.f9705b.containsKey(obj);
    }

    public final Object e(long j4) {
        f();
        WeakReference weakReference = (WeakReference) this.f9706c.get(Long.valueOf(j4));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void f() {
        if (this.f9711j) {
            Log.w("PigeonInstanceManager", "The manager was used after calls to the PigeonFinalizationListener has been stopped.");
        }
    }
}
