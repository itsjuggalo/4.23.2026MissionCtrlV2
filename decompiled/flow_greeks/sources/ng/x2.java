package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x2 extends sg.z implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17196e;

    public x2(long j10, gd.e eVar) {
        super(eVar.getContext(), eVar);
        this.f17196e = j10;
    }

    @Override // ng.a, ng.e2
    public String m0() {
        return super.m0() + "(timeMillis=" + this.f17196e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        A(y2.a(this.f17196e, x0.b(getContext()), this));
    }
}
