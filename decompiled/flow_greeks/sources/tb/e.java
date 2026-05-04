package tb;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import tb.f;
import tb.l1;
import tb.p2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class e implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1.b f21195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tb.f f21196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1 f21197c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21198a;

        public a(int i10) {
            this.f21198a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f21197c.isClosed()) {
                return;
            }
            try {
                e.this.f21197c.b(this.f21198a);
            } catch (Throwable th) {
                e.this.f21196b.e(th);
                e.this.f21197c.close();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x1 f21200a;

        public b(x1 x1Var) {
            this.f21200a = x1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f21197c.e(this.f21200a);
            } catch (Throwable th) {
                e.this.f21196b.e(th);
                e.this.f21197c.close();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x1 f21202a;

        public c(x1 x1Var) {
            this.f21202a = x1Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f21202a.close();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f21197c.u();
        }
    }

    /* JADX INFO: renamed from: tb.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class RunnableC0373e implements Runnable {
        public RunnableC0373e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f21197c.close();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f extends g implements Closeable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Closeable f21206d;

        public f(Runnable runnable, Closeable closeable) {
            super(e.this, runnable, null);
            this.f21206d = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f21206d.close();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements p2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f21208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f21209b;

        public /* synthetic */ g(e eVar, Runnable runnable, a aVar) {
            this(runnable);
        }

        public final void b() {
            if (this.f21209b) {
                return;
            }
            this.f21208a.run();
            this.f21209b = true;
        }

        @Override // tb.p2.a
        public InputStream next() {
            b();
            return e.this.f21196b.f();
        }

        public g(Runnable runnable) {
            this.f21209b = false;
            this.f21208a = runnable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface h extends f.d {
    }

    public e(l1.b bVar, h hVar, l1 l1Var) {
        m2 m2Var = new m2((l1.b) p6.n.o(bVar, "listener"));
        this.f21195a = m2Var;
        tb.f fVar = new tb.f(m2Var, hVar);
        this.f21196b = fVar;
        l1Var.a0(fVar);
        this.f21197c = l1Var;
    }

    @Override // tb.z
    public void b(int i10) {
        this.f21195a.a(new g(this, new a(i10), null));
    }

    @Override // tb.z
    public void c(int i10) {
        this.f21197c.c(i10);
    }

    @Override // tb.z
    public void close() {
        this.f21197c.b0();
        this.f21195a.a(new g(this, new RunnableC0373e(), null));
    }

    @Override // tb.z
    public void e(x1 x1Var) {
        this.f21195a.a(new f(new b(x1Var), new c(x1Var)));
    }

    @Override // tb.z
    public void o(rb.u uVar) {
        this.f21197c.o(uVar);
    }

    @Override // tb.z
    public void u() {
        this.f21195a.a(new g(this, new d(), null));
    }
}
