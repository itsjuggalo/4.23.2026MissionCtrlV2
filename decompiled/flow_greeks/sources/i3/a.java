package i3;

import android.os.Process;
import i3.p;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f11570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReferenceQueue f11571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p.a f11572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11573f;

    /* JADX INFO: renamed from: i3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class ThreadFactoryC0219a implements ThreadFactory {

        /* JADX INFO: renamed from: i3.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class RunnableC0220a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f11574a;

            public RunnableC0220a(Runnable runnable) {
                this.f11574a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f11574a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0220a(runnable), "glide-active-resources");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends WeakReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g3.f f11577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f11578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public v f11579c;

        public c(g3.f fVar, p pVar, ReferenceQueue referenceQueue, boolean z10) {
            super(pVar, referenceQueue);
            this.f11577a = (g3.f) c4.k.e(fVar);
            this.f11579c = (pVar.f() && z10) ? (v) c4.k.e(pVar.e()) : null;
            this.f11578b = pVar.f();
        }

        public void a() {
            this.f11579c = null;
            clear();
        }
    }

    public a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new ThreadFactoryC0219a()));
    }

    public synchronized void a(g3.f fVar, p pVar) {
        c cVar = (c) this.f11570c.put(fVar, new c(fVar, pVar, this.f11571d, this.f11568a));
        if (cVar != null) {
            cVar.a();
        }
    }

    public void b() {
        while (!this.f11573f) {
            try {
                c((c) this.f11571d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(c cVar) {
        v vVar;
        synchronized (this) {
            this.f11570c.remove(cVar.f11577a);
            if (cVar.f11578b && (vVar = cVar.f11579c) != null) {
                this.f11572e.a(cVar.f11577a, new p(vVar, true, false, cVar.f11577a, this.f11572e));
            }
        }
    }

    public synchronized void d(g3.f fVar) {
        c cVar = (c) this.f11570c.remove(fVar);
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized p e(g3.f fVar) {
        c cVar = (c) this.f11570c.get(fVar);
        if (cVar == null) {
            return null;
        }
        p pVar = (p) cVar.get();
        if (pVar == null) {
            c(cVar);
        }
        return pVar;
    }

    public void f(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f11572e = aVar;
            }
        }
    }

    public a(boolean z10, Executor executor) {
        this.f11570c = new HashMap();
        this.f11571d = new ReferenceQueue();
        this.f11568a = z10;
        this.f11569b = executor;
        executor.execute(new b());
    }
}
