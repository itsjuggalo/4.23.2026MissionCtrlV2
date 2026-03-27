package t5;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import r5.InterfaceC2604u;
import t5.C2673f;
import t5.C2688m0;
import t5.Q0;

/* JADX INFO: renamed from: t5.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2671e implements InterfaceC2710z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2688m0.b f23736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2673f f23737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2688m0 f23738c;

    /* JADX INFO: renamed from: t5.e$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23739a;

        public a(int i7) {
            this.f23739a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2671e.this.f23738c.T()) {
                return;
            }
            try {
                C2671e.this.f23738c.h(this.f23739a);
            } catch (Throwable th) {
                C2671e.this.f23737b.e(th);
                C2671e.this.f23738c.close();
            }
        }
    }

    /* JADX INFO: renamed from: t5.e$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f23741a;

        public b(y0 y0Var) {
            this.f23741a = y0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C2671e.this.f23738c.G(this.f23741a);
            } catch (Throwable th) {
                C2671e.this.f23737b.e(th);
                C2671e.this.f23738c.close();
            }
        }
    }

    /* JADX INFO: renamed from: t5.e$c */
    public class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f23743a;

        public c(y0 y0Var) {
            this.f23743a = y0Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f23743a.close();
        }
    }

    /* JADX INFO: renamed from: t5.e$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2671e.this.f23738c.A();
        }
    }

    /* JADX INFO: renamed from: t5.e$e, reason: collision with other inner class name */
    public class RunnableC0371e implements Runnable {
        public RunnableC0371e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2671e.this.f23738c.close();
        }
    }

    /* JADX INFO: renamed from: t5.e$f */
    public class f extends g implements Closeable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Closeable f23747d;

        public f(Runnable runnable, Closeable closeable) {
            super(C2671e.this, runnable, null);
            this.f23747d = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f23747d.close();
        }
    }

    /* JADX INFO: renamed from: t5.e$g */
    public class g implements Q0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f23749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23750b;

        public /* synthetic */ g(C2671e c2671e, Runnable runnable, a aVar) {
            this(runnable);
        }

        public final void h() {
            if (this.f23750b) {
                return;
            }
            this.f23749a.run();
            this.f23750b = true;
        }

        @Override // t5.Q0.a
        public InputStream next() {
            h();
            return C2671e.this.f23737b.f();
        }

        public g(Runnable runnable) {
            this.f23750b = false;
            this.f23749a = runnable;
        }
    }

    /* JADX INFO: renamed from: t5.e$h */
    public interface h extends C2673f.d {
    }

    public C2671e(C2688m0.b bVar, h hVar, C2688m0 c2688m0) {
        N0 n02 = new N0((C2688m0.b) H2.m.o(bVar, "listener"));
        this.f23736a = n02;
        C2673f c2673f = new C2673f(n02, hVar);
        this.f23737b = c2673f;
        c2688m0.A0(c2673f);
        this.f23738c = c2688m0;
    }

    @Override // t5.InterfaceC2710z
    public void A() {
        this.f23736a.a(new g(this, new d(), null));
    }

    @Override // t5.InterfaceC2710z
    public void G(y0 y0Var) {
        this.f23736a.a(new f(new b(y0Var), new c(y0Var)));
    }

    @Override // t5.InterfaceC2710z
    public void H(InterfaceC2604u interfaceC2604u) {
        this.f23738c.H(interfaceC2604u);
    }

    @Override // t5.InterfaceC2710z
    public void close() {
        this.f23738c.B0();
        this.f23736a.a(new g(this, new RunnableC0371e(), null));
    }

    @Override // t5.InterfaceC2710z
    public void h(int i7) {
        this.f23736a.a(new g(this, new a(i7), null));
    }

    @Override // t5.InterfaceC2710z
    public void i(int i7) {
        this.f23738c.i(i7);
    }
}
