package d5;

import P4.p;
import P4.q;
import k5.AbstractC2283a;

/* JADX INFO: renamed from: d5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1638b extends AbstractC1637a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.g f16892b;

    /* JADX INFO: renamed from: d5.b$a */
    public static final class a implements q, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f16893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.g f16894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f16895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f16896d;

        public a(q qVar, V4.g gVar) {
            this.f16893a = qVar;
            this.f16894b = gVar;
        }

        @Override // P4.q
        public void a() {
            if (this.f16896d) {
                return;
            }
            this.f16896d = true;
            this.f16893a.c(Boolean.FALSE);
            this.f16893a.a();
        }

        @Override // P4.q
        public void b(S4.b bVar) {
            if (W4.b.n(this.f16895c, bVar)) {
                this.f16895c = bVar;
                this.f16893a.b(this);
            }
        }

        @Override // P4.q
        public void c(Object obj) {
            if (this.f16896d) {
                return;
            }
            try {
                if (this.f16894b.test(obj)) {
                    this.f16896d = true;
                    this.f16895c.dispose();
                    this.f16893a.c(Boolean.TRUE);
                    this.f16893a.a();
                }
            } catch (Throwable th) {
                T4.b.b(th);
                this.f16895c.dispose();
                onError(th);
            }
        }

        @Override // S4.b
        public void dispose() {
            this.f16895c.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return this.f16895c.g();
        }

        @Override // P4.q
        public void onError(Throwable th) {
            if (this.f16896d) {
                AbstractC2283a.q(th);
            } else {
                this.f16896d = true;
                this.f16893a.onError(th);
            }
        }
    }

    public C1638b(p pVar, V4.g gVar) {
        super(pVar);
        this.f16892b = gVar;
    }

    @Override // P4.o
    public void s(q qVar) {
        this.f16891a.d(new a(qVar, this.f16892b));
    }
}
