package ng;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f17154a;

    public l(Future future) {
        this.f17154a = future;
    }

    @Override // ng.m
    public void a(Throwable th) {
        this.f17154a.cancel(false);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f17154a + ']';
    }
}
