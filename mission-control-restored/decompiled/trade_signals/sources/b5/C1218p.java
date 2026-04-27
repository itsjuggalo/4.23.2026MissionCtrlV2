package b5;

import i5.C1931e;

/* JADX INFO: renamed from: b5.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1218p extends P4.f implements Y4.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13101b;

    public C1218p(Object obj) {
        this.f13101b = obj;
    }

    @Override // P4.f
    public void I(x7.b bVar) {
        bVar.d(new C1931e(bVar, this.f13101b));
    }

    @Override // Y4.h, java.util.concurrent.Callable
    public Object call() {
        return this.f13101b;
    }
}
