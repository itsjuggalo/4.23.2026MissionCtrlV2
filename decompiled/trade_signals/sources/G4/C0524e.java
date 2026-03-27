package G4;

import F4.InterfaceC0506u;
import G4.C0526f;
import G4.C0541m0;
import G4.Q0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0524e implements InterfaceC0563z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0541m0.b f2773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0526f f2774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0541m0 f2775c;

    /* JADX INFO: renamed from: G4.e$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2776a;

        public a(int i8) {
            this.f2776a = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0524e.this.f2775c.E()) {
                return;
            }
            try {
                C0524e.this.f2775c.e(this.f2776a);
            } catch (Throwable th) {
                C0524e.this.f2774b.e(th);
                C0524e.this.f2775c.close();
            }
        }
    }

    /* JADX INFO: renamed from: G4.e$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f2778a;

        public b(y0 y0Var) {
            this.f2778a = y0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C0524e.this.f2775c.r(this.f2778a);
            } catch (Throwable th) {
                C0524e.this.f2774b.e(th);
                C0524e.this.f2775c.close();
            }
        }
    }

    /* JADX INFO: renamed from: G4.e$c */
    public class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y0 f2780a;

        public c(y0 y0Var) {
            this.f2780a = y0Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f2780a.close();
        }
    }

    /* JADX INFO: renamed from: G4.e$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0524e.this.f2775c.B();
        }
    }

    /* JADX INFO: renamed from: G4.e$e, reason: collision with other inner class name */
    public class RunnableC0035e implements Runnable {
        public RunnableC0035e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0524e.this.f2775c.close();
        }
    }

    /* JADX INFO: renamed from: G4.e$f */
    public class f extends g implements Closeable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Closeable f2784d;

        public f(Runnable runnable, Closeable closeable) {
            super(C0524e.this, runnable, null);
            this.f2784d = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f2784d.close();
        }
    }

    /* JADX INFO: renamed from: G4.e$g */
    public class g implements Q0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f2786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2787b;

        public g(Runnable runnable) {
            this.f2787b = false;
            this.f2786a = runnable;
        }

        public final void a() {
            if (this.f2787b) {
                return;
            }
            this.f2786a.run();
            this.f2787b = true;
        }

        @Override // G4.Q0.a
        public InputStream next() {
            a();
            return C0524e.this.f2774b.f();
        }

        public /* synthetic */ g(C0524e c0524e, Runnable runnable, a aVar) {
            this(runnable);
        }
    }

    /* JADX INFO: renamed from: G4.e$h */
    public interface h extends C0526f.d {
    }

    public C0524e(C0541m0.b bVar, h hVar, C0541m0 c0541m0) {
        N0 n02 = new N0((C0541m0.b) AbstractC2848n.o(bVar, "listener"));
        this.f2773a = n02;
        C0526f c0526f = new C0526f(n02, hVar);
        this.f2774b = c0526f;
        c0541m0.S(c0526f);
        this.f2775c = c0541m0;
    }

    @Override // G4.InterfaceC0563z
    public void B() {
        this.f2773a.a(new g(this, new d(), null));
    }

    @Override // G4.InterfaceC0563z
    public void close() {
        this.f2775c.T();
        this.f2773a.a(new g(this, new RunnableC0035e(), null));
    }

    @Override // G4.InterfaceC0563z
    public void e(int i8) {
        this.f2773a.a(new g(this, new a(i8), null));
    }

    @Override // G4.InterfaceC0563z
    public void f(int i8) {
        this.f2775c.f(i8);
    }

    @Override // G4.InterfaceC0563z
    public void n(InterfaceC0506u interfaceC0506u) {
        this.f2775c.n(interfaceC0506u);
    }

    @Override // G4.InterfaceC0563z
    public void r(y0 y0Var) {
        this.f2773a.a(new f(new b(y0Var), new c(y0Var)));
    }
}
