package M2;

import K2.AbstractC0354b;
import K2.AbstractC0358f;
import K2.AbstractC0363k;
import K2.C0355c;
import K2.C0365m;
import M2.C0437o0;
import M2.InterfaceC0447u;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: M2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0432m implements InterfaceC0447u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0447u f2463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0354b f2464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f2465c;

    /* JADX INFO: renamed from: M2.m$a */
    public class a extends K {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0451w f2466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2467b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile K2.l0 f2469d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public K2.l0 f2470e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public K2.l0 f2471f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f2468c = new AtomicInteger(-2147483647);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final C0437o0.a f2472g = new C0045a();

        /* JADX INFO: renamed from: M2.m$a$a, reason: collision with other inner class name */
        public class C0045a implements C0437o0.a {
            public C0045a() {
            }

            @Override // M2.C0437o0.a
            public void a() {
                if (a.this.f2468c.decrementAndGet() == 0) {
                    a.this.k();
                }
            }
        }

        /* JADX INFO: renamed from: M2.m$a$b */
        public class b extends AbstractC0354b.AbstractC0030b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.a0 f2475a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0355c f2476b;

            public b(K2.a0 a0Var, C0355c c0355c) {
                this.f2475a = a0Var;
                this.f2476b = c0355c;
            }
        }

        public a(InterfaceC0451w interfaceC0451w, String str) {
            this.f2466a = (InterfaceC0451w) Z1.m.o(interfaceC0451w, "delegate");
            this.f2467b = (String) Z1.m.o(str, "authority");
        }

        @Override // M2.K
        public InterfaceC0451w a() {
            return this.f2466a;
        }

        @Override // M2.K, M2.InterfaceC0431l0
        public void b(K2.l0 l0Var) {
            Z1.m.o(l0Var, "status");
            synchronized (this) {
                try {
                    if (this.f2468c.get() < 0) {
                        this.f2469d = l0Var;
                        this.f2468c.addAndGet(Integer.MAX_VALUE);
                    } else if (this.f2471f != null) {
                        return;
                    }
                    if (this.f2468c.get() != 0) {
                        this.f2471f = l0Var;
                    } else {
                        super.b(l0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // M2.K, M2.InterfaceC0445t
        public r c(K2.a0 a0Var, K2.Z z4, C0355c c0355c, AbstractC0363k[] abstractC0363kArr) {
            AbstractC0354b abstractC0354bC = c0355c.c();
            if (abstractC0354bC == null) {
                abstractC0354bC = C0432m.this.f2464b;
            } else if (C0432m.this.f2464b != null) {
                abstractC0354bC = new C0365m(C0432m.this.f2464b, abstractC0354bC);
            }
            if (abstractC0354bC == null) {
                return this.f2468c.get() >= 0 ? new G(this.f2469d, abstractC0363kArr) : this.f2466a.c(a0Var, z4, c0355c, abstractC0363kArr);
            }
            C0437o0 c0437o0 = new C0437o0(this.f2466a, a0Var, z4, c0355c, this.f2472g, abstractC0363kArr);
            if (this.f2468c.incrementAndGet() > 0) {
                this.f2472g.a();
                return new G(this.f2469d, abstractC0363kArr);
            }
            try {
                abstractC0354bC.applyRequestMetadata(new b(a0Var, c0355c), C0432m.this.f2465c, c0437o0);
            } catch (Throwable th) {
                c0437o0.b(K2.l0.f1223m.q("Credentials should use fail() instead of throwing exceptions").p(th));
            }
            return c0437o0.d();
        }

        @Override // M2.K, M2.InterfaceC0431l0
        public void e(K2.l0 l0Var) {
            Z1.m.o(l0Var, "status");
            synchronized (this) {
                try {
                    if (this.f2468c.get() < 0) {
                        this.f2469d = l0Var;
                        this.f2468c.addAndGet(Integer.MAX_VALUE);
                        if (this.f2468c.get() != 0) {
                            this.f2470e = l0Var;
                        } else {
                            super.e(l0Var);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void k() {
            synchronized (this) {
                try {
                    if (this.f2468c.get() != 0) {
                        return;
                    }
                    K2.l0 l0Var = this.f2470e;
                    K2.l0 l0Var2 = this.f2471f;
                    this.f2470e = null;
                    this.f2471f = null;
                    if (l0Var != null) {
                        super.e(l0Var);
                    }
                    if (l0Var2 != null) {
                        super.b(l0Var2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public C0432m(InterfaceC0447u interfaceC0447u, AbstractC0354b abstractC0354b, Executor executor) {
        this.f2463a = (InterfaceC0447u) Z1.m.o(interfaceC0447u, "delegate");
        this.f2464b = abstractC0354b;
        this.f2465c = (Executor) Z1.m.o(executor, "appExecutor");
    }

    @Override // M2.InterfaceC0447u
    public InterfaceC0451w I(SocketAddress socketAddress, InterfaceC0447u.a aVar, AbstractC0358f abstractC0358f) {
        return new a(this.f2463a.I(socketAddress, aVar, abstractC0358f), aVar.a());
    }

    @Override // M2.InterfaceC0447u
    public ScheduledExecutorService R() {
        return this.f2463a.R();
    }

    @Override // M2.InterfaceC0447u
    public Collection b0() {
        return this.f2463a.b0();
    }

    @Override // M2.InterfaceC0447u, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2463a.close();
    }
}
