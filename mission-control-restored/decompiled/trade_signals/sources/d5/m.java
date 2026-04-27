package d5;

import P4.p;
import P4.q;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends AbstractC1637a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f16968b;

    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f16969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f16970b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f16972d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final W4.e f16971c = new W4.e();

        public a(q qVar, p pVar) {
            this.f16969a = qVar;
            this.f16970b = pVar;
        }

        @Override // P4.q
        public void a() {
            if (!this.f16972d) {
                this.f16969a.a();
            } else {
                this.f16972d = false;
                this.f16970b.d(this);
            }
        }

        @Override // P4.q
        public void b(S4.b bVar) {
            this.f16971c.b(bVar);
        }

        @Override // P4.q
        public void c(Object obj) {
            if (this.f16972d) {
                this.f16972d = false;
            }
            this.f16969a.c(obj);
        }

        @Override // P4.q
        public void onError(Throwable th) {
            this.f16969a.onError(th);
        }
    }

    public m(p pVar, p pVar2) {
        super(pVar);
        this.f16968b = pVar2;
    }

    @Override // P4.o
    public void s(q qVar) {
        a aVar = new a(qVar, this.f16968b);
        qVar.b(aVar.f16971c);
        this.f16891a.d(aVar);
    }
}
