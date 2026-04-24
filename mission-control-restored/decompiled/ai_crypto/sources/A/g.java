package A;

import A.f;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f48m;

    public g(m mVar) {
        super(mVar);
        if (mVar instanceof j) {
            this.f31e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f31e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // A.f
    public void d(int i7) {
        if (this.f36j) {
            return;
        }
        this.f36j = true;
        this.f33g = i7;
        for (d dVar : this.f37k) {
            dVar.a(dVar);
        }
    }
}
