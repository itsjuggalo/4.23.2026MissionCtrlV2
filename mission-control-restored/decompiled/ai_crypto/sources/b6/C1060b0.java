package b6;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: b6.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1060b0 implements InterfaceC1062c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f9038a;

    public C1060b0(Future future) {
        this.f9038a = future;
    }

    @Override // b6.InterfaceC1062c0
    public void a() {
        this.f9038a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f9038a + ']';
    }
}
