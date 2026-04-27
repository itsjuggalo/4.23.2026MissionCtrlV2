package d5;

import P4.p;
import P4.q;
import j5.C2226c;
import java.util.concurrent.atomic.AtomicReference;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbstractC1637a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.e f16933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16934c;

    public g(p pVar, V4.e eVar, boolean z7) {
        super(pVar);
        this.f16933b = eVar;
        this.f16934c = z7;
    }

    @Override // P4.o
    public void s(q qVar) {
        this.f16891a.d(new a(qVar, this.f16933b, this.f16934c));
    }

    public static final class a extends Z4.b implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f16935a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final V4.e f16937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f16938d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public S4.b f16940f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f16941g;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2226c f16936b = new C2226c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final S4.a f16939e = new S4.a();

        /* JADX INFO: renamed from: d5.g$a$a, reason: collision with other inner class name */
        public final class C0285a extends AtomicReference implements P4.c, S4.b {
            public C0285a() {
            }

            @Override // P4.c
            public void a() {
                a.this.d(this);
            }

            @Override // P4.c
            public void b(S4.b bVar) {
                W4.b.m(this, bVar);
            }

            @Override // S4.b
            public void dispose() {
                W4.b.a(this);
            }

            @Override // S4.b
            public boolean g() {
                return W4.b.b((S4.b) get());
            }

            @Override // P4.c
            public void onError(Throwable th) {
                a.this.e(this, th);
            }
        }

        public a(q qVar, V4.e eVar, boolean z7) {
            this.f16935a = qVar;
            this.f16937c = eVar;
            this.f16938d = z7;
            lazySet(1);
        }

        @Override // P4.q
        public void a() {
            if (decrementAndGet() == 0) {
                Throwable thB = this.f16936b.b();
                if (thB != null) {
                    this.f16935a.onError(thB);
                } else {
                    this.f16935a.a();
                }
            }
        }

        @Override // P4.q
        public void b(S4.b bVar) {
            if (W4.b.n(this.f16940f, bVar)) {
                this.f16940f = bVar;
                this.f16935a.b(this);
            }
        }

        @Override // P4.q
        public void c(Object obj) {
            try {
                P4.d dVar = (P4.d) X4.b.d(this.f16937c.apply(obj), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0285a c0285a = new C0285a();
                if (this.f16941g || !this.f16939e.a(c0285a)) {
                    return;
                }
                dVar.b(c0285a);
            } catch (Throwable th) {
                T4.b.b(th);
                this.f16940f.dispose();
                onError(th);
            }
        }

        public void d(C0285a c0285a) {
            this.f16939e.c(c0285a);
            a();
        }

        @Override // S4.b
        public void dispose() {
            this.f16941g = true;
            this.f16940f.dispose();
            this.f16939e.dispose();
        }

        public void e(C0285a c0285a, Throwable th) {
            this.f16939e.c(c0285a);
            onError(th);
        }

        @Override // S4.b
        public boolean g() {
            return this.f16940f.g();
        }

        @Override // Y4.j
        public boolean isEmpty() {
            return true;
        }

        @Override // Y4.f
        public int k(int i8) {
            return i8 & 2;
        }

        @Override // P4.q
        public void onError(Throwable th) {
            if (!this.f16936b.a(th)) {
                AbstractC2283a.q(th);
                return;
            }
            if (!this.f16938d) {
                dispose();
                if (getAndSet(0) <= 0) {
                    return;
                }
            } else if (decrementAndGet() != 0) {
                return;
            }
            this.f16935a.onError(this.f16936b.b());
        }

        @Override // Y4.j
        public Object poll() {
            return null;
        }

        @Override // Y4.j
        public void clear() {
        }
    }
}
