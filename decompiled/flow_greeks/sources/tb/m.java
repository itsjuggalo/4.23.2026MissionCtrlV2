package tb;

import com.google.android.gms.common.api.a;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import rb.b;
import tb.n1;
import tb.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f21504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.b f21505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f21506c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f21507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21508b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile rb.k1 f21510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public rb.k1 f21511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public rb.k1 f21512f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f21509c = new AtomicInteger(-2147483647);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final n1.a f21513g = new C0374a();

        /* JADX INFO: renamed from: tb.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0374a implements n1.a {
            public C0374a() {
            }

            @Override // tb.n1.a
            public void onComplete() {
                if (a.this.f21509c.decrementAndGet() == 0) {
                    a.this.j();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b extends b.AbstractC0342b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.z0 f21516a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ rb.c f21517b;

            public b(rb.z0 z0Var, rb.c cVar) {
                this.f21516a = z0Var;
                this.f21517b = cVar;
            }
        }

        public a(w wVar, String str) {
            this.f21507a = (w) p6.n.o(wVar, "delegate");
            this.f21508b = (String) p6.n.o(str, "authority");
        }

        @Override // tb.k0
        public w a() {
            return this.f21507a;
        }

        @Override // tb.k0, tb.k1
        public void c(rb.k1 k1Var) {
            p6.n.o(k1Var, "status");
            synchronized (this) {
                try {
                    if (this.f21509c.get() < 0) {
                        this.f21510d = k1Var;
                        this.f21509c.addAndGet(a.e.API_PRIORITY_OTHER);
                        if (this.f21509c.get() != 0) {
                            this.f21511e = k1Var;
                        } else {
                            super.c(k1Var);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // tb.k0, tb.t
        public r g(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, rb.k[] kVarArr) {
            rb.b bVarC = cVar.c();
            if (bVarC == null) {
                bVarC = m.this.f21505b;
            } else if (m.this.f21505b != null) {
                bVarC = new rb.m(m.this.f21505b, bVarC);
            }
            if (bVarC == null) {
                return this.f21509c.get() >= 0 ? new g0(this.f21510d, kVarArr) : this.f21507a.g(z0Var, y0Var, cVar, kVarArr);
            }
            n1 n1Var = new n1(this.f21507a, z0Var, y0Var, cVar, this.f21513g, kVarArr);
            if (this.f21509c.incrementAndGet() > 0) {
                this.f21513g.onComplete();
                return new g0(this.f21510d, kVarArr);
            }
            try {
                bVarC.a(new b(z0Var, cVar), m.this.f21506c, n1Var);
            } catch (Throwable th) {
                n1Var.b(rb.k1.f19600m.r("Credentials should use fail() instead of throwing exceptions").q(th));
            }
            return n1Var.d();
        }

        @Override // tb.k0, tb.k1
        public void h(rb.k1 k1Var) {
            p6.n.o(k1Var, "status");
            synchronized (this) {
                try {
                    if (this.f21509c.get() < 0) {
                        this.f21510d = k1Var;
                        this.f21509c.addAndGet(a.e.API_PRIORITY_OTHER);
                    } else if (this.f21512f != null) {
                        return;
                    }
                    if (this.f21509c.get() != 0) {
                        this.f21512f = k1Var;
                    } else {
                        super.h(k1Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void j() {
            synchronized (this) {
                try {
                    if (this.f21509c.get() != 0) {
                        return;
                    }
                    rb.k1 k1Var = this.f21511e;
                    rb.k1 k1Var2 = this.f21512f;
                    this.f21511e = null;
                    this.f21512f = null;
                    if (k1Var != null) {
                        super.c(k1Var);
                    }
                    if (k1Var2 != null) {
                        super.h(k1Var2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public m(u uVar, rb.b bVar, Executor executor) {
        this.f21504a = (u) p6.n.o(uVar, "delegate");
        this.f21505b = bVar;
        this.f21506c = (Executor) p6.n.o(executor, "appExecutor");
    }

    @Override // tb.u
    public w I(SocketAddress socketAddress, u.a aVar, rb.f fVar) {
        return new a(this.f21504a.I(socketAddress, aVar, fVar), aVar.a());
    }

    @Override // tb.u
    public ScheduledExecutorService Q() {
        return this.f21504a.Q();
    }

    @Override // tb.u
    public Collection Y() {
        return this.f21504a.Y();
    }

    @Override // tb.u, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f21504a.close();
    }
}
