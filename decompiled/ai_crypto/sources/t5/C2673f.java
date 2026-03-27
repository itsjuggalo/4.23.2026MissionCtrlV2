package t5;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import t5.C2688m0;
import t5.Q0;

/* JADX INFO: renamed from: t5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2673f implements C2688m0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f23754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2688m0.b f23755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue f23756c = new ArrayDeque();

    /* JADX INFO: renamed from: t5.f$a */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23757a;

        public a(int i7) {
            this.f23757a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2673f.this.f23755b.d(this.f23757a);
        }
    }

    /* JADX INFO: renamed from: t5.f$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f23759a;

        public b(boolean z7) {
            this.f23759a = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2673f.this.f23755b.c(this.f23759a);
        }
    }

    /* JADX INFO: renamed from: t5.f$c */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f23761a;

        public c(Throwable th) {
            this.f23761a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2673f.this.f23755b.e(this.f23761a);
        }
    }

    /* JADX INFO: renamed from: t5.f$d */
    public interface d {
        void f(Runnable runnable);
    }

    public C2673f(C2688m0.b bVar, d dVar) {
        this.f23755b = (C2688m0.b) H2.m.o(bVar, "listener");
        this.f23754a = (d) H2.m.o(dVar, "transportExecutor");
    }

    @Override // t5.C2688m0.b
    public void a(Q0.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                this.f23756c.add(next);
            }
        }
    }

    @Override // t5.C2688m0.b
    public void c(boolean z7) {
        this.f23754a.f(new b(z7));
    }

    @Override // t5.C2688m0.b
    public void d(int i7) {
        this.f23754a.f(new a(i7));
    }

    @Override // t5.C2688m0.b
    public void e(Throwable th) {
        this.f23754a.f(new c(th));
    }

    public InputStream f() {
        return (InputStream) this.f23756c.poll();
    }
}
