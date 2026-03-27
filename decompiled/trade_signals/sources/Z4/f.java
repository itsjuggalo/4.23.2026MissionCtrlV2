package Z4;

import P4.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f9767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f9768b;

    public f(AtomicReference atomicReference, t tVar) {
        this.f9767a = atomicReference;
        this.f9768b = tVar;
    }

    @Override // P4.t
    public void b(S4.b bVar) {
        W4.b.i(this.f9767a, bVar);
    }

    @Override // P4.t
    public void onError(Throwable th) {
        this.f9768b.onError(th);
    }

    @Override // P4.t
    public void onSuccess(Object obj) {
        this.f9768b.onSuccess(obj);
    }
}
