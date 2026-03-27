package d5;

import P4.p;
import P4.q;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends AbstractC1637a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.e f16962b;

    public static final class a extends Z4.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final V4.e f16963f;

        public a(q qVar, V4.e eVar) {
            super(qVar);
            this.f16963f = eVar;
        }

        @Override // P4.q
        public void c(Object obj) {
            if (this.f9763d) {
                return;
            }
            if (this.f9764e != 0) {
                this.f9760a.c(null);
                return;
            }
            try {
                this.f9760a.c(X4.b.d(this.f16963f.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                f(th);
            }
        }

        @Override // Y4.f
        public int k(int i8) {
            return h(i8);
        }

        @Override // Y4.j
        public Object poll() {
            Object objPoll = this.f9762c.poll();
            if (objPoll != null) {
                return X4.b.d(this.f16963f.apply(objPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public k(p pVar, V4.e eVar) {
        super(pVar);
        this.f16962b = eVar;
    }

    @Override // P4.o
    public void s(q qVar) {
        this.f16891a.d(new a(qVar, this.f16962b));
    }
}
