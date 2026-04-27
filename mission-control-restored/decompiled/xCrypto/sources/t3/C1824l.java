package t3;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: t3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1824l extends AbstractC1826m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f15019a;

    public C1824l(Future future) {
        this.f15019a = future;
    }

    @Override // t3.AbstractC1828n
    public void a(Throwable th) {
        if (th != null) {
            this.f15019a.cancel(false);
        }
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return W2.E.f5463a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f15019a + ']';
    }
}
