package qc;

import cc.l;
import cc.n;
import cc.o;
import cc.p;
import cc.q;
import fc.b;
import ic.e;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f19029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f19030b;

    /* JADX INFO: renamed from: qc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0329a extends AtomicReference implements q, l, b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f19031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f19032b;

        public C0329a(q qVar, e eVar) {
            this.f19031a = qVar;
            this.f19032b = eVar;
        }

        @Override // cc.q
        public void a(b bVar) {
            jc.b.h(this, bVar);
        }

        @Override // fc.b
        public boolean c() {
            return jc.b.b((b) get());
        }

        @Override // fc.b
        public void dispose() {
            jc.b.a(this);
        }

        @Override // cc.q
        public void onComplete() {
            this.f19031a.onComplete();
        }

        @Override // cc.q
        public void onError(Throwable th) {
            this.f19031a.onError(th);
        }

        @Override // cc.q
        public void onNext(Object obj) {
            this.f19031a.onNext(obj);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            try {
                ((p) kc.b.d(this.f19032b.apply(obj), "The mapper returned a null Publisher")).b(this);
            } catch (Throwable th) {
                gc.b.b(th);
                this.f19031a.onError(th);
            }
        }
    }

    public a(n nVar, e eVar) {
        this.f19029a = nVar;
        this.f19030b = eVar;
    }

    @Override // cc.o
    public void k(q qVar) {
        C0329a c0329a = new C0329a(qVar, this.f19030b);
        qVar.a(c0329a);
        this.f19029a.a(c0329a);
    }
}
