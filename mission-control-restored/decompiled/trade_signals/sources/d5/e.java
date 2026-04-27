package d5;

import P4.p;
import P4.q;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends AbstractC1637a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.g f16904b;

    public static final class a extends Z4.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final V4.g f16905f;

        public a(q qVar, V4.g gVar) {
            super(qVar);
            this.f16905f = gVar;
        }

        @Override // P4.q
        public void c(Object obj) {
            if (this.f9764e != 0) {
                this.f9760a.c(null);
                return;
            }
            try {
                if (this.f16905f.test(obj)) {
                    this.f9760a.c(obj);
                }
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
            Object objPoll;
            do {
                objPoll = this.f9762c.poll();
                if (objPoll == null) {
                    break;
                }
            } while (!this.f16905f.test(objPoll));
            return objPoll;
        }
    }

    public e(p pVar, V4.g gVar) {
        super(pVar);
        this.f16904b = gVar;
    }

    @Override // P4.o
    public void s(q qVar) {
        this.f16891a.d(new a(qVar, this.f16904b));
    }
}
