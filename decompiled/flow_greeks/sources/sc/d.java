package sc;

import cc.s;
import cc.t;
import cc.u;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f20205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f20206b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements t, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f20207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f20208b;

        public a(t tVar, ic.e eVar) {
            this.f20207a = tVar;
            this.f20208b = eVar;
        }

        @Override // cc.t
        public void a(fc.b bVar) {
            if (jc.b.l(this, bVar)) {
                this.f20207a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return jc.b.b((fc.b) get());
        }

        @Override // fc.b
        public void dispose() {
            jc.b.a(this);
        }

        @Override // cc.t
        public void onError(Throwable th) {
            try {
                ((u) kc.b.d(this.f20208b.apply(th), "The nextFunction returned a null SingleSource.")).b(new mc.d(this, this.f20207a));
            } catch (Throwable th2) {
                gc.b.b(th2);
                this.f20207a.onError(new gc.a(th, th2));
            }
        }

        @Override // cc.t
        public void onSuccess(Object obj) {
            this.f20207a.onSuccess(obj);
        }
    }

    public d(u uVar, ic.e eVar) {
        this.f20205a = uVar;
        this.f20206b = eVar;
    }

    @Override // cc.s
    public void j(t tVar) {
        this.f20205a.b(new a(tVar, this.f20206b));
    }
}
