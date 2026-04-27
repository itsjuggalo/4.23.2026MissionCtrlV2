package G4;

import G4.C0541m0;
import G4.Q0;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0526f implements C0541m0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0541m0.b f2792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue f2793c = new ArrayDeque();

    /* JADX INFO: renamed from: G4.f$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2794a;

        public a(int i8) {
            this.f2794a = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0526f.this.f2792b.d(this.f2794a);
        }
    }

    /* JADX INFO: renamed from: G4.f$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2796a;

        public b(boolean z7) {
            this.f2796a = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0526f.this.f2792b.c(this.f2796a);
        }
    }

    /* JADX INFO: renamed from: G4.f$c */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f2798a;

        public c(Throwable th) {
            this.f2798a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0526f.this.f2792b.e(this.f2798a);
        }
    }

    /* JADX INFO: renamed from: G4.f$d */
    public interface d {
        void f(Runnable runnable);
    }

    public C0526f(C0541m0.b bVar, d dVar) {
        this.f2792b = (C0541m0.b) AbstractC2848n.o(bVar, "listener");
        this.f2791a = (d) AbstractC2848n.o(dVar, "transportExecutor");
    }

    @Override // G4.C0541m0.b
    public void a(Q0.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                this.f2793c.add(next);
            }
        }
    }

    @Override // G4.C0541m0.b
    public void c(boolean z7) {
        this.f2791a.f(new b(z7));
    }

    @Override // G4.C0541m0.b
    public void d(int i8) {
        this.f2791a.f(new a(i8));
    }

    @Override // G4.C0541m0.b
    public void e(Throwable th) {
        this.f2791a.f(new c(th));
    }

    public InputStream f() {
        return (InputStream) this.f2793c.poll();
    }
}
