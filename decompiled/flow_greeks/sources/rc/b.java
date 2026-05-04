package rc;

import cc.p;
import cc.q;
import cc.s;
import cc.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f19785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.g f19786b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements q, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f19787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.g f19788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fc.b f19789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19790d;

        public a(t tVar, ic.g gVar) {
            this.f19787a = tVar;
            this.f19788b = gVar;
        }

        @Override // cc.q
        public void a(fc.b bVar) {
            if (jc.b.m(this.f19789c, bVar)) {
                this.f19789c = bVar;
                this.f19787a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f19789c.c();
        }

        @Override // fc.b
        public void dispose() {
            this.f19789c.dispose();
        }

        @Override // cc.q
        public void onComplete() {
            if (this.f19790d) {
                return;
            }
            this.f19790d = true;
            this.f19787a.onSuccess(Boolean.FALSE);
        }

        @Override // cc.q
        public void onError(Throwable th) {
            if (this.f19790d) {
                yc.a.q(th);
            } else {
                this.f19790d = true;
                this.f19787a.onError(th);
            }
        }

        @Override // cc.q
        public void onNext(Object obj) {
            if (this.f19790d) {
                return;
            }
            try {
                if (this.f19788b.test(obj)) {
                    this.f19790d = true;
                    this.f19789c.dispose();
                    this.f19787a.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                gc.b.b(th);
                this.f19789c.dispose();
                onError(th);
            }
        }
    }

    public b(p pVar, ic.g gVar) {
        this.f19785a = pVar;
        this.f19786b = gVar;
    }

    @Override // cc.s
    public void j(t tVar) {
        this.f19785a.b(new a(tVar, this.f19786b));
    }
}
