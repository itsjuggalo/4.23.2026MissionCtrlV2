package W0;

import W0.p;
import android.os.Process;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f9024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f9025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReferenceQueue f9026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p.a f9027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f9028f;

    /* JADX INFO: renamed from: W0.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0145a implements ThreadFactory {

        /* JADX INFO: renamed from: W0.a$a$a, reason: collision with other inner class name */
        public class RunnableC0146a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f9029a;

            public RunnableC0146a(Runnable runnable) {
                this.f9029a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f9029a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0146a(runnable), "glide-active-resources");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    public static final class c extends WeakReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final U0.f f9032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f9033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public v f9034c;

        public c(U0.f fVar, p pVar, ReferenceQueue referenceQueue, boolean z7) {
            super(pVar, referenceQueue);
            this.f9032a = (U0.f) AbstractC2628k.d(fVar);
            this.f9034c = (pVar.f() && z7) ? (v) AbstractC2628k.d(pVar.e()) : null;
            this.f9033b = pVar.f();
        }

        public void a() {
            this.f9034c = null;
            clear();
        }
    }

    public a(boolean z7) {
        this(z7, Executors.newSingleThreadExecutor(new ThreadFactoryC0145a()));
    }

    public synchronized void a(U0.f fVar, p pVar) {
        c cVar = (c) this.f9025c.put(fVar, new c(fVar, pVar, this.f9026d, this.f9023a));
        if (cVar != null) {
            cVar.a();
        }
    }

    public void b() {
        while (!this.f9028f) {
            try {
                c((c) this.f9026d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(c cVar) {
        v vVar;
        synchronized (this) {
            this.f9025c.remove(cVar.f9032a);
            if (cVar.f9033b && (vVar = cVar.f9034c) != null) {
                this.f9027e.c(cVar.f9032a, new p(vVar, true, false, cVar.f9032a, this.f9027e));
            }
        }
    }

    public synchronized void d(U0.f fVar) {
        c cVar = (c) this.f9025c.remove(fVar);
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized p e(U0.f fVar) {
        c cVar = (c) this.f9025c.get(fVar);
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
                this.f9027e = aVar;
            }
        }
    }

    public a(boolean z7, Executor executor) {
        this.f9025c = new HashMap();
        this.f9026d = new ReferenceQueue();
        this.f9023a = z7;
        this.f9024b = executor;
        executor.execute(new b());
    }
}
