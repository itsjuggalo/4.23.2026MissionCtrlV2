package M2;

import M2.C0433m0;
import M2.Q0;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: renamed from: M2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0418f implements C0433m0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0433m0.b f2204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue f2205c = new ArrayDeque();

    /* JADX INFO: renamed from: M2.f$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2206a;

        public a(int i4) {
            this.f2206a = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0418f.this.f2204b.d(this.f2206a);
        }
    }

    /* JADX INFO: renamed from: M2.f$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2208a;

        public b(boolean z4) {
            this.f2208a = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0418f.this.f2204b.c(this.f2208a);
        }
    }

    /* JADX INFO: renamed from: M2.f$c */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f2210a;

        public c(Throwable th) {
            this.f2210a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0418f.this.f2204b.e(this.f2210a);
        }
    }

    /* JADX INFO: renamed from: M2.f$d */
    public interface d {
        void f(Runnable runnable);
    }

    public C0418f(C0433m0.b bVar, d dVar) {
        this.f2204b = (C0433m0.b) Z1.m.o(bVar, "listener");
        this.f2203a = (d) Z1.m.o(dVar, "transportExecutor");
    }

    @Override // M2.C0433m0.b
    public void a(Q0.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                this.f2205c.add(next);
            }
        }
    }

    @Override // M2.C0433m0.b
    public void c(boolean z4) {
        this.f2203a.f(new b(z4));
    }

    @Override // M2.C0433m0.b
    public void d(int i4) {
        this.f2203a.f(new a(i4));
    }

    @Override // M2.C0433m0.b
    public void e(Throwable th) {
        this.f2203a.f(new c(th));
    }

    public InputStream f() {
        return (InputStream) this.f2205c.poll();
    }
}
