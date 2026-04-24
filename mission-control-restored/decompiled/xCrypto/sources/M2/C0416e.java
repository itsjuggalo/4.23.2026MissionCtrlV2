package M2;

import K2.InterfaceC0372u;
import M2.C0418f;
import M2.C0433m0;
import M2.Q0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: M2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0416e implements InterfaceC0455z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0433m0.b f2185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0418f f2186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0433m0 f2187c;

    /* JADX INFO: renamed from: M2.e$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2188a;

        public a(int i4) {
            this.f2188a = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0416e.this.f2187c.J()) {
                return;
            }
            try {
                C0416e.this.f2187c.e(this.f2188a);
            } catch (Throwable th) {
                C0416e.this.f2186b.e(th);
                C0416e.this.f2187c.close();
            }
        }
    }

    /* JADX INFO: renamed from: M2.e$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f2190a;

        public b(y0 y0Var) {
            this.f2190a = y0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C0416e.this.f2187c.g(this.f2190a);
            } catch (Throwable th) {
                C0416e.this.f2186b.e(th);
                C0416e.this.f2187c.close();
            }
        }
    }

    /* JADX INFO: renamed from: M2.e$c */
    public class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f2192a;

        public c(y0 y0Var) {
            this.f2192a = y0Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f2192a.close();
        }
    }

    /* JADX INFO: renamed from: M2.e$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0416e.this.f2187c.p();
        }
    }

    /* JADX INFO: renamed from: M2.e$e, reason: collision with other inner class name */
    public class RunnableC0044e implements Runnable {
        public RunnableC0044e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0416e.this.f2187c.close();
        }
    }

    /* JADX INFO: renamed from: M2.e$f */
    public class f extends g implements Closeable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Closeable f2196d;

        public f(Runnable runnable, Closeable closeable) {
            super(C0416e.this, runnable, null);
            this.f2196d = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f2196d.close();
        }
    }

    /* JADX INFO: renamed from: M2.e$g */
    public class g implements Q0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f2198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2199b;

        public /* synthetic */ g(C0416e c0416e, Runnable runnable, a aVar) {
            this(runnable);
        }

        public final void e() {
            if (this.f2199b) {
                return;
            }
            this.f2198a.run();
            this.f2199b = true;
        }

        @Override // M2.Q0.a
        public InputStream next() {
            e();
            return C0416e.this.f2186b.f();
        }

        public g(Runnable runnable) {
            this.f2199b = false;
            this.f2198a = runnable;
        }
    }

    /* JADX INFO: renamed from: M2.e$h */
    public interface h extends C0418f.d {
    }

    public C0416e(C0433m0.b bVar, h hVar, C0433m0 c0433m0) {
        N0 n02 = new N0((C0433m0.b) Z1.m.o(bVar, "listener"));
        this.f2185a = n02;
        C0418f c0418f = new C0418f(n02, hVar);
        this.f2186b = c0418f;
        c0433m0.f0(c0418f);
        this.f2187c = c0433m0;
    }

    @Override // M2.InterfaceC0455z
    public void close() {
        this.f2187c.g0();
        this.f2185a.a(new g(this, new RunnableC0044e(), null));
    }

    @Override // M2.InterfaceC0455z
    public void e(int i4) {
        this.f2185a.a(new g(this, new a(i4), null));
    }

    @Override // M2.InterfaceC0455z
    public void f(int i4) {
        this.f2187c.f(i4);
    }

    @Override // M2.InterfaceC0455z
    public void g(y0 y0Var) {
        this.f2185a.a(new f(new b(y0Var), new c(y0Var)));
    }

    @Override // M2.InterfaceC0455z
    public void p() {
        this.f2185a.a(new g(this, new d(), null));
    }

    @Override // M2.InterfaceC0455z
    public void x(InterfaceC0372u interfaceC0372u) {
        this.f2187c.x(interfaceC0372u);
    }
}
