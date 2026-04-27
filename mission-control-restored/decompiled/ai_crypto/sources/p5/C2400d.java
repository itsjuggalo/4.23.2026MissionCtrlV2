package p5;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import kotlin.jvm.internal.AbstractC2148j;
import p5.J5;

/* JADX INFO: renamed from: p5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2400d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f21840l = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap f21842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f21843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f21844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReferenceQueue f21845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f21846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f21847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f21848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f21849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f21851k;

    /* JADX INFO: renamed from: p5.d$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final C2400d a(b finalizationListener) {
            kotlin.jvm.internal.r.f(finalizationListener, "finalizationListener");
            return new C2400d(finalizationListener);
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: p5.d$b */
    public interface b {
        void a(long j7);
    }

    public C2400d(b finalizationListener) {
        kotlin.jvm.internal.r.f(finalizationListener, "finalizationListener");
        this.f21841a = finalizationListener;
        this.f21842b = new WeakHashMap();
        this.f21843c = new HashMap();
        this.f21844d = new HashMap();
        this.f21845e = new ReferenceQueue();
        this.f21846f = new HashMap();
        Handler handler = new Handler(Looper.getMainLooper());
        this.f21847g = handler;
        Runnable runnable = new Runnable() { // from class: p5.c
            @Override // java.lang.Runnable
            public final void run() {
                C2400d.l(this.f21831a);
            }
        };
        this.f21848h = runnable;
        this.f21849i = 65536L;
        this.f21851k = 3000L;
        handler.postDelayed(runnable, 3000L);
    }

    public static final void l(C2400d this$0) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        this$0.k();
    }

    public final void b(Object instance, long j7) {
        kotlin.jvm.internal.r.f(instance, "instance");
        j();
        d(instance, j7);
    }

    public final long c(Object instance) {
        kotlin.jvm.internal.r.f(instance, "instance");
        j();
        if (!f(instance)) {
            long j7 = this.f21849i;
            this.f21849i = 1 + j7;
            d(instance, j7);
            return j7;
        }
        throw new IllegalArgumentException(("Instance of " + instance.getClass() + " has already been added.").toString());
    }

    public final void d(Object obj, long j7) {
        if (j7 < 0) {
            throw new IllegalArgumentException(("Identifier must be >= 0: " + j7).toString());
        }
        if (this.f21843c.containsKey(Long.valueOf(j7))) {
            throw new IllegalArgumentException(("Identifier has already been added: " + j7).toString());
        }
        WeakReference weakReference = new WeakReference(obj, this.f21845e);
        this.f21842b.put(obj, Long.valueOf(j7));
        this.f21843c.put(Long.valueOf(j7), weakReference);
        this.f21846f.put(weakReference, Long.valueOf(j7));
        this.f21844d.put(Long.valueOf(j7), obj);
    }

    public final void e() {
        this.f21842b.clear();
        this.f21843c.clear();
        this.f21844d.clear();
        this.f21846f.clear();
    }

    public final boolean f(Object obj) {
        j();
        return this.f21842b.containsKey(obj);
    }

    public final Long g(Object obj) {
        j();
        Long l7 = (Long) this.f21842b.get(obj);
        if (l7 != null) {
            HashMap map = this.f21844d;
            kotlin.jvm.internal.r.c(obj);
            map.put(l7, obj);
        }
        return l7;
    }

    public final Object h(long j7) {
        j();
        WeakReference weakReference = (WeakReference) this.f21843c.get(Long.valueOf(j7));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean i() {
        return this.f21850j;
    }

    public final void j() {
        if (i()) {
            Log.w("PigeonInstanceManager", "The manager was used after calls to the PigeonFinalizationListener has been stopped.");
        }
    }

    public final void k() {
        if (i()) {
            return;
        }
        while (true) {
            WeakReference weakReference = (WeakReference) this.f21845e.poll();
            if (weakReference == null) {
                this.f21847g.postDelayed(this.f21848h, this.f21851k);
                return;
            }
            Long l7 = (Long) kotlin.jvm.internal.L.a(this.f21846f).remove(weakReference);
            if (l7 != null) {
                this.f21843c.remove(l7);
                this.f21844d.remove(l7);
                this.f21841a.a(l7.longValue());
            }
        }
    }

    public final Object m(long j7) {
        j();
        Object objH = h(j7);
        if (objH instanceof J5.a) {
            ((J5.a) objH).destroy();
        }
        return this.f21844d.remove(Long.valueOf(j7));
    }

    public final void n() {
        this.f21847g.removeCallbacks(this.f21848h);
        this.f21850j = true;
    }
}
