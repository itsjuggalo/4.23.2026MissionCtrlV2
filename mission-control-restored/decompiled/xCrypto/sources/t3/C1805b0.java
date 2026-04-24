package t3;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: t3.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1805b0 implements InterfaceC1807c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f14980a;

    public C1805b0(Future future) {
        this.f14980a = future;
    }

    @Override // t3.InterfaceC1807c0
    public void dispose() {
        this.f14980a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f14980a + ']';
    }
}
