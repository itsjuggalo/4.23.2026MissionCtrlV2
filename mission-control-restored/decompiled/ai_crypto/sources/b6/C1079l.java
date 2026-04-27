package b6;

import java.util.concurrent.Future;

/* JADX INFO: renamed from: b6.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1079l extends AbstractC1081m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future f9077a;

    public C1079l(Future future) {
        this.f9077a = future;
    }

    @Override // b6.AbstractC1083n
    public void a(Throwable th) {
        if (th != null) {
            this.f9077a.cancel(false);
        }
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return E5.E.f1657a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f9077a + ']';
    }
}
