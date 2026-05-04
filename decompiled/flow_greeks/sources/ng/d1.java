package ng;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f17083a;

    public d1(Future future) {
        this.f17083a = future;
    }

    @Override // ng.e1
    public void dispose() {
        this.f17083a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f17083a + ']';
    }
}
