package M4;

import F4.AbstractC0490d;
import F4.AbstractC0493g;
import F4.C0489c;
import F4.X;
import F4.Y;
import F4.j0;
import F4.k0;
import F4.l0;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2842h;
import v2.AbstractC2848n;
import v2.AbstractC2852r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5357a = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0489c.C0029c f5359c;

    public static final class b extends A2.a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AbstractC0493g f5360h;

        public b(AbstractC0493g abstractC0493g) {
            this.f5360h = abstractC0493g;
        }

        @Override // A2.a
        public void u() {
            this.f5360h.a("GrpcFuture was cancelled", null);
        }

        @Override // A2.a
        public String v() {
            return AbstractC2842h.b(this).d("clientCall", this.f5360h).toString();
        }

        @Override // A2.a
        public boolean y(Object obj) {
            return super.y(obj);
        }

        @Override // A2.a
        public boolean z(Throwable th) {
            return super.z(th);
        }
    }

    /* JADX INFO: renamed from: M4.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0076c extends AbstractC0493g.a {
        public AbstractC0076c() {
        }

        public abstract void e();
    }

    public enum d {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    public static final class e extends ConcurrentLinkedQueue implements Executor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Logger f5365b = Logger.getLogger(e.class.getName());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Object f5366c = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Object f5367a;

        public static void a(Runnable runnable) {
            try {
                runnable.run();
            } catch (Throwable th) {
                f5365b.log(Level.WARNING, "Runnable threw exception", th);
            }
        }

        public static void d() throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        public void e() throws InterruptedException {
            Runnable runnable;
            d();
            Runnable runnable2 = (Runnable) poll();
            if (runnable2 == null) {
                this.f5367a = Thread.currentThread();
                while (true) {
                    try {
                        runnable = (Runnable) poll();
                        if (runnable != null) {
                            break;
                        }
                        LockSupport.park(this);
                        d();
                    } catch (Throwable th) {
                        this.f5367a = null;
                        throw th;
                    }
                }
                this.f5367a = null;
                runnable2 = runnable;
            }
            do {
                a(runnable2);
                runnable2 = (Runnable) poll();
            } while (runnable2 != null);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            add(runnable);
            Object obj = this.f5367a;
            if (obj != f5366c) {
                LockSupport.unpark((Thread) obj);
            } else if (remove(runnable) && c.f5358b) {
                throw new RejectedExecutionException();
            }
        }

        public void shutdown() {
            this.f5367a = f5366c;
            while (true) {
                Runnable runnable = (Runnable) poll();
                if (runnable == null) {
                    return;
                } else {
                    a(runnable);
                }
            }
        }
    }

    static {
        f5358b = !AbstractC2852r.b(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f5359c = C0489c.C0029c.b("internal-stub-type");
    }

    public static void a(AbstractC0493g abstractC0493g, Object obj, AbstractC0076c abstractC0076c) {
        f(abstractC0493g, abstractC0076c);
        try {
            abstractC0493g.d(obj);
            abstractC0493g.b();
        } catch (Error | RuntimeException e8) {
            throw c(abstractC0493g, e8);
        }
    }

    public static Object b(AbstractC0490d abstractC0490d, Y y7, C0489c c0489c, Object obj) throws Throwable {
        e eVar = new e();
        AbstractC0493g abstractC0493gG = abstractC0490d.g(y7, c0489c.q(f5359c, d.BLOCKING).n(eVar));
        boolean z7 = false;
        try {
            try {
                A2.f fVarD = d(abstractC0493gG, obj);
                while (!fVarD.isDone()) {
                    try {
                        eVar.e();
                    } catch (InterruptedException e8) {
                        try {
                            abstractC0493gG.a("Thread interrupted", e8);
                            z7 = true;
                        } catch (Error e9) {
                            e = e9;
                            throw c(abstractC0493gG, e);
                        } catch (RuntimeException e10) {
                            e = e10;
                            throw c(abstractC0493gG, e);
                        } catch (Throwable th) {
                            th = th;
                            z7 = true;
                            if (z7) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                }
                eVar.shutdown();
                Object objE = e(fVarD);
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                return objE;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Error e11) {
            e = e11;
        } catch (RuntimeException e12) {
            e = e12;
        }
    }

    public static RuntimeException c(AbstractC0493g abstractC0493g, Throwable th) {
        try {
            abstractC0493g.a(null, th);
        } catch (Error | RuntimeException e8) {
            f5357a.log(Level.SEVERE, "RuntimeException encountered while closing call", e8);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new AssertionError(th);
    }

    public static A2.f d(AbstractC0493g abstractC0493g, Object obj) {
        b bVar = new b(abstractC0493g);
        a(abstractC0493g, obj, new f(bVar));
        return bVar;
    }

    public static Object e(Future future) {
        try {
            return future.get();
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            throw j0.f1798f.r("Thread interrupted").q(e8).d();
        } catch (ExecutionException e9) {
            throw g(e9.getCause());
        }
    }

    public static void f(AbstractC0493g abstractC0493g, AbstractC0076c abstractC0076c) {
        abstractC0493g.e(abstractC0076c, new X());
        abstractC0076c.e();
    }

    public static l0 g(Throwable th) {
        for (Throwable cause = (Throwable) AbstractC2848n.o(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof k0) {
                k0 k0Var = (k0) cause;
                return new l0(k0Var.a(), k0Var.b());
            }
            if (cause instanceof l0) {
                l0 l0Var = (l0) cause;
                return new l0(l0Var.a(), l0Var.b());
            }
        }
        return j0.f1799g.r("unexpected exception").q(th).d();
    }

    public static final class f extends AbstractC0076c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f5368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f5369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5370c;

        public f(b bVar) {
            super();
            this.f5370c = false;
            this.f5368a = bVar;
        }

        @Override // F4.AbstractC0493g.a
        public void a(j0 j0Var, X x8) {
            if (!j0Var.p()) {
                this.f5368a.z(j0Var.e(x8));
                return;
            }
            if (!this.f5370c) {
                this.f5368a.z(j0.f1811s.r("No value received for unary call").e(x8));
            }
            this.f5368a.y(this.f5369b);
        }

        @Override // F4.AbstractC0493g.a
        public void c(Object obj) {
            if (this.f5370c) {
                throw j0.f1811s.r("More than one value received for unary call").d();
            }
            this.f5369b = obj;
            this.f5370c = true;
        }

        @Override // M4.c.AbstractC0076c
        public void e() {
            this.f5368a.f5360h.c(2);
        }

        @Override // F4.AbstractC0493g.a
        public void b(X x8) {
        }
    }
}
