package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f1 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f17123a;

    public f1(e1 e1Var) {
        this.f17123a = e1Var;
    }

    @Override // ng.m
    public void a(Throwable th) {
        this.f17123a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f17123a + ']';
    }
}
