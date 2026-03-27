package M2;

import K2.InterfaceC0364l;
import K2.InterfaceC0366n;
import K2.InterfaceC0372u;
import M2.C0416e;
import M2.C0433m0;
import M2.Q0;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.InputStream;

/* JADX INFO: renamed from: M2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0412c implements P0 {

    /* JADX INFO: renamed from: M2.c$a */
    public static abstract class a implements C0416e.h, C0433m0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC0455z f2149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f2150b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final O0 f2151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final U0 f2152d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C0433m0 f2153e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2154f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2155g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2156h;

        /* JADX INFO: renamed from: M2.c$a$a, reason: collision with other inner class name */
        public class RunnableC0043a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ U2.b f2157a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f2158b;

            public RunnableC0043a(U2.b bVar, int i4) {
                this.f2157a = bVar;
                this.f2158b = i4;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    U2.e eVarH = U2.c.h("AbstractStream.request");
                    try {
                        U2.c.e(this.f2157a);
                        a.this.f2149a.e(this.f2158b);
                        if (eVarH != null) {
                            eVarH.close();
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    a.this.e(th);
                }
            }
        }

        public a(int i4, O0 o02, U0 u02) {
            this.f2151c = (O0) Z1.m.o(o02, "statsTraceCtx");
            this.f2152d = (U0) Z1.m.o(u02, "transportTracer");
            C0433m0 c0433m0 = new C0433m0(this, InterfaceC0364l.b.f1213a, i4, o02, u02);
            this.f2153e = c0433m0;
            this.f2149a = c0433m0;
        }

        @Override // M2.C0433m0.b
        public void a(Q0.a aVar) {
            o().a(aVar);
        }

        public final void b(int i4) {
            boolean z4;
            synchronized (this.f2150b) {
                Z1.m.u(this.f2155g, "onStreamAllocated was not called, but it seems the stream is active");
                int i5 = this.f2154f;
                z4 = false;
                boolean z5 = i5 < 32768;
                int i6 = i5 - i4;
                this.f2154f = i6;
                boolean z6 = i6 < 32768;
                if (!z5 && z6) {
                    z4 = true;
                }
            }
            if (z4) {
                p();
            }
        }

        public final void k(boolean z4) {
            if (z4) {
                this.f2149a.close();
            } else {
                this.f2149a.p();
            }
        }

        public final void l(y0 y0Var) {
            try {
                this.f2149a.g(y0Var);
            } catch (Throwable th) {
                e(th);
            }
        }

        public U0 m() {
            return this.f2152d;
        }

        public final boolean n() {
            boolean z4;
            synchronized (this.f2150b) {
                try {
                    z4 = this.f2155g && this.f2154f < 32768 && !this.f2156h;
                } finally {
                }
            }
            return z4;
        }

        public abstract Q0 o();

        public final void p() {
            boolean zN;
            synchronized (this.f2150b) {
                zN = n();
            }
            if (zN) {
                o().c();
            }
        }

        public final void q(int i4) {
            synchronized (this.f2150b) {
                this.f2154f += i4;
            }
        }

        public void r() {
            Z1.m.t(o() != null);
            synchronized (this.f2150b) {
                Z1.m.u(!this.f2155g, "Already allocated");
                this.f2155g = true;
            }
            p();
        }

        public final void s() {
            synchronized (this.f2150b) {
                this.f2156h = true;
            }
        }

        public final void t() {
            this.f2153e.f0(this);
            this.f2149a = this.f2153e;
        }

        public final void u(int i4) {
            f(new RunnableC0043a(U2.c.f(), i4));
        }

        public final void v(InterfaceC0372u interfaceC0372u) {
            this.f2149a.x(interfaceC0372u);
        }

        public void w(T t4) {
            this.f2153e.e0(t4);
            this.f2149a = new C0416e(this, this, this.f2153e);
        }

        public final void x(int i4) {
            this.f2149a.f(i4);
        }
    }

    @Override // M2.P0
    public final void a(boolean z4) {
        t().a(z4);
    }

    @Override // M2.P0
    public final void b(InterfaceC0366n interfaceC0366n) {
        t().b((InterfaceC0366n) Z1.m.o(interfaceC0366n, "compressor"));
    }

    @Override // M2.P0
    public final void e(int i4) {
        v().u(i4);
    }

    @Override // M2.P0
    public final void flush() {
        if (t().c()) {
            return;
        }
        t().flush();
    }

    @Override // M2.P0
    public boolean j() {
        return v().n();
    }

    @Override // M2.P0
    public final void p(InputStream inputStream) {
        Z1.m.o(inputStream, Constants.MESSAGE);
        try {
            if (!t().c()) {
                t().d(inputStream);
            }
        } finally {
            S.e(inputStream);
        }
    }

    @Override // M2.P0
    public void q() {
        v().t();
    }

    public final void s() {
        t().close();
    }

    public abstract P t();

    public final void u(int i4) {
        v().q(i4);
    }

    public abstract a v();
}
