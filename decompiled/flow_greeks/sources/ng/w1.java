package ng;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w1 extends d2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17192f = AtomicIntegerFieldUpdater.newUpdater(w1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pd.k f17193e;

    public w1(pd.k kVar) {
        this.f17193e = kVar;
    }

    @Override // ng.d2
    public boolean u() {
        return true;
    }

    @Override // ng.d2
    public void v(Throwable th) {
        if (f17192f.compareAndSet(this, 0, 1)) {
            this.f17193e.invoke(th);
        }
    }
}
