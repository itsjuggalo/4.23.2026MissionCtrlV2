package zb;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import p6.h;
import p6.n;
import p6.r;
import rb.c;
import rb.g;
import rb.k1;
import rb.l1;
import rb.m1;
import rb.y0;
import rb.z0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f25647a = Logger.getLogger(d.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f25648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c.C0344c f25649c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends u6.a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final g f25650h;

        public b(g gVar) {
            this.f25650h = gVar;
        }

        @Override // u6.a
        public void t() {
            this.f25650h.a("GrpcFuture was cancelled", null);
        }

        @Override // u6.a
        public String u() {
            return h.b(this).d("clientCall", this.f25650h).toString();
        }

        @Override // u6.a
        public boolean x(Object obj) {
            return super.x(obj);
        }

        @Override // u6.a
        public boolean y(Throwable th) {
            return super.y(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c extends g.a {
        public c() {
        }

        public abstract void e();
    }

    /* JADX INFO: renamed from: zb.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0486d {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends ConcurrentLinkedQueue implements Executor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Logger f25655b = Logger.getLogger(e.class.getName());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Object f25656c = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Object f25657a;

        public static void a(Runnable runnable) {
            try {
                runnable.run();
            } catch (Throwable th) {
                f25655b.log(Level.WARNING, "Runnable threw exception", th);
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
                this.f25657a = Thread.currentThread();
                while (true) {
                    try {
                        runnable = (Runnable) poll();
                        if (runnable != null) {
                            break;
                        }
                        LockSupport.park(this);
                        d();
                    } catch (Throwable th) {
                        this.f25657a = null;
                        throw th;
                    }
                }
                this.f25657a = null;
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
            Object obj = this.f25657a;
            if (obj != f25656c) {
                LockSupport.unpark((Thread) obj);
            } else if (remove(runnable) && d.f25648b) {
                throw new RejectedExecutionException();
            }
        }

        public void shutdown() {
            this.f25657a = f25656c;
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
        f25648b = !r.b(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f25649c = c.C0344c.b("internal-stub-type");
    }

    public static void a(g gVar, Object obj, c cVar) {
        f(gVar, cVar);
        try {
            gVar.d(obj);
            gVar.b();
        } catch (Error | RuntimeException e10) {
            throw c(gVar, e10);
        }
    }

    public static Object b(rb.d dVar, z0 z0Var, rb.c cVar, Object obj) throws Throwable {
        e eVar = new e();
        g gVarE = dVar.e(z0Var, cVar.r(f25649c, EnumC0486d.BLOCKING).o(eVar));
        boolean z10 = false;
        try {
            try {
                u6.f fVarD = d(gVarE, obj);
                while (!fVarD.isDone()) {
                    try {
                        eVar.e();
                    } catch (InterruptedException e10) {
                        try {
                            gVarE.a("Thread interrupted", e10);
                            z10 = true;
                        } catch (Error e11) {
                            e = e11;
                            throw c(gVarE, e);
                        } catch (RuntimeException e12) {
                            e = e12;
                            throw c(gVarE, e);
                        } catch (Throwable th) {
                            th = th;
                            z10 = true;
                            if (z10) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                }
                eVar.shutdown();
                Object objE = e(fVarD);
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                return objE;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Error e13) {
            e = e13;
        } catch (RuntimeException e14) {
            e = e14;
        }
    }

    public static RuntimeException c(g gVar, Throwable th) {
        try {
            gVar.a(null, th);
        } catch (Error | RuntimeException e10) {
            f25647a.log(Level.SEVERE, "RuntimeException encountered while closing call", e10);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new AssertionError(th);
    }

    public static u6.f d(g gVar, Object obj) {
        b bVar = new b(gVar);
        a(gVar, obj, new f(bVar));
        return bVar;
    }

    public static Object e(Future future) {
        try {
            return future.get();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw k1.f19593f.r("Thread interrupted").q(e10).d();
        } catch (ExecutionException e11) {
            throw g(e11.getCause());
        }
    }

    public static void f(g gVar, c cVar) {
        gVar.e(cVar, new y0());
        cVar.e();
    }

    public static m1 g(Throwable th) {
        for (Throwable cause = (Throwable) n.o(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof l1) {
                l1 l1Var = (l1) cause;
                return new m1(l1Var.a(), l1Var.b());
            }
            if (cause instanceof m1) {
                m1 m1Var = (m1) cause;
                return new m1(m1Var.a(), m1Var.b());
            }
        }
        return k1.f19594g.r("unexpected exception").q(th).d();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f25658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f25659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f25660c;

        public f(b bVar) {
            super();
            this.f25660c = false;
            this.f25658a = bVar;
        }

        @Override // rb.g.a
        public void a(k1 k1Var, y0 y0Var) {
            if (!k1Var.p()) {
                this.f25658a.y(k1Var.e(y0Var));
                return;
            }
            if (!this.f25660c) {
                this.f25658a.y(k1.f19606s.r("No value received for unary call").e(y0Var));
            }
            this.f25658a.x(this.f25659b);
        }

        @Override // rb.g.a
        public void c(Object obj) {
            if (this.f25660c) {
                throw k1.f19606s.r("More than one value received for unary call").d();
            }
            this.f25659b = obj;
            this.f25660c = true;
        }

        @Override // zb.d.c
        public void e() {
            this.f25658a.f25650h.c(2);
        }

        @Override // rb.g.a
        public void b(y0 y0Var) {
        }
    }
}
