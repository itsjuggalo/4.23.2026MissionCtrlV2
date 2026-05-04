package tb;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import tb.l1;
import tb.p2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements l1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1.b f21221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue f21222c = new ArrayDeque();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21223a;

        public a(int i10) {
            this.f21223a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f21221b.d(this.f21223a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21225a;

        public b(boolean z10) {
            this.f21225a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f21221b.c(this.f21225a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f21227a;

        public c(Throwable th) {
            this.f21227a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f21221b.e(this.f21227a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        void f(Runnable runnable);
    }

    public f(l1.b bVar, d dVar) {
        this.f21221b = (l1.b) p6.n.o(bVar, "listener");
        this.f21220a = (d) p6.n.o(dVar, "transportExecutor");
    }

    @Override // tb.l1.b
    public void a(p2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                this.f21222c.add(next);
            }
        }
    }

    @Override // tb.l1.b
    public void c(boolean z10) {
        this.f21220a.f(new b(z10));
    }

    @Override // tb.l1.b
    public void d(int i10) {
        this.f21220a.f(new a(i10));
    }

    @Override // tb.l1.b
    public void e(Throwable th) {
        this.f21220a.f(new c(th));
    }

    public InputStream f() {
        return (InputStream) this.f21222c.poll();
    }
}
