package a5;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: a5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1074a extends P4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P4.d[] f9965a;

    /* JADX INFO: renamed from: a5.a$a, reason: collision with other inner class name */
    public static final class C0168a extends AtomicInteger implements P4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.c f9966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final P4.d[] f9967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final W4.e f9969d = new W4.e();

        public C0168a(P4.c cVar, P4.d[] dVarArr) {
            this.f9966a = cVar;
            this.f9967b = dVarArr;
        }

        @Override // P4.c
        public void a() {
            c();
        }

        @Override // P4.c
        public void b(S4.b bVar) {
            this.f9969d.a(bVar);
        }

        public void c() {
            if (!this.f9969d.g() && getAndIncrement() == 0) {
                P4.d[] dVarArr = this.f9967b;
                while (!this.f9969d.g()) {
                    int i8 = this.f9968c;
                    this.f9968c = i8 + 1;
                    if (i8 == dVarArr.length) {
                        this.f9966a.a();
                        return;
                    } else {
                        dVarArr[i8].b(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // P4.c
        public void onError(Throwable th) {
            this.f9966a.onError(th);
        }
    }

    public C1074a(P4.d[] dVarArr) {
        this.f9965a = dVarArr;
    }

    @Override // P4.b
    public void p(P4.c cVar) {
        C0168a c0168a = new C0168a(cVar, this.f9965a);
        cVar.b(c0168a.f9969d);
        c0168a.c();
    }
}
