package c4;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.InterfaceC2321e;
import l2.InterfaceC2323g;
import l2.InterfaceC2324h;
import l2.InterfaceC2327k;
import w0.ExecutorC2893k;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f13421d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f13422e = new ExecutorC2893k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f13423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f13424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractC2328l f13425c = null;

    public static class b implements InterfaceC2324h, InterfaceC2323g, InterfaceC2321e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f13426a;

        public b() {
            this.f13426a = new CountDownLatch(1);
        }

        @Override // l2.InterfaceC2321e
        public void a() {
            this.f13426a.countDown();
        }

        public boolean b(long j8, TimeUnit timeUnit) {
            return this.f13426a.await(j8, timeUnit);
        }

        @Override // l2.InterfaceC2323g
        public void onFailure(Exception exc) {
            this.f13426a.countDown();
        }

        @Override // l2.InterfaceC2324h
        public void onSuccess(Object obj) {
            this.f13426a.countDown();
        }
    }

    public e(Executor executor, p pVar) {
        this.f13423a = executor;
        this.f13424b = pVar;
    }

    public static Object c(AbstractC2328l abstractC2328l, long j8, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        b bVar = new b();
        Executor executor = f13422e;
        abstractC2328l.f(executor, bVar);
        abstractC2328l.d(executor, bVar);
        abstractC2328l.a(executor, bVar);
        if (!bVar.b(j8, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (abstractC2328l.o()) {
            return abstractC2328l.k();
        }
        throw new ExecutionException(abstractC2328l.j());
    }

    public static synchronized e h(Executor executor, p pVar) {
        String strB;
        Map map;
        try {
            strB = pVar.b();
            map = f13421d;
            if (!map.containsKey(strB)) {
                map.put(strB, new e(executor, pVar));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (e) map.get(strB);
    }

    public void d() {
        synchronized (this) {
            this.f13425c = AbstractC2331o.e(null);
        }
        this.f13424b.a();
    }

    public synchronized AbstractC2328l e() {
        try {
            AbstractC2328l abstractC2328l = this.f13425c;
            if (abstractC2328l == null || (abstractC2328l.n() && !this.f13425c.o())) {
                Executor executor = this.f13423a;
                final p pVar = this.f13424b;
                Objects.requireNonNull(pVar);
                this.f13425c = AbstractC2331o.c(executor, new Callable() { // from class: c4.b
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return pVar.d();
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f13425c;
    }

    public com.google.firebase.remoteconfig.internal.b f() {
        return g(5L);
    }

    public com.google.firebase.remoteconfig.internal.b g(long j8) {
        synchronized (this) {
            try {
                AbstractC2328l abstractC2328l = this.f13425c;
                if (abstractC2328l != null && abstractC2328l.o()) {
                    return (com.google.firebase.remoteconfig.internal.b) this.f13425c.k();
                }
                try {
                    return (com.google.firebase.remoteconfig.internal.b) c(e(), j8, TimeUnit.SECONDS);
                } catch (InterruptedException | ExecutionException | TimeoutException e8) {
                    Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", e8);
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ Void i(com.google.firebase.remoteconfig.internal.b bVar) {
        return this.f13424b.e(bVar);
    }

    public final /* synthetic */ AbstractC2328l j(boolean z7, com.google.firebase.remoteconfig.internal.b bVar, Void r32) {
        if (z7) {
            m(bVar);
        }
        return AbstractC2331o.e(bVar);
    }

    public AbstractC2328l k(com.google.firebase.remoteconfig.internal.b bVar) {
        return l(bVar, true);
    }

    public AbstractC2328l l(final com.google.firebase.remoteconfig.internal.b bVar, final boolean z7) {
        return AbstractC2331o.c(this.f13423a, new Callable() { // from class: c4.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13416a.i(bVar);
            }
        }).p(this.f13423a, new InterfaceC2327k() { // from class: c4.d
            @Override // l2.InterfaceC2327k
            public final AbstractC2328l a(Object obj) {
                return this.f13418a.j(z7, bVar, (Void) obj);
            }
        });
    }

    public final synchronized void m(com.google.firebase.remoteconfig.internal.b bVar) {
        this.f13425c = AbstractC2331o.e(bVar);
    }
}
