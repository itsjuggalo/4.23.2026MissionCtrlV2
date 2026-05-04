package ng;

import java.util.concurrent.CancellationException;
import ng.y1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k2 extends gd.a implements y1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k2 f17153b = new k2();

    public k2() {
        super(y1.N);
    }

    @Override // ng.y1
    public u attachChild(w wVar) {
        return l2.f17156a;
    }

    @Override // ng.y1
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // ng.y1
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // ng.y1
    public jg.h getChildren() {
        return jg.q.i();
    }

    @Override // ng.y1
    public vg.a getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // ng.y1
    public y1 getParent() {
        return null;
    }

    @Override // ng.y1
    public e1 invokeOnCompletion(pd.k kVar) {
        return l2.f17156a;
    }

    @Override // ng.y1
    public boolean isActive() {
        return true;
    }

    @Override // ng.y1
    public boolean isCancelled() {
        return false;
    }

    @Override // ng.y1
    public boolean isCompleted() {
        return false;
    }

    @Override // ng.y1
    public Object join(gd.e eVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // ng.y1
    public y1 plus(y1 y1Var) {
        return y1.a.g(this, y1Var);
    }

    @Override // ng.y1
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // ng.y1
    public void cancel(CancellationException cancellationException) {
    }

    @Override // ng.y1
    public e1 invokeOnCompletion(boolean z10, boolean z11, pd.k kVar) {
        return l2.f17156a;
    }

    @Override // ng.y1
    public /* synthetic */ boolean cancel(Throwable th) {
        return false;
    }
}
