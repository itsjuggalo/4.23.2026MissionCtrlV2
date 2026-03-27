package Y6;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: Y6.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1011j implements InterfaceC1013k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f9674a;

    public C1011j(Future future) {
        this.f9674a = future;
    }

    @Override // Y6.InterfaceC1013k
    public void a(Throwable th) {
        this.f9674a.cancel(false);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f9674a + ']';
    }
}
