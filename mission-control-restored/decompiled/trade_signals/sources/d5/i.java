package d5;

import P4.o;
import P4.q;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f16954a;

    public static final class a extends Z4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f16955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator f16956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f16957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f16958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f16959e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f16960f;

        public a(q qVar, Iterator it) {
            this.f16955a = qVar;
            this.f16956b = it;
        }

        public void a() {
            while (!g()) {
                try {
                    this.f16955a.c(X4.b.d(this.f16956b.next(), "The iterator returned a null value"));
                    if (g()) {
                        return;
                    }
                    if (!this.f16956b.hasNext()) {
                        if (g()) {
                            return;
                        }
                        this.f16955a.a();
                        return;
                    }
                } catch (Throwable th) {
                    T4.b.b(th);
                    this.f16955a.onError(th);
                    return;
                }
            }
        }

        @Override // Y4.j
        public void clear() {
            this.f16959e = true;
        }

        @Override // S4.b
        public void dispose() {
            this.f16957c = true;
        }

        @Override // S4.b
        public boolean g() {
            return this.f16957c;
        }

        @Override // Y4.j
        public boolean isEmpty() {
            return this.f16959e;
        }

        @Override // Y4.f
        public int k(int i8) {
            if ((i8 & 1) == 0) {
                return 0;
            }
            this.f16958d = true;
            return 1;
        }

        @Override // Y4.j
        public Object poll() {
            if (this.f16959e) {
                return null;
            }
            if (!this.f16960f) {
                this.f16960f = true;
            } else if (!this.f16956b.hasNext()) {
                this.f16959e = true;
                return null;
            }
            return X4.b.d(this.f16956b.next(), "The iterator returned a null value");
        }
    }

    public i(Iterable iterable) {
        this.f16954a = iterable;
    }

    @Override // P4.o
    public void s(q qVar) {
        try {
            Iterator it = this.f16954a.iterator();
            if (!it.hasNext()) {
                W4.c.i(qVar);
                return;
            }
            a aVar = new a(qVar, it);
            qVar.b(aVar);
            if (aVar.f16958d) {
                return;
            }
            aVar.a();
        } catch (Throwable th) {
            T4.b.b(th);
            W4.c.n(th, qVar);
        }
    }
}
