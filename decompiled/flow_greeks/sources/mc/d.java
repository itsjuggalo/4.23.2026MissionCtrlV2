package mc;

import cc.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f16422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f16423b;

    public d(AtomicReference atomicReference, t tVar) {
        this.f16422a = atomicReference;
        this.f16423b = tVar;
    }

    @Override // cc.t
    public void a(fc.b bVar) {
        jc.b.h(this.f16422a, bVar);
    }

    @Override // cc.t
    public void onError(Throwable th) {
        this.f16423b.onError(th);
    }

    @Override // cc.t
    public void onSuccess(Object obj) {
        this.f16423b.onSuccess(obj);
    }
}
